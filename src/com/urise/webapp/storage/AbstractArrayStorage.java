package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public final int size() {
        return size;
    }

    public final void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = getIndex(resume.getUuid());
            //если такого резюме ещё нет
            if (index < 0) {
                saveToStorage(resume, index);
                size++;
                System.out.println("Вы успешно записали резюме с " + resume.getUuid());
            } else {
                System.out.println("Резюме с " + resume.getUuid() + " уже есть.");
            }
        } else {
            System.out.println("В хранилище закончилось место.");
        }
    }

    abstract void saveToStorage(Resume resume, int index);

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("В хранилище нет резюме с " + uuid);
        return null;
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
            System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
        } else {
            System.out.println("Нет такого резюме.");
        }
    }

    public final void delete(String uuid) {
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
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Вы очистили хранилище резюме.");
    }

    protected abstract int getIndex(String uuid);
}
