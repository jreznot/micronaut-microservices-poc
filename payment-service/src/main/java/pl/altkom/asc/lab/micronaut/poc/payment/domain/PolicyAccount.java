package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "policy_account")
public class PolicyAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "policy_account_number")
    private String policyAccountNumber;

    @OneToMany(mappedBy = "policyAccount", cascade = CascadeType.ALL)
    private List<AccountingEntry> entries;
    
    @DateCreated
    @Column(name = "created")
    private Date created;
    
    @DateUpdated
    @Column(name = "updated")
    private Date updated;

    public PolicyAccount(String policyNumber, String policyAccountNumber) {
        this.policyNumber = policyNumber;
        this.policyAccountNumber = policyAccountNumber;
        this.entries = new ArrayList<>();
    }

    protected PolicyAccount() {
    }

    void expectedPayment(BigDecimal amount, LocalDate dueDate) {
        entries.add(new ExpectedPayment(this, LocalDate.now(), dueDate, amount));
    }

    void inPayment(BigDecimal amount, LocalDate incomeDate) {
        entries.add(new InPayment(this, LocalDate.now(), incomeDate, amount));
    }

    void outPayment(BigDecimal amount, LocalDate paymentReleaseDate) {
        entries.add(new OutPayment(this, LocalDate.now(), paymentReleaseDate, amount));
    }

    public BigDecimal balanceAt(LocalDate effectiveDate) {
        List<AccountingEntry> effectiveEntries = entries.stream()
                .sorted(Comparator.comparing(AccountingEntry::getCreationDate))
                .filter(e -> e.isEffectiveOn(effectiveDate))
                .collect(Collectors.toList());

        BigDecimal balance = BigDecimal.ZERO;
        for (AccountingEntry entry : effectiveEntries) {
            balance = entry.apply(balance);
        }

        return balance;
    }

    public Long getId() {
        return this.id;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public String getPolicyAccountNumber() {
        return this.policyAccountNumber;
    }

    public List<AccountingEntry> getEntries() {
        return this.entries;
    }

    public Date getCreated() {
        return this.created;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
