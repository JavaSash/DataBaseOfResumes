package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    void saveToStorage(Resume resume, int index) {
            index = -(index) - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey); //возвращает индекс элемента в массиве
    }
}