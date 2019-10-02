package pl.altkom.asc.lab.micronaut.poc.pricing.domain;

import org.mvel2.MVEL;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class BasePremiumCalculationRule {

    @Column(name = "cover_code")
    private String coverCode;

    @Column(name = "apply_if_formula")
    private String applyIfFormula;

    @Column(name = "price_formula")
    private String basePriceFormula;

    BasePremiumCalculationRule(String coverCode, String applyIfFormula, String basePriceFormula) {
        this.coverCode = coverCode;
        this.applyIfFormula = applyIfFormula;
        this.basePriceFormula = basePriceFormula;
    }

    public BasePremiumCalculationRule() {
    }

    boolean applies(Calculation calculation) {
        return applyIfFormula == null || applyIfFormula.isEmpty()
                ? true
                : MVEL.eval(applyIfFormula, calculation.toMap(), Boolean.class);
    }

    BigDecimal calculateBasePrice(Calculation calculation) {
        return MVEL.eval(basePriceFormula, calculation.toMap(), BigDecimal.class);
    }

    public String getCoverCode() {
        return this.coverCode;
    }

    public String getApplyIfFormula() {
        return this.applyIfFormula;
    }

    public String getBasePriceFormula() {
        return this.basePriceFormula;
    }
}
