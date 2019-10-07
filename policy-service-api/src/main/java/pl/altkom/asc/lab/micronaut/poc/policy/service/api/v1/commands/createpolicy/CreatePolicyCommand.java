package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy.dto.PersonDto;

public class CreatePolicyCommand implements Command<CreatePolicyResult> {
    private String offerNumber;
    private PersonDto policyHolder;
    private String agentLogin;

    public CreatePolicyCommand(String offerNumber, PersonDto policyHolder,
                               String agentLogin) {
        this.offerNumber = offerNumber;
        this.policyHolder = policyHolder;
        this.agentLogin = agentLogin;
    }

    public CreatePolicyCommand() {
    }

    public String getAgentLogin() {
        return agentLogin;
    }

    public void setAgentLogin(String agentLogin) {
        this.agentLogin = agentLogin;
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
