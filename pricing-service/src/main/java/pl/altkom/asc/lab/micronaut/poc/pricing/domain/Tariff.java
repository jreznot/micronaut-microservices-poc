package pl.altkom.asc.lab.micronaut.poc.pricing.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @ElementCollection
    @CollectionTable(name = "base_price_rules", joinColumns = @JoinColumn(name = "tariff_id"))
    private List<BasePremiumCalculationRule> basePriceCalculationRules;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DiscountMarkupRule> discountMarkupRules;
    
    public Tariff( String code) {
        this.code = code;
        this.basePriceCalculationRules = new ArrayList<>();
        this.discountMarkupRules = new ArrayList<>();
    }

    public Tariff() {
    }

    public BasePremiumCalculationRuleList rules() {
        return new BasePremiumCalculationRuleList(basePriceCalculationRules);
    }

    public DiscountMarkupRuleList discountMarkupRules() {
        return new DiscountMarkupRuleList(this, discountMarkupRules);
    }

    public Calculation calculatePrice(Calculation calculation) {
        calcBasePrices(calculation);
        applyDiscounts(calculation);
        buildResponse(calculation);

        return calculation;
    }

    private void calcBasePrices(Calculation calculation) {
        for (Cover c : calculation.getCovers().values()) {
            c.setPrice(rules().calculateBasePriceFor(c, calculation));
        }
    }

    private void applyDiscounts(Calculation calculation) {
        discountMarkupRules().apply(calculation);
    }

    private void buildResponse(Calculation calculation) {
        calculation.updateTotal();
    }

    public Long getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public List<BasePremiumCalculationRule> getBasePriceCalculationRules() {
        return this.basePriceCalculationRules;
    }

    public List<DiscountMarkupRule> getDiscountMarkupRules() {
        return this.discountMarkupRules;
    }
}
