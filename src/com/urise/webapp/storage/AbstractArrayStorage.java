package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    final public int size() {
        return size;
    }

    final public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index < 0) {//если такого резюме ещё нет
                recordToStorage(resume, size);
            } else {
                System.out.println("Резюме с " + resume.getUuid() + " уже есть.");
            }
        } else {
            System.out.println("В хранилище закончилось место.");
        }
    }

    abstract void recordToStorage(Resume resume, int index);

    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("В хранилище нет резюме с " + uuid);
        return null;
    }

    final public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
        } else {
            System.out.println("Нет такого резюме.");
        }
    }

    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            size--;
            System.out.println("Вы успешно удалили резюме с " + uuid);
        } else {
            System.out.println("В хранилище нет резюме с " + uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    final public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    final public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Вы очистили хранилище резюме.");
    }

    protected abstract int getIndex(String uuid);
}
