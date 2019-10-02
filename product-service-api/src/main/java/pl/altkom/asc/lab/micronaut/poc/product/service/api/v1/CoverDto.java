package pl.altkom.asc.lab.micronaut.poc.product.service.api.v1;

import java.math.BigDecimal;

public class CoverDto {
    private String code;
    private String name;
    private String description;
    private boolean optional;
    private BigDecimal sumInsured;

    public CoverDto(String code, String name, String description, boolean optional, BigDecimal sumInsured) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.optional = optional;
        this.sumInsured = sumInsured;
    }

    public CoverDto() {
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public BigDecimal getSumInsured() {
        return this.sumInsured;
    }
}
