package pl.altkom.asc.lab.micronaut.poc.product.service.domain;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.math.BigDecimal;

public class Cover {
    private String code;
    private String name;
    private String description;
    private boolean optional;
    private BigDecimal sumInsured;

    @BsonCreator
    public Cover(
            @BsonProperty("code") String code,
            @BsonProperty("name") String name,
            @BsonProperty("description") String description,
            @BsonProperty("optional") boolean optional,
            @BsonProperty("sumInsured") BigDecimal sumInsured) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.optional = optional;
        this.sumInsured = sumInsured;
    }

    public Cover() {
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
