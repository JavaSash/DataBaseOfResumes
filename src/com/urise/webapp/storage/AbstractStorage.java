package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume resume) {
            if (!checkIsExistResume(resume)) {
                saveToStorage(resume);
                System.out.println("Вы успешно записали резюме с " + resume.getUuid());
            } else {
                throw new ExistStorageException(resume.getUuid());
            }
    }

    protected abstract boolean checkIsExistResume(Resume resume);

    protected abstract void saveToStorage(Resume resume);

    public final Resume get(String uuid) throws NotExistStorageException {
        if(searchResume(uuid) != null) {
            return searchResume(uuid);
        }
        throw new NotExistStorageException(uuid);
    }

    protected abstract Resume searchResume(String uuid);

    public final void update(Resume resume) throws NotExistStorageException {
        if (checkIsExistResume(resume)) {
            updateResume(resume);
            System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract void updateResume(Resume resume);

    public final void delete(String uuid) throws NotExistStorageException {
        if (checkIsExistResume(get(uuid))) {
            deleteResume(uuid);
            System.out.println("Вы успешно удалили резюме с " + uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void deleteResume(String uuid);
}
