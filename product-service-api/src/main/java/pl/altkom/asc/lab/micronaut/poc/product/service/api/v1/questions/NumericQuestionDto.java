package pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions;

public class NumericQuestionDto extends QuestionDto {
    public NumericQuestionDto(String code, int index, String text) {
        super(code, index, text);
    }

    public NumericQuestionDto() {
    }
}