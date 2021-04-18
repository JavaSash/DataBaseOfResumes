package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        //return searchInStorage(uuid).getFullName();
        for (Resume resume : storage.values()) {
            if (resume.getUuid().equalsIgnoreCase(uuid)) {
                return resume.getFullName();
            }
        }
        return null;
    }

//    private Resume searchInStorage(String key) {
//        for (Resume resume : storage.values()) {
//            if (condition(resume, key)) {
//                return resume;
//            }
//        }
//        return null;
//    }

//    private boolean condition(Resume resume, String key) {
//        return (resume.getUuid().equalsIgnoreCase(key)) ? true : false;
//    }

    @Override
    protected void saveToStorage(Resume resume, Object key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object fullName) {
        for (Resume resume : storage.values()) {
            if (resume.getFullName().equalsIgnoreCase((String) fullName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Resume getResume(Object fullName) {
        String key = null;
        for (Resume resume : storage.values()) {
            if (resume.getFullName().equalsIgnoreCase((String) fullName)) {
                key = resume.getUuid();
            }
        }
        return storage.get(key);
    }

    @Override
    protected void updateResume(Resume resume, Object fullName) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Object fullName) {
        Iterator<Resume> itrResumes = storage.values().iterator();
        while (itrResumes.hasNext()) {
            Resume nextResume = itrResumes.next(); //
            if (nextResume.getFullName().equalsIgnoreCase((String) fullName)) {
                itrResumes.remove();
                break;
            }
        }
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
