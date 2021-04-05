package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final int size() {
        return size;
    }

    protected void saveToStorage(Resume resume, int index) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, index);
            size++;
        } else {
            throw new StorageException("The storage is overflow.", resume.getUuid());
        }
    }

    protected abstract void saveToArray(Resume resume, int index);

    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    protected final void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
}