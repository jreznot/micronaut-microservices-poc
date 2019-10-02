package pl.altkom.asc.lab.micronaut.poc.product.service.domain;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator
public class Question {
    private String code;
    private int index;
    private String text;

    public Question(String code, int index, String text) {
        this.code = code;
        this.index = index;
        this.text = text;
    }

    public Question() {
    }

    public String getCode() {
        return this.code;
    }

    public int getIndex() {
        return this.index;
    }

    public String getText() {
        return this.text;
    }
}
