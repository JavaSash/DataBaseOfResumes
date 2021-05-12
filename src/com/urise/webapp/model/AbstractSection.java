package com.urise.webapp.model;

import java.util.Objects;

public abstract class AbstractSection<T> {
    protected T info;

    AbstractSection(T info) {
        Objects.requireNonNull(info, "Info block must not be null");
        this.info = info;
    }

    public abstract void setInfo(Object element);
}
