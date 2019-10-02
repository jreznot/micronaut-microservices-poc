package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice;

import java.math.BigDecimal;
import java.util.Map;

public class CalculatePriceResult {
    private BigDecimal totalPrice;
    private Map<String, BigDecimal> coversPrices;

    public CalculatePriceResult(BigDecimal totalPrice, Map<String, BigDecimal> coversPrices) {
        this.totalPrice = totalPrice;
        this.coversPrices = coversPrices;
    }

    public CalculatePriceResult() {
    }

    public static CalculatePriceResult empty() {
        return new CalculatePriceResult();
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, BigDecimal> getCoversPrices() {
        return this.coversPrices;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCoversPrices(Map<String, BigDecimal> coversPrices) {
        this.coversPrices = coversPrices;
    }
}
