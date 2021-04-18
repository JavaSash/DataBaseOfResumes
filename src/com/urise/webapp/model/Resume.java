package com.urise.webapp.model;

import java.util.Comparator;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    public static final Comparator<Resume> COMPARATOR_BY_UUID = Comparator.comparing(Resume::getUuid);
//    public static final Comparator<Resume> COMPARATOR_BY_FULL_NAME = (o1, o2) ->
//    {
//        if (o1.getFullName().equalsIgnoreCase(o2.getFullName())) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//        return o1.getFullName().compareTo(o2.getFullName());
//    };

    // Unique identifier
    private String fullName;
    private final String uuid;

    public Resume(String... args) {
        if (args.length == 0) {
            fullName = "no name";
            uuid = (UUID.randomUUID().toString());
        } else if (args.length == 1) {
            fullName = args[0];
            uuid = (UUID.randomUUID().toString());
        } else {
            fullName = args[0];
            uuid = args[1];
        }
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume resume) {
        if (fullName.equalsIgnoreCase(resume.getFullName())) {
            return uuid.compareTo(resume.getUuid());
        }
        return fullName.compareTo(resume.getFullName());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}