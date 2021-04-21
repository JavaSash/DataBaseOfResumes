package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    protected abstract boolean isExist(SK key);

    protected abstract SK getSearchKey(String uuid);

    protected abstract void saveToStorage(Resume resume, SK key);

    protected abstract Resume getResume(SK key);

    protected abstract void updateResume(Resume resume, SK key);

    protected abstract void deleteResume(SK key);

    protected abstract void clearStorage();

    protected abstract List<Resume> toList();

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        SK searchKey = searchNotExistKey(uuid);
        saveToStorage(resume, searchKey);
        System.out.println("You have recorded resume with " + uuid + " " + resume.getFullName());
    }

    private SK searchNotExistKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey))
            return searchKey;
        throw new ExistStorageException(uuid);
    }

    public final Resume get(String uuid) {
        return getResume(searchExistKey(uuid));
    }

    private SK searchExistKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey))
            return searchKey;
        throw new NotExistStorageException(uuid);
    }

    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        updateResume(resume, searchExistKey(uuid));
        System.out.println("You have updated resume with " + uuid + " " + resume.getFullName());
    }

    public final void delete(String uuid) {
        deleteResume(searchExistKey(uuid));
        System.out.println("You have deleted resume with " + uuid);
    }

    public final void clear() {
        clearStorage();
        System.out.println("You have cleared the resume storage.");
    }

    public final List<Resume> getAllSorted() {
        List<Resume> sortedList = toList();
        sortedList.sort(Resume::compareTo);
        return sortedList;
    }
}