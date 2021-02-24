package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    void recordToIndex(Resume resume) {
        if (getIndex(resume.getUuid()) == -1) {//если такого резюме ещё нет
            storage[size] = resume;
            size++;
            System.out.println("Вы успешно записали резюме с " + resume.getUuid());
        } else {
            System.out.println("Резюме с " + resume.getUuid() + " уже есть.");
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                return i;
            }
        }
        return -1;
    }
}