package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Scanner;

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

    public void save(Resume r) {
        if (enoughSpace()) { //есть место в хранилище?
            if (!presenceResume(r)) { //если такого резюме ещё нет
                storage[size] = r;
                size++;
                System.out.println("Вы успешно записали резюме с " + r.getUuid());
            } else {
                System.out.println("Резюме с " + r.getUuid() + " есть в хранилище. Перезаписать? [y/n]");
                Scanner scan = new Scanner(System.in);
                String answer = scan.nextLine();
                while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                    System.out.println("Введите [y/n]");
                    answer = scan.nextLine();
                }
                if (answer.equalsIgnoreCase("y")) {
                    update(r);
                }
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

    public void update(Resume r) {
        if (presenceResume(r)) { //если резюме есть в хранилище
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equalsIgnoreCase(r.getUuid())) {
                    storage[i] = r;
                    System.out.println("Вы успешно обновили резюме с " + r.getUuid());
                }
            }
        } else {
            System.out.println("Резюме с " + r.getUuid() + " нет в хранилище. Записать? [y/n]");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("Введите [y/n]");
                answer = scan.nextLine();
            }
            scan.close();
            if (answer.equalsIgnoreCase("y")) {
                save(r);
            }
        }
    }

    //Наличие резюме в хранилище
    private boolean presenceResume(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equalsIgnoreCase(r.getUuid())) {
                return true;
            }
        }
        return false;
    }

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
            System.out.println("Нет такого резюме");

        }
        return null;
    }

    public void delete(String uuid) {
        if (presenceResume(uuid)) {
            for (int i = 0; i < size - 1; i++) {
                if (storage[i].getUuid() == uuid) {
                    while (i < size) {
                        storage[i] = storage[i + 1];
                        i++;
                    }
                    size--;
                    System.out.println("Вы успешно удалили резюме");
                }
            }
        } else {
            System.out.println("Нет такого резюме");
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
