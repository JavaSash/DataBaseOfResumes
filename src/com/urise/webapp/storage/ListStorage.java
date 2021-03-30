package com.urise.webapp.storage;

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
    protected boolean checkIsExistResume(Resume resume) {
        return (storage.contains(resume));
    }

    @Override
    protected void saveToStorage(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid() == uuid) {
                return resume;
            }
        }
        return null;
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

    protected void clearStorage() {
        Iterator<Resume> resumeIterator = storage.iterator();
        while (resumeIterator.hasNext()) {
            resumeIterator.next();
            resumeIterator.remove();
        }
    }
}
