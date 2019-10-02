package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.terminatepolicy;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;

public class TerminatePolicyCommand implements Command<TerminatePolicyResult> {
    private String policyNumber;

    public TerminatePolicyCommand(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public TerminatePolicyCommand() {
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
