package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy.dto.PersonDto;

public class CreatePolicyCommand implements Command<CreatePolicyResult> {
    private String offerNumber;
    private PersonDto policyHolder;

    public CreatePolicyCommand(String offerNumber, PersonDto policyHolder) {
        this.offerNumber = offerNumber;
        this.policyHolder = policyHolder;
    }

    public CreatePolicyCommand() {
    }

    public String getOfferNumber() {
        return this.offerNumber;
    }

    public PersonDto getPolicyHolder() {
        return this.policyHolder;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public void setPolicyHolder(PersonDto policyHolder) {
        this.policyHolder = policyHolder;
    }
}
