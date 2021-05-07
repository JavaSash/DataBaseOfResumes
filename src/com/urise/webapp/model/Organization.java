package com.urise.webapp.model;

import java.time.YearMonth;

public class Organization {
    private final String name;
    private final String position;
    private String info;
    private final YearMonth from;
    private final YearMonth to;

    public Organization(String name, String position, String info, YearMonth from, YearMonth to) {
        this.name = name;
        this.position = position;
        this.info = info;
        this.from = from;
        this.to = to;
    }

    public Organization(String name, String position, YearMonth from, YearMonth to) {
        this(name, position, "", from, to);
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return name + "\n"
                + from + "-" + "\t"
                + position + "\n"
                + to + " \t"
                + info;
    }
}
