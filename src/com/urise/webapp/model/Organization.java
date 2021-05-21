package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link page;
    private List<Position> positions;

    public Organization(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Organization(Link page, List<Position> positions) {
        Objects.requireNonNull(positions, "Position must not be null");
        this.page = page;
        this.positions = positions;
    }

    public Link getPage() {
        return page;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return page + "\n"
                + positions + "\n";
    }

    public static class Position {
        private final String position;
        private String info;
        private final YearMonth from;
        private final YearMonth to;

        public Position(String position, String info, YearMonth from, YearMonth to) {
            Objects.requireNonNull(position, "Position must not be null");
            Objects.requireNonNull(from, "From date must not be null");
            Objects.requireNonNull(to, "To date must not be null");
            this.position = position;
            this.info = info;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return from + "-" + "\t"
                    + position + "\n"
                    + to + " \t"
                    + info;
        }
    }
}
