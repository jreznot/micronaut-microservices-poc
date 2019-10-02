package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class PolicyDetailsDto {
    private String number;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String policyHolder;
    private BigDecimal totalPremium;
    private String productCode;
    private String accountNumber;

    private Set<String> covers;

    public PolicyDetailsDto(String number, LocalDate dateFrom, LocalDate dateTo, String policyHolder,
                            BigDecimal totalPremium, String productCode, String accountNumber, Set<String> covers) {
        this.number = number;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.policyHolder = policyHolder;
        this.totalPremium = totalPremium;
        this.productCode = productCode;
        this.accountNumber = accountNumber;
        this.covers = covers;
    }

    public PolicyDetailsDto() {
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

    public BigDecimal getTotalPremium() {
        return this.totalPremium;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Set<String> getCovers() {
        return this.covers;
    }
}
