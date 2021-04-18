package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.MapStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your com.urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new MapStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("Арцыбашев Демид", "uuid1");
        final Resume r2 = new Resume("Бурдюков Кирилл", "uuid2");
        final Resume r3 = new Resume("Бурдюков Кирилл", "uuid3");
        final Resume r8 = new Resume("Дергач Анатолий", "uuid8");
        final Resume r5 = new Resume("Сологуб Валерий", "uuid5");

        ARRAY_STORAGE.save(r8);
        ARRAY_STORAGE.save(r5);
        //ARRAY_STORAGE.save(r8);

        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r1);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        System.out.print("Updating resume: ");
        ARRAY_STORAGE.update(r1);

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.print("Updating resume: ");
        //ARRAY_STORAGE.update(r1);
        System.out.println("Size: " + ARRAY_STORAGE.size());


        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
