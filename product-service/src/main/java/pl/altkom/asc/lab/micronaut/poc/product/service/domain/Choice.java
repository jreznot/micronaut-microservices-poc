package pl.altkom.asc.lab.micronaut.poc.product.service.domain;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Choice {
    private String code;
    private String label;

    @BsonCreator
    public Choice(@BsonProperty("code") String code, @BsonProperty("label") String label) {
        this.code = code;
        this.label = label;
    }

    public Choice() {
    }

    public String getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }
}
