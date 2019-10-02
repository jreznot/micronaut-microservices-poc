package pl.altkom.asc.lab.micronaut.poc.product.service.domain;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class DateQuestion extends Question {
    @BsonCreator
    public DateQuestion(
            @BsonProperty("code") String code,
            @BsonProperty("index") int index,
            @BsonProperty("text") String text) {
        super(code, index, text);
    }

    public DateQuestion() {
    }
}
