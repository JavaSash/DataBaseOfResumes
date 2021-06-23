package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.urise.webapp.ResumeTestData.createResume;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("C:\\Users\\Sasha\\Dropbox\\basejava\\src\\com\\urise\\webapp\\storage");

    protected Storage storage;

    private static final String NAME_A = "Сапов Игнат";
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = createResume(UUID_1, NAME_A);

    private static final String NAME_B = "Бурдюков Кирилл";
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = createResume(UUID_2, NAME_B);

    private static final String NAME_C = "Арцыбашев Демид";
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = createResume(UUID_3, NAME_C);

    private static final String NAME_D = "Дергач Анатолий";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME4 = createResume(UUID_4, NAME_D);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
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
    public void getNotExist() {
        storage.get(UUID_4);
    }

    @Test
    public void get() {
        assertEquals(RESUME3, storage.get(UUID_3));
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_3, NAME_C);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(storage.get(UUID_4));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        int sizeBefore = storage.size();
        storage.delete(UUID_2);
        assertEquals(sizeBefore - 1, storage.size());
        storage.get(UUID_2);
    }

    @Test
    public void getAllSorted() {
        List<Resume> expectedResumes = Arrays.asList(RESUME1, RESUME2, RESUME3);
        expectedResumes.sort(Resume::compareTo);
        assertEquals(expectedResumes, storage.getAllSorted());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }
}