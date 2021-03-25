package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public abstract int size();

    public final void save(Resume resume) {
        if (checkEnoughtSpace()) {
            int index = getIndex(resume.getUuid());
            if (!checkIsExistResume(resume)) {
                saveToStorage(resume, index);
                System.out.println("Вы успешно записали резюме с " + resume.getUuid());
            } else {
                throw new ExistStorageException(resume.getUuid());
            }
        } else {
            throw new StorageException("Хранилище переполнено", resume.getUuid());
        }
    }

    protected abstract boolean checkEnoughtSpace();

    protected abstract int getIndex(String uuid);

    protected abstract boolean checkIsExistResume(Resume resume);

    protected abstract void saveToStorage(Resume resume, int index);

    public abstract Resume get(String uuid);

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

    public abstract Resume[] getAll();

    public abstract void clear();
}
