package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> storage = new ArrayList();

    public final int size() {
        return storage.size();
    }

    @Override
    protected boolean checkEnoughtSpace() {
        return true;
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected boolean checkIsExistResume(Resume resume) {
        return (storage.contains(resume));
    }

    @Override
    protected void saveToStorage(Resume resume, int index) {
        storage.add(resume);
    }

    public final Resume get(String uuid) throws NotExistStorageException {
        for (Resume resume : storage) {
            if (resume.getUuid() == uuid) {
                return resume;
            }
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    protected void updateResume(Resume resume) {
        storage.add(storage.indexOf(resume), resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        storage.remove(get(uuid));
    }

    public final Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    public final void clear() {
        Iterator<Resume> resumeIterator = storage.iterator();
        while (resumeIterator.hasNext()) {
            resumeIterator.next();
            resumeIterator.remove();
        }
        System.out.println("Вы очистили хранилище резюме.");
    }
}
