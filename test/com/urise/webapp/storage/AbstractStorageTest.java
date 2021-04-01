package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3);

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
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        Resume resume_4 = new Resume("uuid4");
        storage.save(resume_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertSame(resume_4, storage.get(resume_4.getUuid()));
    }

    @Test
    public void saveAlreadyExist() {
        storage.save(storage.get(UUID_1));
        Assert.assertEquals(new ExistStorageException(UUID_1).getMessage(),
                "Resume with uuid1 already exist");
    }

    @Test
    public void getNotExist() throws Exception {
        storage.get("dummy");
        Assert.assertEquals(new NotExistStorageException("dummy").getMessage(),
                "There is no resume with dummy");
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

    @Test
    public void updateNotExist() {
        storage.update(new Resume("uuid5"));
        Assert.assertEquals(new NotExistStorageException("uuid5").getMessage(),
                "There is no resume with uuid5");
    }

    @Test
    public void deleteNotExist() {
        storage.delete("dummy");
        Assert.assertEquals(new NotExistStorageException("dummy").getMessage(),
                "There is no resume with dummy");
    }

    @Test
    public void delete() {
        int sizeBefore = storage.size();
        storage.delete(UUID_2);
        Assert.assertEquals(sizeBefore - 1, storage.size());
        storage.get(UUID_2);
        Assert.assertEquals(new NotExistStorageException(UUID_2).getMessage(),
                "There is no resume with uuid2");
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