package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

public class GetPolicyDetailsQuery implements Query<GetPolicyDetailsQueryResult> {
    private String number;

    public GetPolicyDetailsQuery(String number) {
        this.number = number;
    }

    public GetPolicyDetailsQuery() {
    }

    public String getNumber() {
        return this.number;
    }
}
