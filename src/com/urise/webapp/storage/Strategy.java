package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.IOException;

public interface Strategy {
    void writeTo(Resume resume, Object object) throws IOException;
    Resume readResume(Object object) throws IOException;
}
