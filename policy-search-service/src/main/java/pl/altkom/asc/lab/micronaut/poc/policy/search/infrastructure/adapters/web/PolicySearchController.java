package pl.altkom.asc.lab.micronaut.poc.policy.search.infrastructure.adapters.web;

import io.micronaut.http.annotation.Controller;
import io.reactivex.Maybe;
import pl.altkom.asc.lab.micronaut.poc.command.bus.CommandBus;
import pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.PolicySearchOperations;
import pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy.FindPolicyQuery;
import pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy.FindPolicyQueryResult;

@Controller("/policies")
public class PolicySearchController implements PolicySearchOperations {

    private final CommandBus bus;

    public PolicySearchController(CommandBus bus) {
        this.bus = bus;
    }

    @Override
    public Maybe<FindPolicyQueryResult> policies(String queryText) {
        return bus.executeQuery(new FindPolicyQuery(queryText));
    }
}
