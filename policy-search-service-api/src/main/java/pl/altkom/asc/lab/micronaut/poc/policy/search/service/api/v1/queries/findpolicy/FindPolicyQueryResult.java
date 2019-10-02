package pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy;

import pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy.dto.PolicyListItemDto;

import java.util.Collections;
import java.util.List;

public class FindPolicyQueryResult {
    private List<PolicyListItemDto> policies;

    public FindPolicyQueryResult(List<PolicyListItemDto> policies) {
        this.policies = policies;
    }

    public FindPolicyQueryResult() {
    }

    public static FindPolicyQueryResult empty() {
        return new FindPolicyQueryResult(Collections.emptyList());
    }

    public List<PolicyListItemDto> getPolicies() {
        return this.policies;
    }
}
