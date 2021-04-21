package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Optional;

public class MapFullNameStorage extends AbstractMapStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.containsKey(uuid) ?
                storage.get(uuid).getFullName() : null;
    }

    @Override
    protected Resume getResume(Object fullName) {
        return searchResume(fullName).get();
    }

    private Optional<Resume> searchResume(Object fullName) {
        return storage.values()
                .stream()
                .filter(value -> value.getFullName().equals(fullName))
                .findFirst();
    }

    @Override
    protected void deleteResume(Object fullName) {
        storage.remove(searchResume(fullName).get().getUuid());
    }
}
