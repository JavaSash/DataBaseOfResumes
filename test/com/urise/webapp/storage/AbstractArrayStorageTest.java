package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3);

    protected AbstractArrayStorageTest(Storage storage) {
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
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        Resume resume_4 = new Resume("uuid4");
        storage.save(resume_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertSame(resume_4, storage.get(resume_4.getUuid()));
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflow() {
        try {
            for (int i = 4; i <= STORAGE_LIMIT; i++) {
                storage.save(new Resume());
                System.out.println("size: " + storage.size());
            }
        } catch (StorageException exc) {
            Assert.fail("Storage overflowed early");
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(RESUME3, storage.get(UUID_3));
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_3);
        storage.update(newResume);
        Assert.assertSame(newResume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("uuid_5"));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        int sizeBefore = storage.size();
        storage.delete(UUID_2);
        Assert.assertEquals(sizeBefore - 1, storage.size());
        storage.get(UUID_2);
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