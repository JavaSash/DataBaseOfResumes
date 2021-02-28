package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    void recordToStorage(Resume resume, int index) {
        if (index == 0) {
            recordToIndex(resume, index);
        } else {
            searchPlaceForResume(resume, index);
        }
    }

    private void recordToIndex(Resume resume, int index) {
        storage[index] = resume;
        size++;
        System.out.println("Вы успешно записали резюме с " + resume.getUuid());
    }

    private void searchPlaceForResume(Resume resume, int index) {
        if (resume.compareTo(storage[index - 1]) > 0) { // новое резюме > последнего в хранилище
            recordToIndex(resume, index);
        } else { // новое резюме < последнего в хранилище
            while (resume.compareTo(storage[index - 1]) < 0 && index > 0) {
                index--;
            }
            System.arraycopy(storage, index, storage, index + 1, size - index);
            recordToIndex(resume, index);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey); //возвращает индекс элемента в массиве
    }
}