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

    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            super.save(resume);
        } else {
            throw new StorageException("Хранилище переполнено", resume.getUuid());
        }
    }

    @Override
    protected boolean checkIsExistResume(Resume resume) {
        return !(getIndex(resume.getUuid()) < 0);
    }

    @Override
    protected Resume searchResume(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        return null;
    }

    @Override
    protected void updateResume(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    @Override
    protected final void deleteResume(String uuid) {
        int index = getIndex(uuid);
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Вы очистили хранилище резюме.");
    }

    protected abstract int getIndex(String uuid);
}
