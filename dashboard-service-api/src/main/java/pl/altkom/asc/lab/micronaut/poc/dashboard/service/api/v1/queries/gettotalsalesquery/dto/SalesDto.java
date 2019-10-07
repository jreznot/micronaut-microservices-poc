package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.gettotalsalesquery.dto;

import java.math.BigDecimal;

public class SalesDto {
    private Long policiesCount;
    private BigDecimal premiumAmount;

    public SalesDto(Long policiesCount, BigDecimal premiumAmount) {
        this.policiesCount = policiesCount;
        this.premiumAmount = premiumAmount;
    }

    public SalesDto() {
    }

    public Long getPoliciesCount() {
        return this.policiesCount;
    }

    public BigDecimal getPremiumAmount() {
        return this.premiumAmount;
    }

    public void setPoliciesCount(Long policiesCount) {
        this.policiesCount = policiesCount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}
