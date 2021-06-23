package com.urise.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractSection<T> implements Serializable {
    protected T info;

    AbstractSection(T info) {
        Objects.requireNonNull(info, "Info block must not be null");
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public abstract void setInfo(Object element);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSection<?> that = (AbstractSection<?>) o;
        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
