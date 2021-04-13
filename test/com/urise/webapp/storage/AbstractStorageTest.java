package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String NO_NAME = "No name";
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1, NO_NAME);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2, NO_NAME);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3, NO_NAME);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME4 = new Resume(UUID_4, NO_NAME);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        storage.save(RESUME4);
        assertEquals(4, storage.size());
        assertSame(RESUME4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(RESUME1);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME3, storage.get(UUID_3));
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_3, NO_NAME);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
        assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        int sizeBefore = storage.size();
        storage.delete(UUID_2);
        assertEquals(sizeBefore - 1, storage.size());
        storage.get(UUID_2);
    }

    @Test
    public void getAll() {
        List<Resume> allResume = storage.getAllSorted();
        assertEquals(storage.size(), allResume.size());
        assertEquals(RESUME1, storage.get(UUID_1));
        assertEquals(RESUME2, storage.get(UUID_2));
        assertEquals(RESUME3, storage.get(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }
}