package pl.altkom.asc.lab.micronaut.poc.policy.search.readmodel;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.dto.PolicyDto;

final class PolicyViewAssembler {

    private PolicyViewAssembler() {
    }

    static PolicyView map(PolicyDto policy) {
        return PolicyView.builder()
                .number(policy.getNumber())
                .dateFrom(policy.getFrom())
                .dateTo(policy.getTo())
                .policyHolder(policy.getPolicyHolder())
                .build();
    }
}
