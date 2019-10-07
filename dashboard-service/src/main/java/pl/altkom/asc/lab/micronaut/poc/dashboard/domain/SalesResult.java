package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.math.BigDecimal;

public class SalesResult {
    private Long policiesCount;
    private BigDecimal premiumAmount;

    public SalesResult(Long policiesCount, BigDecimal premiumAmount) {
        this.policiesCount = policiesCount;
        this.premiumAmount = premiumAmount;
    }

    public static SalesResult of(Long count,BigDecimal total) {
        return new SalesResult(count,total);
    }

    public Long getPoliciesCount() {
        return this.policiesCount;
    }

    public BigDecimal getPremiumAmount() {
        return this.premiumAmount;
    }
}
