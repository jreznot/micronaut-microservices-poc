package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice;

import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer;

import java.time.LocalDate;
import java.util.List;

public class CalculatePriceCommand {
    private String productCode;
    private LocalDate policyFrom;
    private LocalDate policyTo;
    private List<String> selectedCovers;
    private List<QuestionAnswer> answers;

    public CalculatePriceCommand(String productCode, LocalDate policyFrom, LocalDate policyTo, List<String> selectedCovers,
                                 List<QuestionAnswer> answers) {
        this.productCode = productCode;
        this.policyFrom = policyFrom;
        this.policyTo = policyTo;
        this.selectedCovers = selectedCovers;
        this.answers = answers;
    }

    public CalculatePriceCommand() {
    }

    public static CalculatePriceCommandBuilder builder() {
        return new CalculatePriceCommandBuilder();
    }

    public String getProductCode() {
        return this.productCode;
    }

    public LocalDate getPolicyFrom() {
        return this.policyFrom;
    }

    public LocalDate getPolicyTo() {
        return this.policyTo;
    }

    public List<String> getSelectedCovers() {
        return this.selectedCovers;
    }

    public List<QuestionAnswer> getAnswers() {
        return this.answers;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setPolicyFrom(LocalDate policyFrom) {
        this.policyFrom = policyFrom;
    }

    public void setPolicyTo(LocalDate policyTo) {
        this.policyTo = policyTo;
    }

    public void setSelectedCovers(List<String> selectedCovers) {
        this.selectedCovers = selectedCovers;
    }

    public void setAnswers(List<QuestionAnswer> answers) {
        this.answers = answers;
    }

    public static class CalculatePriceCommandBuilder {
        private String productCode;
        private LocalDate policyFrom;
        private LocalDate policyTo;
        private List<String> selectedCovers;
        private List<QuestionAnswer> answers;

        CalculatePriceCommandBuilder() {
        }

        public CalculatePriceCommand.CalculatePriceCommandBuilder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public CalculatePriceCommand.CalculatePriceCommandBuilder policyFrom(LocalDate policyFrom) {
            this.policyFrom = policyFrom;
            return this;
        }

        public CalculatePriceCommand.CalculatePriceCommandBuilder policyTo(LocalDate policyTo) {
            this.policyTo = policyTo;
            return this;
        }

        public CalculatePriceCommand.CalculatePriceCommandBuilder selectedCovers(List<String> selectedCovers) {
            this.selectedCovers = selectedCovers;
            return this;
        }

        public CalculatePriceCommand.CalculatePriceCommandBuilder answers(List<QuestionAnswer> answers) {
            this.answers = answers;
            return this;
        }

        public CalculatePriceCommand build() {
            return new CalculatePriceCommand(productCode, policyFrom, policyTo, selectedCovers, answers);
        }

        public String toString() {
            return "CalculatePriceCommand.CalculatePriceCommandBuilder(productCode=" + this.productCode
                    + ", policyFrom=" + this.policyFrom + ", policyTo=" + this.policyTo + ", selectedCovers="
                    + this.selectedCovers + ", answers=" + this.answers + ")";
        }
    }
}
