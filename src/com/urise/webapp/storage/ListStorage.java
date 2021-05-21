package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage = new ArrayList<>();

    @Override
    public final int size() {
        return storage.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equalsIgnoreCase(uuid))
                return i;
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume, Integer key) {
        storage.add(resume);
    }

    @Override
    protected boolean isExist(Integer key) {
        return key >= 0;
    }

    @Override
    protected Resume getResume(Integer key) {
        return storage.get(key);
    }

    @Override
    protected void updateResume(Resume resume, Integer key) {
        storage.set(key, resume);
    }

    @Override
    protected void deleteResume(Integer key) {
        storage.remove((key).intValue());
    }

    @Override
    public final List<Resume> toList() {
        return new ArrayList<>(storage);
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }
}