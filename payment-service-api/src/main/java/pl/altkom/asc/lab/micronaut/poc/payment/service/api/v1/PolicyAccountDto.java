package pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1;

import io.micronaut.core.annotation.Introspected;

import java.util.Date;

@Introspected
public class PolicyAccountDto {
    private String policyAccountNumber;
    private String policyNumber;
    private Date created;
    private Date updated;

    public PolicyAccountDto(String policyAccountNumber, String policyNumber, Date created, Date updated) {
        this.policyAccountNumber = policyAccountNumber;
        this.policyNumber = policyNumber;
        this.created = created;
        this.updated = updated;
    }

    public PolicyAccountDto() {
    }

    public String getPolicyAccountNumber() {
        return this.policyAccountNumber;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setPolicyAccountNumber(String policyAccountNumber) {
        this.policyAccountNumber = policyAccountNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
