package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10_000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Вы очистили хранилище резюме");
    }

    public void save(Resume resume) {
        if (enoughSpace()) { //есть место в хранилище?
            if (getIndexOfResume(resume.getUuid()) == -1) {//если такого резюме ещё нет
                storage[size] = resume;
                size++;
                System.out.println("Вы успешно записали резюме с " + resume.getUuid());
            } else {
                System.out.println("Резюме с " + resume.getUuid() + " уже есть.");
            }
        }
    }

    private boolean enoughSpace() {
        if (size < STORAGE_LIMIT) {
            return true;
        } else {
            System.out.println("В хранилище закончилось место.");
            return false;
        }
    }

    public void update(Resume resume) {
        int resumeIndex = getIndexOfResume(resume.getUuid());
        if (resumeIndex >= 0) {
            storage[resumeIndex] = resume;
            System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
        } else {
            System.out.println("Нет резюме с " + resume.getUuid());
        }
    }

    private int getIndexOfResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equalsIgnoreCase(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public Resume get(String uuid) {
        int resumeIndex = getIndexOfResume(uuid);
        if (resumeIndex >= 0) {
            return storage[resumeIndex];
        }
        System.out.println("В хранилище нет резюме с " + uuid);
        return null;
    }

    public void delete(String uuid) {
        int resumeIndex = getIndexOfResume(uuid);
        if (resumeIndex >= 0) {
            System.arraycopy(storage, resumeIndex + 1, storage, resumeIndex, size - (resumeIndex + 1));
            size--;
            System.out.println("Вы успешно удалили резюме с " + uuid);
        } else {
            System.out.println("В хранилище нет резюме с " + uuid);
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