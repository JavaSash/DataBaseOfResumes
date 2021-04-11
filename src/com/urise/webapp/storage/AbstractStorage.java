package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = searchNotExistKey(uuid);
        saveToStorage(resume, searchKey);
        System.out.println("You have recorded resume with " + uuid);
    }

    private Object searchNotExistKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey))
            return searchKey;
        throw new ExistStorageException(uuid);
    }

    protected abstract boolean isExist(Object key);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void saveToStorage(Resume resume, Object key);

    public final Resume get(String uuid) {
        return getResume(searchExistKey(uuid));
    }

    private Object searchExistKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey))
            return searchKey;
        throw new NotExistStorageException(uuid);
    }

    protected abstract Resume getResume(Object key);

    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        updateResume(resume, searchExistKey(uuid));
        System.out.println("You have updated resume with " + uuid);
    }

    protected abstract void updateResume(Resume resume, Object key);

    public final void delete(String uuid) {
        deleteResume(searchExistKey(uuid));
        System.out.println("You have deleted resume with " + uuid);
    }

    protected abstract void deleteResume(Object key);

    public final void clear() {
        clearStorage();
        System.out.println("You have cleared the resume storage.");
    }

    protected abstract void clearStorage();
}