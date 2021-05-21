package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {
    int size();

    void save(Resume resume);

    Resume get(String uuid);

    void update(Resume resume);

    void delete(String uuid);

    List<Resume> getAllSorted();

    void clear();
}