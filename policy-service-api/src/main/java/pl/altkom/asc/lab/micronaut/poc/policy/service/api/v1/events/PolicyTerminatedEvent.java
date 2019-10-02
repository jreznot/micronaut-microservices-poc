package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events;

import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.events.dto.PolicyDto;

public class PolicyTerminatedEvent {
    private PolicyDto policy;

    public PolicyTerminatedEvent(PolicyDto policy) {
        this.policy = policy;
    }

    public PolicyTerminatedEvent() {
    }

    public PolicyDto getPolicy() {
        return this.policy;
    }
}
