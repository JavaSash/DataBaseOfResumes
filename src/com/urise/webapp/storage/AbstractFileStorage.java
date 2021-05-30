package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) throws IllegalAccessException {
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalAccessException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalAccessException(directory.getAbsolutePath() + " is not readable/writeable");
        }
        this.directory = directory;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        updateResume(resume, file);
    }

    protected abstract void writeTo(Resume resume, File file) throws IOException;

    protected abstract Resume readResume(File file) throws IOException;
    //Вариант реализации readResume:
//    protected abstract Resume readResume(File file) throws IOException {
//        try {
//            // Coздaem oбъekт FileInputStream для дocтyпa k фaйлy
//            FileInputStream fin = new FileInputStream(directory.getAbsolutePath());
//            // Coздaem oбъekт ObjectInputStream для чтeния cepиaлизoвaннoгo oбъekтa
//            ObjectInputStream ois = new ObjectInputStream(fin);
//            for (File resumeFile : Objects.requireNonNull(directory.listFiles())) {
//                if (resumeFile.equals(file)) {
//                    // Вoccтaнaвливaem cocтoяниe oбъekтa из фaйлa
//                    return (Resume) ois.readObject();
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("File Not Found", e);
//        } catch (IOException e) {
//            throw new RuntimeException("IOException", e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Class Not Found", e);
//        }
//        return null;
//    }

    @Override
    protected Resume getResume(File file) {
        try {
            return readResume(file);
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void updateResume(Resume resume, File file) {
        try {
            writeTo(resume, file);
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected void deleteResume(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
        file.delete();
    }

    @Override
    protected void clearStorage() {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            deleteResume(file);
        }
    }

    @Override
    protected List<Resume> toList() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }

        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(getResume(file));
        }
        return list;
    }

    @Override
    public int size() {
        return (int) directory.length();
    }
}