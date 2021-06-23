package com.urise.webapp.model;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.urise.webapp.util.DateUtil.NOW;

public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(getPage(), that.getPage()) &&
                getPositions().equals(that.getPositions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPage(), getPositions());
    }

    public static class Position  implements Serializable {
        private final String position;
        private String info;
        private final YearMonth from;
        private final YearMonth to;

        public Position(String position, String info, YearMonth from) {
            this(position, info, from, NOW);
        }

        public Position(String position, String info, YearMonth from, YearMonth to) {
            Objects.requireNonNull(position, "Position must not be null");
            Objects.requireNonNull(from, "From date must not be null");
            Objects.requireNonNull(to, "To date must not be null");
            this.position = position;
            this.info = info;
            this.from = from;
            this.to = to;
        }

        public YearMonth getFrom() {
            return from;
        }

        public YearMonth getTo() {
            return to;
        }

        public String getPosition() {
            return position;
        }

        public String getInfo() {
            return info;
        }

        @Override
        public String toString() {
            return from + "-" + "\t"
                    + position + "\n"
                    + to + " \t"
                    + info;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position1 = (Position) o;
            return getPosition().equals(position1.getPosition()) &&
                    Objects.equals(getInfo(), position1.getInfo()) &&
                    getFrom().equals(position1.getFrom()) &&
                    getTo().equals(position1.getTo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPosition(), getInfo(), getFrom(), getTo());
        }
    }
}
