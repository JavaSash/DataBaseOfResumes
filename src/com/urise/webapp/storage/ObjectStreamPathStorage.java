package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamPathStorage extends AbstractPathStorage {
    protected ObjectStreamPathStorage(String dir) throws IllegalAccessException {
        super(dir);
    }

    @Override
    public void writeTo(Resume resume, Object path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream((Path) path));
        oos.writeObject(resume);
    }

    @Override
    public Resume readResume(Object path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream((Path) path))) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
