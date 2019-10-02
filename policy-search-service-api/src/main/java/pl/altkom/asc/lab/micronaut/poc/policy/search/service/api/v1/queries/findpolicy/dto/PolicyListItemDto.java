package pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy.dto;

import java.time.LocalDate;

public class PolicyListItemDto {
    private String number;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String policyHolder;

    public PolicyListItemDto(String number, LocalDate dateFrom, LocalDate dateTo, String policyHolder) {
        this.number = number;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.policyHolder = policyHolder;
    }

    public PolicyListItemDto() {
    }

    public String getNumber() {
        return this.number;
    }

    public LocalDate getDateFrom() {
        return this.dateFrom;
    }

    public LocalDate getDateTo() {
        return this.dateTo;
    }

    public String getPolicyHolder() {
        return this.policyHolder;
    }
}
