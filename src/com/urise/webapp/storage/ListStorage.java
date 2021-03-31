package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> storage = new ArrayList<>();

    public final int size() {
        return storage.size();
    }

    @Override
    protected int getIndex(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equalsIgnoreCase(uuid)) {
                return storage.indexOf(resume);
            }
        }
        return -1;
    }

    @Override
    protected void saveToStorage(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(String uuid, int index) {
            return storage.get(index);
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage.add(index, resume);
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        storage.remove(index);
    }

    public final Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    protected void clearStorage() {
        storage.clear();
    }
}
