package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME4 = new Resume(UUID_4);

    @Before
    public void setUp() throws Exception {
        storage = new ListStorage();
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(RESUME2);
    }

    @Test
    public void save() {
        storage.save(RESUME4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(RESUME4, storage.get(UUID_4));
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("uuid4");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME4);
    }

    @Test
    public void update() {
        storage.update(RESUME2);
        Assert.assertEquals(RESUME2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test
    public void getAll() {
        Resume[] allResume = storage.getAll();
        Assert.assertEquals(storage.size(), allResume.length);
        Assert.assertEquals(RESUME1, allResume[0]);
        Assert.assertEquals(RESUME2, allResume[1]);
        Assert.assertEquals(RESUME3, allResume[2]);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }
}