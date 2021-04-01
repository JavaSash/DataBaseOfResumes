package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume resume) {
        String uuid = resume.getUuid();
        if (!isExistResume(uuid)) {
            saveToStorage(resume);
            System.out.println("You have recorded resume with " + uuid);
        } else {
            catchingException(new ExistStorageException(uuid));
        }
    }

    private void catchingException(Exception exception) {
        try {
            throw new Exception();
        } catch (Exception exc) {
            System.out.println(exception.getMessage());
        }
    }

    protected boolean isExistResume(String uuid) {
        return (getIndex(uuid) >= 0);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveToStorage(Resume resume);

    //TODO что должен вернуть метод, если мы обрабатываем исключение?
    public final Resume get(String uuid) {
        if (getIndex(uuid) >= 0) {
            if (isExistResume(uuid)) {
                return getResume(getIndex(uuid));
            }
        }
        catchingException(new NotExistStorageException(uuid));
        return new Resume(null);
    }

    protected abstract Resume getResume(int index);

    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        if (isExistResume(uuid)) {
            updateResume(resume, getIndex(uuid));
            System.out.println("You have updated resume with " + uuid);
        } else {
            catchingException(new NotExistStorageException(uuid));
        }
    }

    protected abstract void updateResume(Resume resume, int index);

    public final void delete(String uuid) {
        if (isExistResume(uuid)) {
            deleteResume(getIndex(uuid));
            System.out.println("You have deleted resume with " + uuid);
        } else {
            catchingException(new NotExistStorageException(uuid));
        }
    }

    protected abstract void deleteResume(int index);

    public final void clear() {
        clearStorage();
        System.out.println("You have cleared the resume storage.");
    }

    protected abstract void clearStorage();
}
