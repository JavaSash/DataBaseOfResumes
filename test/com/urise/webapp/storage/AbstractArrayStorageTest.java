package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void saveStorageOverflow() {
        try {
            for (int i = 4; i <= STORAGE_LIMIT; i++) {
                super.storage.save(new Resume());
            }
        } catch (StorageException exc) {
            Assert.fail("Storage overflowed early");
        }
        super.storage.save(new Resume());
        Assert.assertEquals(new StorageException("The storage is overflow.", new Resume().getUuid()).getMessage(),
                "The storage is overflow.");
    }
}