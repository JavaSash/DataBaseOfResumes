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
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equalsIgnoreCase(uuid))
                return i;
        }
        return -1;
    }

    @Override
    protected void saveToStorage(Resume resume, Object key) {
        storage.add(resume);
    }

    @Override
    protected boolean isExist(Object key) {
        return (Integer) key >= 0;
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void updateResume(Resume resume, Object key) {
        storage.set((Integer) key, resume);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(((Integer) key).intValue());
    }

    @Override
    public final List<Resume> getAllSorted() {
        storage.sort((o1, o2) -> o1.getUuid().compareTo(o2.getUuid()));
        return storage;
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }
}