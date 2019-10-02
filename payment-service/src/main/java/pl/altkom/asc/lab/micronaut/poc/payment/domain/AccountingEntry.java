package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance
@Table(name = "accounting_entry")
@DiscriminatorColumn(name = "entry_type")
public abstract class AccountingEntry {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "policy_account_id")
    private PolicyAccount policyAccount;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "amount")
    private BigDecimal amount;

    AccountingEntry(PolicyAccount policyAccount, LocalDate creationDate, LocalDate effectiveDate, BigDecimal amount) {
        this.policyAccount = policyAccount;
        this.creationDate = creationDate;
        this.effectiveDate = effectiveDate;
        this.amount = amount;
    }

    protected AccountingEntry() {
    }

    public abstract BigDecimal apply(BigDecimal state);

    boolean isEffectiveOn(LocalDate theDate) {
        return this.effectiveDate.isBefore(theDate) || this.effectiveDate.equals(theDate);
    }

    public Long getId() {
        return this.id;
    }

    public PolicyAccount getPolicyAccount() {
        return this.policyAccount;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
}
