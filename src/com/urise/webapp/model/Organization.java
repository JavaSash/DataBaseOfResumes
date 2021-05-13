package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Organization {
    private final Link page;
    private final String position;
    private String info;
    private final YearMonth from;
    private final YearMonth to;

    public Organization(String name, String url, String position, YearMonth from, YearMonth to) {
        this(name, url, position, "", from, to);
    }

    public Organization(String name, String url, String position, String info, YearMonth from, YearMonth to) {
        Objects.requireNonNull(from, "From date must not be null");
        Objects.requireNonNull(to, "To date must not be null");
        Objects.requireNonNull(position, "Position must not be null");
        this.page = new Link(name, url);
        this.position = position;
        this.info = info;
        this.from = from;
        this.to = to;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return page + "\n"
                + from + "-" + "\t"
                + position + "\n"
                + to + " \t"
                + info;
    }
}
