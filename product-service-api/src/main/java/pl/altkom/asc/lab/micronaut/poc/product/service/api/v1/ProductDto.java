package pl.altkom.asc.lab.micronaut.poc.product.service.api.v1;

import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.questions.QuestionDto;

import java.util.List;

public class ProductDto {
    private String code;
    private String name;
    private String image;
    private String description;
    private List<CoverDto> covers;
    private List<QuestionDto> questions;
    private int maxNumberOfInsured;

    public ProductDto(String code, String name, String image, String description,
                      List<CoverDto> covers, List<QuestionDto> questions, int maxNumberOfInsured) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.description = description;
        this.covers = covers;
        this.questions = questions;
        this.maxNumberOfInsured = maxNumberOfInsured;
    }

    public ProductDto() {
    }

    public static ProductDtoBuilder builder() {
        return new ProductDtoBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public List<CoverDto> getCovers() {
        return this.covers;
    }

    public List<QuestionDto> getQuestions() {
        return this.questions;
    }

    public int getMaxNumberOfInsured() {
        return this.maxNumberOfInsured;
    }

    public static class ProductDtoBuilder {
        private String code;
        private String name;
        private String image;
        private String description;
        private List<CoverDto> covers;
        private List<QuestionDto> questions;
        private int maxNumberOfInsured;

        ProductDtoBuilder() {
        }

        public ProductDto.ProductDtoBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ProductDto.ProductDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductDto.ProductDtoBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ProductDto.ProductDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductDto.ProductDtoBuilder covers(List<CoverDto> covers) {
            this.covers = covers;
            return this;
        }

        public ProductDto.ProductDtoBuilder questions(List<QuestionDto> questions) {
            this.questions = questions;
            return this;
        }

        public ProductDto.ProductDtoBuilder maxNumberOfInsured(int maxNumberOfInsured) {
            this.maxNumberOfInsured = maxNumberOfInsured;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(code, name, image, description, covers, questions, maxNumberOfInsured);
        }

        public String toString() {
            return "ProductDto.ProductDtoBuilder(code=" + this.code + ", name=" + this.name + ", image=" + this.image + ", description=" + this.description + ", covers=" + this.covers + ", questions=" + this.questions + ", maxNumberOfInsured=" + this.maxNumberOfInsured + ")";
        }
    }
}
