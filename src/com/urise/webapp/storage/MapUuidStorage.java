package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapUuidStorage extends AbstractMapStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.containsKey(uuid) ? uuid : null;
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(key);
    }
}
