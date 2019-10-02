package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.QuestionAnswer;

import java.time.LocalDate;
import java.util.List;

public class CreateOfferCommand implements Command<CreateOfferResult> {
    private String productCode;
    private LocalDate policyFrom;
    private LocalDate policyTo;
    private List<String> selectedCovers;
    private List<QuestionAnswer> answers;

    public CreateOfferCommand(String productCode, LocalDate policyFrom, LocalDate policyTo, List<String> selectedCovers,
                              List<QuestionAnswer> answers) {
        this.productCode = productCode;
        this.policyFrom = policyFrom;
        this.policyTo = policyTo;
        this.selectedCovers = selectedCovers;
        this.answers = answers;
    }

    public CreateOfferCommand() {
    }

    public static CreateOfferCommandBuilder builder() {
        return new CreateOfferCommandBuilder();
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

    public static class CreateOfferCommandBuilder {
        private String productCode;
        private LocalDate policyFrom;
        private LocalDate policyTo;
        private List<String> selectedCovers;
        private List<QuestionAnswer> answers;

        CreateOfferCommandBuilder() {
        }

        public CreateOfferCommand.CreateOfferCommandBuilder productCode(String productCode) {
            this.productCode = productCode;
            return this;
        }

        public CreateOfferCommand.CreateOfferCommandBuilder policyFrom(LocalDate policyFrom) {
            this.policyFrom = policyFrom;
            return this;
        }

        public CreateOfferCommand.CreateOfferCommandBuilder policyTo(LocalDate policyTo) {
            this.policyTo = policyTo;
            return this;
        }

        public CreateOfferCommand.CreateOfferCommandBuilder selectedCovers(List<String> selectedCovers) {
            this.selectedCovers = selectedCovers;
            return this;
        }

        public CreateOfferCommand.CreateOfferCommandBuilder answers(List<QuestionAnswer> answers) {
            this.answers = answers;
            return this;
        }

        public CreateOfferCommand build() {
            return new CreateOfferCommand(productCode, policyFrom, policyTo, selectedCovers, answers);
        }

        public String toString() {
            return "CreateOfferCommand.CreateOfferCommandBuilder(productCode=" + this.productCode + ", policyFrom="
                    + this.policyFrom + ", policyTo=" + this.policyTo + ", selectedCovers=" + this.selectedCovers
                    + ", answers=" + this.answers + ")";
        }
    }
}
