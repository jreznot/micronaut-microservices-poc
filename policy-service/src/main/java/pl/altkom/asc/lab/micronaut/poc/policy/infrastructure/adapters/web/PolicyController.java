package pl.altkom.asc.lab.micronaut.poc.policy.infrastructure.adapters.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;
import pl.altkom.asc.lab.micronaut.poc.command.bus.CommandBus;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.PolicyOperations;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy.CreatePolicyCommand;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy.CreatePolicyResult;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.terminatepolicy.TerminatePolicyCommand;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.terminatepolicy.TerminatePolicyResult;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails.GetPolicyDetailsQuery;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.getpolicydetails.GetPolicyDetailsQueryResult;

@Validated
@Controller("/policies")
public class PolicyController implements PolicyOperations {

    private final CommandBus bus;

    public PolicyController(CommandBus bus) {
        this.bus = bus;
    }

    @Override
    public GetPolicyDetailsQueryResult get(String policyNumber) {
        return bus.executeQuery(new GetPolicyDetailsQuery(policyNumber));
    }

    @Override
    public CreatePolicyResult create(CreatePolicyCommand cmd) {
        return bus.executeCommand(cmd);
    }

    @Override
    public TerminatePolicyResult terminate(TerminatePolicyCommand cmd) {
        return bus.executeCommand(cmd);
    }
}
