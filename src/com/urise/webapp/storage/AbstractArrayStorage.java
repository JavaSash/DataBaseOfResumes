package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final int size() {
        return size;
    }

    @Override
    protected boolean checkEnoughtSpace() {
        return (size < STORAGE_LIMIT);
    }

    @Override
    protected boolean checkIsExistResume(Resume resume) {
        return !(getIndex(resume.getUuid()) < 0);
    }

    public final Resume get(String uuid) throws NotExistStorageException {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
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
}
