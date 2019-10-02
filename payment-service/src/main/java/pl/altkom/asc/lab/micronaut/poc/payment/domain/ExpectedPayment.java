package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "expected_payment")
public class ExpectedPayment extends AccountingEntry {

    public ExpectedPayment(PolicyAccount policyAccount, LocalDate creationDate, LocalDate effectiveDate, BigDecimal amount) {
        super(policyAccount, creationDate, effectiveDate, amount);
    }

    protected ExpectedPayment() {
    }

    @Override
    public BigDecimal apply(BigDecimal state) {
        return state.subtract(getAmount());
    }
}
