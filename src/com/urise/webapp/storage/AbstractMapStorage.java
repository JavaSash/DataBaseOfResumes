package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage<String> {
    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public final int size() {
        return storage.size();
    }

    @Override
    protected final void saveResume(Resume resume, String key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected final boolean isExist(String key) {
        return key != null;
    }

    @Override
    protected final void updateResume(Resume resume, String key) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    public final List<Resume> toList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public final void clearStorage() {
        storage.clear();
    }
}
