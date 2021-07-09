package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapFullNameStorageTest.class,
        MapResumeStorageTest.class,
        AbstractFileStorageTest.class,
        ObjectStreamStorageTest.class,
        AbstractPathStorageTest.class,
        ObjectStreamPathStorageTest.class
})
public class AllStorageTest {
}
