package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyDto {

    private String number;
    private LocalDate from;
    private LocalDate to;
    private String policyHolder;
    private String productCode;
    private BigDecimal totalPremium;
    private String agentLogin;

    public PolicyDto(String number, LocalDate from, LocalDate to, String policyHolder, String productCode,
                     BigDecimal totalPremium, String agentLogin) {
        this.number = number;
        this.from = from;
        this.to = to;
        this.policyHolder = policyHolder;
        this.productCode = productCode;
        this.totalPremium = totalPremium;
        this.agentLogin = agentLogin;
    }

    public PolicyDto() {
    }

    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getTotalPremium() {
        return totalPremium;
    }

    public String getAgentLogin() {
        return agentLogin;
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
