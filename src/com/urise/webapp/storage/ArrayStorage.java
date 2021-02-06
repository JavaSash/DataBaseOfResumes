package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Вы очистили хранилище резюме");
    }

    public void save(Resume resume) {
        if (enoughSpace()) { //есть место в хранилище?
            if (!presenceResume(resume.getUuid())) { //если такого резюме ещё нет
                storage[size] = resume;
                size++;
                System.out.println("Вы успешно записали резюме с " + resume.getUuid());
            }
        }
    }

    private boolean enoughSpace() {
        if (size < storage.length) {
            return true;
        } else {
            System.out.println("В хранилище закончилось место.");
            return false;
        }
    }

    public void update(Resume resume) {
        if (presenceResume(resume.getUuid())) { //если резюме есть в хранилище
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equalsIgnoreCase(resume.getUuid())) {
                    storage[i] = resume;
                    System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
                }
            }
        }
    }

    //Наличие резюме в хранилище
    private boolean presenceResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                return true;
            }
        }
        return false;
    }

    public Resume get(String uuid) {
        if (presenceResume(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                    return storage[i];
                }
            }
        } else {
            System.out.println("Нет резюме с " + uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        if (presenceResume(uuid)) {
            for (int i = 0; i < size - 1; i++) {
                if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                    while (i < size) {
                        storage[i] = storage[i + 1];
                        i++;
                    }
                    size--;
                    System.out.println("Вы успешно удалили резюме с " + uuid);
                }
            }
        } else {
            System.out.println("Нет резюме с " + uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
