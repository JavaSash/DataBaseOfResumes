package com.urise.webapp.model;

public abstract class AbstractSection<T> {
    protected T info;

    AbstractSection(T info) {
        this.info = info;
    }

    public abstract void setInfo(Object element);

    public abstract void deleteInfo();

    public final T getInfo() {
        return info;
    }
}
