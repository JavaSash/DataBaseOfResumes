package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    public static final Comparator<Resume> COMPARATOR_BY_UUID = Comparator.comparing(Resume::getUuid);

    @Override
    protected void saveToArray(Resume resume, int index) {
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "no name");
        return Arrays.binarySearch(storage, 0, size, searchKey, COMPARATOR_BY_UUID);
    }
}