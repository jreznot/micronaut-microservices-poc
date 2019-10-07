package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.time.LocalDate;

public class LocalDateRange {
    private final LocalDate from;
    private final LocalDate to;

    protected LocalDateRange(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public static LocalDateRange between(LocalDate from, LocalDate to) {
        return new LocalDateRange(from,to);
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }
}
