package com.urise.webapp.strategy;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Strategy {
    void writeTo(Resume resume, OutputStream outputStream) throws IOException;
    Resume readResume(InputStream inputStream) throws IOException;
}
