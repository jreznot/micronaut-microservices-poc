package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer;

import java.math.BigDecimal;
import java.util.Map;

public class CreateOfferResult {
    private String offerNumber;
    private BigDecimal totalPrice;
    private Map<String, BigDecimal> coversPrices;

    public CreateOfferResult(String offerNumber, BigDecimal totalPrice, Map<String, BigDecimal> coversPrices) {
        this.offerNumber = offerNumber;
        this.totalPrice = totalPrice;
        this.coversPrices = coversPrices;
    }

    public CreateOfferResult() {
    }

    public static CreateOfferResult empty() {
        return new CreateOfferResult();
    }

    public String getOfferNumber() {
        return this.offerNumber;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, BigDecimal> getCoversPrices() {
        return this.coversPrices;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCoversPrices(Map<String, BigDecimal> coversPrices) {
        this.coversPrices = coversPrices;
    }
}
