package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume resume) {
        if (!isExistResume(resume)) {
            saveToStorage(resume);
            System.out.println("You have recorded resume with " + resume.getUuid());
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    protected boolean isExistResume(Resume resume) {
        return (getIndex(resume.getUuid()) >= 0);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveToStorage(Resume resume);

    public final Resume get(String uuid) throws NotExistStorageException {
        if (getIndex(uuid) >= 0) {
            if (isExistResume(getResume(uuid, getIndex(uuid)))) {
                return getResume(uuid, getIndex(uuid));
            }
        }
        throw new NotExistStorageException(uuid);
    }

    protected abstract Resume getResume(String uuid, int index);

    public final void update(Resume resume) throws NotExistStorageException {
        if (isExistResume(resume)) {
            updateResume(resume, getIndex(resume.getUuid()));
            System.out.println("You have updated resume with " + resume.getUuid());
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract void updateResume(Resume resume, int index);

    public final void delete(String uuid) throws NotExistStorageException {
        if (isExistResume(get(uuid))) {
            deleteResume(uuid, getIndex(uuid));
            System.out.println("You have deleted resume with " + uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void deleteResume(String uuid, int index);

    public final void clear() {
        clearStorage();
        System.out.println("You have cleared the resume storage.");
    }

    protected abstract void clearStorage();
}
