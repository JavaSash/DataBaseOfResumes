package com.urise.webapp.model;

public enum ContactType {
    PHONE("Тел.: "),
    EMAIL("Почта: "),
    SKYPE("Skype: "),
    LINKEDIN("Профиль LinkedIn: "),
    GITHUB("Профиль GitHud: "),
    STACKOVERFLOW("Профиль StackOverFlow: "),
    HOME_PAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
