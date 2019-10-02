package pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions;

public class ChoiceDto {
    private String code;
    private String label;

    public ChoiceDto(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public ChoiceDto() {
    }

    public String getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }
}
