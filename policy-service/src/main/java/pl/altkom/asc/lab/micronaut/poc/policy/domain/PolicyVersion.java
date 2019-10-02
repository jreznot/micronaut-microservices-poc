package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.altkom.asc.lab.micronaut.poc.policy.domain.vo.DateRange;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class PolicyVersion {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "POLICY_ID")
    private Policy policy;

    private Long versionNumber;

    private String productCode;

    private Person policyHolder;

    private String accountNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "from", column = @Column(name = "cover_from")),
            @AttributeOverride(name = "to", column = @Column(name = "cover_to"))
    })
    private DateRange coverPeriod;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "from", column = @Column(name = "version_from")),
            @AttributeOverride(name = "to", column = @Column(name = "version_to"))
    })
    private DateRange versionValidityPeriod;

    @OneToMany(mappedBy = "policyVersion", cascade = CascadeType.ALL)
    private Set<Cover> covers;
    
    private BigDecimal totalPremiumAmount;

    public PolicyVersion(Long id, Policy policy, Long versionNumber, String productCode, Person policyHolder,
                         String accountNumber, DateRange coverPeriod, DateRange versionValidityPeriod,
                         Set<Cover> covers, BigDecimal totalPremiumAmount) {
        this.id = id;
        this.policy = policy;
        this.versionNumber = versionNumber;
        this.productCode = productCode;
        this.policyHolder = policyHolder;
        this.accountNumber = accountNumber;
        this.coverPeriod = coverPeriod;
        this.versionValidityPeriod = versionValidityPeriod;
        this.covers = covers;
        this.totalPremiumAmount = totalPremiumAmount;
    }

    protected PolicyVersion() {
    }

    CoverCollection covers() {
        return new CoverCollection(this, covers);
    }

    public Long getId() {
        return this.id;
    }

    public Policy getPolicy() {
        return this.policy;
    }

    public Long getVersionNumber() {
        return this.versionNumber;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public Person getPolicyHolder() {
        return this.policyHolder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public DateRange getCoverPeriod() {
        return this.coverPeriod;
    }

    public DateRange getVersionValidityPeriod() {
        return this.versionValidityPeriod;
    }

    public Set<Cover> getCovers() {
        return this.covers;
    }

    public BigDecimal getTotalPremiumAmount() {
        return this.totalPremiumAmount;
    }
}
