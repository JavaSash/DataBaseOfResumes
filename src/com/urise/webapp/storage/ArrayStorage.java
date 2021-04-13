package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveToArray(Resume resume, int index) {
        index = size;
        storage[index] = resume;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Resume> getAllSorted() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        Arrays.sort(resumes);
        return Arrays.asList(resumes);
    }
}