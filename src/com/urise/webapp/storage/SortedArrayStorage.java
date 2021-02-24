package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    void recordToIndex(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {//если такого резюме ещё нет
            index = size;
            if (size == 0) {
                record(resume, size);
            } else if (resume.compareTo((storage[index - 1])) >= 0) { // resume.uuid >= storage[index].uuid
                record(resume, index);
            } else { // resume.uuid < storage[index].uuid
                while (resume.compareTo(storage[index-1]) < 0 && index >= 0) {
                    if (index > 0) {
                        index--;
                    }
                }
                System.arraycopy(storage, index, storage, index + 1, size - index);
                record(resume, index);
            }
        } else {
            System.out.println("Резюме с " + resume.getUuid() + " уже есть.");
        }
    }

    private void record(Resume resume, int index) {
        storage[index] = resume;
        size++;
        System.out.println("Вы успешно записали резюме с " + resume.getUuid());
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey); //возвращает индекс элемента в массиве
    }
}