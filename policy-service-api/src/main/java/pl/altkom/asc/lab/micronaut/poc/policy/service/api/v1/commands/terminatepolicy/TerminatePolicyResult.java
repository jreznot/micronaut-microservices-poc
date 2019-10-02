package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.terminatepolicy;

public class TerminatePolicyResult {

    private String policyNumber;

    public TerminatePolicyResult(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public TerminatePolicyResult() {
    }

    public static TerminatePolicyResult success(String policyNumber) {
        return new TerminatePolicyResult(policyNumber);
    }

    public static TerminatePolicyResult empty() {
        return new TerminatePolicyResult();
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }
}
