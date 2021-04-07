package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> storage = new LinkedHashMap<>();
    private static Object[] keyArray;

    @Override
    public int size() {
        return storage.size();
    }

    protected int getIndex(String uuid) {
        keyArray = storage.keySet().toArray();
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i].equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveToStorage(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(int index) {
        String uuid = (String) keyArray[index];
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(int index) {
        String uuid = (String) keyArray[index];
        storage.remove(uuid);
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
