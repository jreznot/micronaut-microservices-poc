package pl.altkom.asc.lab.micronaut.poc.policy.domain.vo;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public class Percent {
    private BigDecimal value;

    public Percent(BigDecimal value) {
        this.value = value;
    }

    protected Percent() {
    }

    public static Percent of(BigDecimal value) {
        return new Percent(value);
    }

    public MonetaryAmount multiply(MonetaryAmount amount) {
        return new MonetaryAmount(amount.getAmount().multiply(toValue()));
    }

    private BigDecimal toValue() {
        return value.divide(new BigDecimal("100"), 9, RoundingMode.HALF_UP);
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
