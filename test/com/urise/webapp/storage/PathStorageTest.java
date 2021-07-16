package com.urise.webapp.storage;

import com.urise.webapp.strategy.StrategySwitcher;

public class PathStorageTest extends AbstractStorageTest {
    public PathStorageTest() throws IllegalAccessException {
        super(new PathStorage(STORAGE_DIR.toString(), new StrategySwitcher()));
    }
}