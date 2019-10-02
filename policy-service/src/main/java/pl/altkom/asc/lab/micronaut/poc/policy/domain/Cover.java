package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cover {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    
    private BigDecimal price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "POLICY_VERSION_ID")
    private PolicyVersion policyVersion;

    public Cover(PolicyVersion policyVersion, String code, BigDecimal price) {
        this.policyVersion = policyVersion;
        this.code = code;
        this.price = price;
    }

    protected Cover() {
    }

    @Override
    public String toString() {
        return code + " - " + price;
    }

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public PolicyVersion getPolicyVersion() {
        return this.policyVersion;
    }
}
