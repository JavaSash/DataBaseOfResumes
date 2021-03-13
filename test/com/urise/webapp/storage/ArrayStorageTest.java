package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super.storage = new ArrayStorage();
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
        Assert.assertEquals(storage.getIndex("uuid3"), storage.size() - 1);
    }

    @Test
    public void getIndex() {
        Assert.assertEquals(1, storage.getIndex("uuid2"));
    }
}