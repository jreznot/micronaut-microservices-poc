package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails.dto.PolicyDetailsDto;

public class GetPolicyDetailsQueryResult {
    private PolicyDetailsDto policy;

    public GetPolicyDetailsQueryResult(PolicyDetailsDto policy) {
        this.policy = policy;
    }

    public GetPolicyDetailsQueryResult() {
    }

    public static GetPolicyDetailsQueryResult empty() {
        return new GetPolicyDetailsQueryResult(new PolicyDetailsDto());
    }

    public PolicyDetailsDto getPolicy() {
        return this.policy;
    }
}
