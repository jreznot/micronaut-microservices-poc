package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "inpayment")
public class InPayment extends AccountingEntry {

    public InPayment(PolicyAccount policyAccount, LocalDate creationDate, LocalDate effectiveDate, BigDecimal amount) {
        super(policyAccount, creationDate, effectiveDate, amount);
    }

    protected InPayment() {
    }

    @Override
    public BigDecimal apply(BigDecimal state) {
        return state.add(getAmount());
    }
}
