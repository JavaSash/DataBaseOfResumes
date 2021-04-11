package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new LinkedHashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    protected Object getSearchKey(String uuid) {
        if (storage.containsKey(uuid)) {
            return uuid;
        }
        return null;
    }

    @Override
    protected void saveToStorage(Resume resume, Object key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey(key);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get(key);
    }

    @Override
    protected void updateResume(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(key);
    }

    @Override
    public final Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public void clearStorage() {
        storage.clear();
    }
}
