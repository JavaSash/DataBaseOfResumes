package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private final String fullName;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, AbstractSection> sections = new LinkedHashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setSections(SectionType key, AbstractSection value) {
        sections.put(key, value);
    }

    public void setContacts(ContactType key, String value) {
        contacts.put(key, value);
    }

    public Object getSection(Object sectionType) throws Exception {
        if (sectionType.getClass().equals(SectionType.class)) {
            return sections.get(sectionType);
        } else if (sectionType.getClass().equals(ContactType.class)) {
            return contacts.get(sectionType);
        } else {
            throw new Exception("Incorrect section name.");
        }
    }

    @Override
    public String toString() {
        return uuid + "\n" + fullName + "\n"
                + SectionType.CONTACTS.getTitle() + "\n"
                + ContactType.PHONE.getTitle() + contacts.get(ContactType.PHONE) + "\n"
                + ContactType.EMAIL.getTitle() + contacts.get(ContactType.EMAIL) + "\n"
                + ContactType.SKYPE.getTitle() + contacts.get(ContactType.SKYPE) + "\n"
                + ContactType.LINKEDIN.getTitle() + "\n"
                + ContactType.GITHUB.getTitle() + "\n"
                + ContactType.STACKOVERFLOW.getTitle() + "\n"
                + ContactType.HOME_PAGE.getTitle() + "\n\n"
                + SectionType.PERSONAL.getTitle() + "\n" + sections.get(SectionType.PERSONAL) + "\n"
                + SectionType.OBJECTIVE.getTitle() + "\n" + sections.get(SectionType.OBJECTIVE) + "\n"
                + SectionType.ACHIEVEMENT.getTitle() + "\n" + sections.get(SectionType.ACHIEVEMENT)
                + SectionType.EXPERIENCE.getTitle() + "\n" + sections.get(SectionType.EXPERIENCE)
                + SectionType.EDUCATION.getTitle() + "\n" + sections.get(SectionType.EDUCATION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resume resume = (Resume) o;

        if (uuid.equals(resume.uuid)) {
            return false;
        }
        if (fullName.equals(resume.fullName)) {
            return false;
        }
        if (contacts.equals(resume.contacts)) {
            return false;
        }
        if (sections.equals(resume.sections)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + uuid.hashCode();
        result = prime * result + fullName.hashCode();
        result = prime * result + contacts.hashCode();
        result = prime * result + sections.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume resume) {
        return fullName.equalsIgnoreCase(resume.getFullName()) ?
                uuid.compareTo(resume.getUuid()) :
                fullName.compareTo(resume.getFullName());
    }
}