package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.strategy.StrategySwitcher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private StrategySwitcher switcher;

    protected PathStorage(String dir, StrategySwitcher switcher) throws IllegalAccessException {
        Objects.requireNonNull(dir, "Directory must not be null");
        Objects.requireNonNull(switcher, "StrategySwitcher must not be null");
        if (!(new File(dir).isDirectory())) {
            throw new IllegalAccessException(dir + " is not directory");
        }

        if (!Files.isReadable(Paths.get(dir)) || !Files.isWritable(Paths.get(dir))) {
            throw new IllegalAccessException(dir + " is not readable/writeable");
        }
        directory = Paths.get(dir);
        this.switcher = switcher;
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return Paths.get(uuid);
    }

    @Override
    protected void saveResume(Resume resume, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + path.getParent(), String.valueOf(path.getFileName()), e);
        }
        updateResume(resume, path);
    }

    @Override
    protected Resume getResume(Path path) {
        try {
            return switcher.readResume(new BufferedInputStream(new ObjectInputStream(Files.newInputStream(path))));
        } catch (IOException e) {
            throw new StorageException("File read error", String.valueOf(path.getFileName()), e);
        }
    }

    @Override
    protected void updateResume(Resume resume, Path path) {
        try {
            switcher.writeTo(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("File delete error", String.valueOf(path));
        }
    }

    @Override
    protected void clearStorage() {
        try {
            Files.list(directory).forEach(this::deleteResume);
        } catch (IOException e) {
            throw new StorageException("File delete error", null);
        }
    }

    @Override
    protected List<Resume> toList() {
        File[] files = new File(String.valueOf(directory)).listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }

        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(getResume(Paths.get(file.getPath())));
        }
        return list;
    }

    //Размер в байтах
    @Override
    public int size() {
        try {
            return (int) Files.size(directory);
        } catch (IOException e) {
            throw new StorageException("Getting size error", String.valueOf(directory));
        }

    }
}

