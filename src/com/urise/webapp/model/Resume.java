package com.urise.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private final String fullName;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class) {
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Object[] keys = contacts.keySet().toArray();
            Object[] values = contacts.values().toArray();
            for (int i = 0; i < contacts.entrySet().size(); i++) {
                sb.append(keys[i]).append(" ").append(values[i]).append("\n");
            }
            return sb.toString();
        }
    };
    private Map<SectionType, AbstractSection> sections = new HashMap<>();

    private AbstractSection personal = new TextSection();
    private AbstractSection objective = new TextSection();
    private AbstractSection achievement = new ListSection();
    private AbstractSection qualification = new ListSection();
    private AbstractSection experience = new OrganizationSection();
    private AbstractSection education = new OrganizationSection();

    {
        sections.put(SectionType.PERSONAL, personal);
        sections.put(SectionType.OBJECTIVE, objective);
        sections.put(SectionType.ACHIEVEMENT, achievement);
        sections.put(SectionType.QUALIFICATIONS, qualification);
        sections.put(SectionType.EXPERIENCE, experience);
        sections.put(SectionType.EDUCATION, education);
    }

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

    public void setContacts(ContactType key, String value) {
        contacts.put(key, value);
    }

    public AbstractSection getPersonal() {
        return personal;
    }

    public AbstractSection getObjective() {
        return objective;
    }

    public AbstractSection getAchievement() {
        return achievement;
    }

    public AbstractSection getQualification() {
        return qualification;
    }

    public AbstractSection getExperience() {
        return experience;
    }

    public AbstractSection getEducation() {
        return education;
    }

    //TODO contacts
    @Override
    public String toString() {
        return uuid + "\n" + fullName + "\n"
                + SectionType.CONTACTS.getTitle() + "\n" + contacts + "\n"
                + SectionType.OBJECTIVE.getTitle() + "\n" + getObjective() + "\n"
                + SectionType.PERSONAL.getTitle() + "\n" + getPersonal() + "\n"
                + SectionType.ACHIEVEMENT.getTitle() + "\n" + getAchievement()
                + SectionType.QUALIFICATIONS.getTitle() + "\n" + getQualification()
                + SectionType.EXPERIENCE.getTitle() + "\n" + getExperience() + "\n"
                + SectionType.EDUCATION.getTitle() + "\n" + getEducation() + "\n";
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
        return fullName.equalsIgnoreCase(resume.getFullName()) ?
                uuid.compareTo(resume.getUuid()) :
                fullName.compareTo(resume.getFullName());
    }
}