package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new ArrayList<>();

    @Override
    public final int size() {
        return storage.size();
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equalsIgnoreCase(uuid))
                return i;
        }
        return -1;
    }

    @Override
    protected void saveToStorage(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(int index) {
        return storage.get(index);
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage.set(index, resume);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    public final Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }
}