package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.dto;

import java.time.LocalDate;

public class PolicyDto {
    private String number;
    private LocalDate from;
    private LocalDate to;
    private String policyHolder;

    public PolicyDto(String number, LocalDate from, LocalDate to, String policyHolder) {
        this.number = number;
        this.from = from;
        this.to = to;
        this.policyHolder = policyHolder;
    }

    public PolicyDto() {
    }

    public String getNumber() {
        return this.number;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public String getPolicyHolder() {
        return this.policyHolder;
    }
}
