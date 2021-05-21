package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public final int size() {
        return storage.size();
    }

    @Override
    protected final void saveResume(Resume resume, Resume key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected final boolean isExist(Resume key) {
        return key != null;
    }

    @Override
    protected final void updateResume(Resume resume, Resume key) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Resume key) {
        storage.remove(key.getUuid());
    }

    @Override
    public final List<Resume> toList() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public final void clearStorage() {
        storage.clear();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }
}
