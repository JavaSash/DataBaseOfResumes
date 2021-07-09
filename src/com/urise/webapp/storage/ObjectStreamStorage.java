package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage {
    protected ObjectStreamStorage(File directory) throws IllegalAccessException {
        super(directory);
    }

    @Override
    public void writeTo(Resume resume, Object outputStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream((OutputStream) outputStream);
        oos.writeObject(resume);
    }

    @Override
    public Resume readResume(Object inputStream) throws IOException {
        ObjectInputStream ois = new ObjectInputStream((InputStream) inputStream);
        try {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
