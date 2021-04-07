package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (!isExistResume(index)) {
            saveToStorage(resume, index);
            System.out.println("You have recorded resume with " + uuid);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected boolean isExistResume(int index) {
        return (index >= 0);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveToStorage(Resume resume, int index);

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isExistResume(index)) {
            return getResume(index);
        }
        throw new NotExistStorageException(uuid);
    }

    protected abstract Resume getResume(int index);

    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (isExistResume(index)) {
            updateResume(resume, index);
            System.out.println("You have updated resume with " + uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void updateResume(Resume resume, int index);

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (isExistResume(index)) {
            deleteResume(index);
            System.out.println("You have deleted resume with " + uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void deleteResume(int index);

    public final void clear() {
        clearStorage();
        System.out.println("You have cleared the resume storage.");
    }

    protected abstract void clearStorage();
}