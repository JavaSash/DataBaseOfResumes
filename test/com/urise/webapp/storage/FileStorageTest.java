package com.urise.webapp.storage;

import com.urise.webapp.strategy.StrategySwitcher;

public class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() throws IllegalAccessException {
        super(new FileStorage(STORAGE_DIR, new StrategySwitcher()));
    }
}