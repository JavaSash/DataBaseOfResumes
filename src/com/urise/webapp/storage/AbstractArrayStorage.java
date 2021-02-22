package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int resumeIndex = getIndex(uuid);
        if (resumeIndex >= 0) {
            return storage[resumeIndex];
        }
        System.out.println("В хранилище нет резюме с " + uuid);
        return null;
    }

    protected abstract int getIndex(String uuid);
}
