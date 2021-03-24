package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> storage = new ArrayList();

    public final int size() {
        return storage.size();
    }

    public final void save(Resume resume) {
        if (!storage.contains(resume)) {
            storage.add(resume);
            System.out.println("Вы успешно записали резюме с " + resume.getUuid());
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public final Resume get(String uuid) throws NotExistStorageException {
        for (Resume resume : storage) {
            if (resume.getUuid() == uuid) {
                return resume;
            }
        }
        throw new NotExistStorageException(uuid);
    }

    public final void update(Resume resume) throws NotExistStorageException {
        if (storage.contains(resume)) {
            storage.add(storage.indexOf(resume), resume);
            System.out.println("Вы успешно обновили резюме с " + resume.getUuid());
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public final void delete(String uuid) throws NotExistStorageException {
        if (storage.contains(get(uuid))) {
            storage.remove(get(uuid));
            System.out.println("Вы успешно удалили резюме с " + uuid);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    public final Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    public final void clear() {
        Iterator<Resume> resumeIterator = storage.iterator();
        while (resumeIterator.hasNext()) {
            resumeIterator.next();
            resumeIterator.remove();
        }
        System.out.println("Вы очистили хранилище резюме.");
    }
}
