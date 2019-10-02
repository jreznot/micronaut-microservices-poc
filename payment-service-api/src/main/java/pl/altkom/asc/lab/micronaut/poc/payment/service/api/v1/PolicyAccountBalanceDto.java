package pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyAccountBalanceDto {
    private String policyAccountNumber;
    private String policyNumber;
    private BigDecimal balance;
    private Date created;
    private Date updated;

    public PolicyAccountBalanceDto(String policyAccountNumber, String policyNumber, BigDecimal balance, Date created, Date updated) {
        this.policyAccountNumber = policyAccountNumber;
        this.policyNumber = policyNumber;
        this.balance = balance;
        this.created = created;
        this.updated = updated;
    }

    public PolicyAccountBalanceDto() {
    }

    public String getPolicyAccountNumber() {
        return policyAccountNumber;
    }

    public void setPolicyAccountNumber(String policyAccountNumber) {
        this.policyAccountNumber = policyAccountNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
