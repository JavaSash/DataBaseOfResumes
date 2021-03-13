package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest {
    protected AbstractArrayStorage storage;

    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflow() {
        storage.clear();
        for (int i = 0; i <= STORAGE_LIMIT; i++) {
            storage.save(new Resume());
            System.out.println("size: " + storage.size());
        }
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(storage.get("uuid1"));
    }

    @Test
    public void saveStorageIsFull() {
        storage.clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume());
        }
        System.out.println("size: " + storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    //id возвращаемого резюме == id запрашиваемого
    public void get() throws Exception {
        Resume testResume = storage.get("uuid3");
        Assert.assertEquals("uuid3", testResume.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        int sizeBefore = storage.size();
        storage.delete("uuid2");
        Assert.assertEquals(sizeBefore - 1, storage.size());

    }

    @Test
    public void getAll() {
        Resume[] allResume = storage.getAll();
        Assert.assertEquals(allResume.length, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }
}