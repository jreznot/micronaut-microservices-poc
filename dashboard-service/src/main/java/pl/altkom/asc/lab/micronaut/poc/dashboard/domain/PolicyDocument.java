package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyDocument {
    private String number;
    private LocalDate from;
    private LocalDate to;
    private String policyHolder;
    private String productCode;
    private BigDecimal totalPremium;
    private String agentLogin;

    public PolicyDocument(String number, LocalDate from, LocalDate to, String policyHolder, String productCode, BigDecimal totalPremium, String agentLogin) {
        this.number = number;
        this.from = from;
        this.to = to;
        this.policyHolder = policyHolder;
        this.productCode = productCode;
        this.totalPremium = totalPremium;
        this.agentLogin = agentLogin;
    }

    public PolicyDocument() {
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

    public String getProductCode() {
        return this.productCode;
    }

    public BigDecimal getTotalPremium() {
        return this.totalPremium;
    }

    public String getAgentLogin() {
        return this.agentLogin;
    }
}
