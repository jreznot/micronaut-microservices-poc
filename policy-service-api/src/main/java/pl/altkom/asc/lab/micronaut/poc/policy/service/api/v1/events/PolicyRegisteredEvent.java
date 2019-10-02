package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.dto.PolicyDto;

public class PolicyRegisteredEvent {
    private PolicyDto policy;

    public PolicyRegisteredEvent(PolicyDto policy) {
        this.policy = policy;
    }

    public PolicyRegisteredEvent() {
    }

    public PolicyDto getPolicy() {
        return this.policy;
    }
}
