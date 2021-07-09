package com.urise.webapp.storage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() throws IllegalAccessException {
        super(new ObjectStreamPathStorage(String.valueOf(STORAGE_DIR)));
    }
}