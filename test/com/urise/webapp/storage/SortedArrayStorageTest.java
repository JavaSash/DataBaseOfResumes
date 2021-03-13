package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super.storage = new SortedArrayStorage();
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void saveToStorage() {
        Resume[] storageIsSorted = Arrays.copyOf(storage.storage, storage.size());
        Arrays.sort(storageIsSorted);
        Assert.assertArrayEquals(storageIsSorted, storage.getAll());
    }

    @Test
    public void getIndex() {
        Assert.assertEquals(0, storage.getIndex("uuid1"));
        Assert.assertEquals(1, storage.getIndex("uuid2"));
        Assert.assertEquals(2, storage.getIndex("uuid3"));
    }
}