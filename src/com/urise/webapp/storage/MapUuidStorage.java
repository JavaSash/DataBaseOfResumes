package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.containsKey(uuid) ? uuid : null;
    }

    @Override
    protected void saveToStorage(Resume resume, Object key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(Resume resume, Object key) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(key);
    }

    @Override
    public final List<Resume> toList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clearStorage() {
        storage.clear();
    }
}
