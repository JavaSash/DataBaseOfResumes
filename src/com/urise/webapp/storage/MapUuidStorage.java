package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    protected Object getSearchKey(String uuid) {
        return storage.containsKey(uuid) ? uuid : null;
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
    public final List<Resume> getAllSorted() {
//        Collection<Resume> resumes = storage.values();
//        List<Resume> list = ;
////        for (Resume resume : resumes) {
////            list.add(resume);
////        }
//        Collections.sort(list);
        Object[] array = storage.values().toArray();
        Arrays.sort(array);
        return (List<Resume>) (Object) Arrays.asList(array);
//        return list;
    }

    @Override
    public void clearStorage() {
        storage.clear();
    }
}
