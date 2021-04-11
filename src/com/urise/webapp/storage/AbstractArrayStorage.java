package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected void saveToStorage(Resume resume, Object key) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, (Integer) key);
            size++;
        } else {
            throw new StorageException("The storage is overflow.", resume.getUuid());
        }
    }

    protected abstract void saveToArray(Resume resume, int index);

    @Override
    protected boolean isExist(Object key) {
        if ((Integer) key >= 0)
            return true;
        return false;
    }

    @Override
    protected Resume getResume(Object key) {
        return storage[(Integer) key];
    }

    @Override
    protected void updateResume(Resume resume, Object key) {
        storage[(Integer) key] = resume;
    }

    @Override
    protected final void deleteResume(Object key) {
        int index = (Integer) key;
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
}