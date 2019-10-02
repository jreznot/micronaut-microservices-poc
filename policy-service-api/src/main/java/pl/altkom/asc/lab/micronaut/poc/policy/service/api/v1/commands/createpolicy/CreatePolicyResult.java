/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy;

public class CreatePolicyResult {
    private String policyNumber;

    public CreatePolicyResult() {
    }

    public CreatePolicyResult(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
