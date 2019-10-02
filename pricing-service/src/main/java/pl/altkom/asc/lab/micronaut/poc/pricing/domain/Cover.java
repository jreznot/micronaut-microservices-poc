package pl.altkom.asc.lab.micronaut.poc.pricing.domain;

import java.math.BigDecimal;

public class Cover {

    private String code;
    private BigDecimal price;

    public Cover(String code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return this.code;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
