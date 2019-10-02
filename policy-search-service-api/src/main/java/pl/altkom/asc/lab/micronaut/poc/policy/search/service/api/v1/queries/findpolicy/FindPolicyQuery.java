package pl.altkom.asc.lab.micronaut.poc.policy.search.service.api.v1.queries.findpolicy;

import io.reactivex.Maybe;
import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

public class FindPolicyQuery implements Query<Maybe<FindPolicyQueryResult>> {
    private String queryText;

    public FindPolicyQuery(String queryText) {
        this.queryText = queryText;
    }

    public FindPolicyQuery() {
    }

    public static FindPolicyQueryBuilder builder() {
        return new FindPolicyQueryBuilder();
    }

    public String getQueryText() {
        return this.queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public static class FindPolicyQueryBuilder {
        private String queryText;

        FindPolicyQueryBuilder() {
        }

        public FindPolicyQuery.FindPolicyQueryBuilder queryText(String queryText) {
            this.queryText = queryText;
            return this;
        }

        public FindPolicyQuery build() {
            return new FindPolicyQuery(queryText);
        }

        public String toString() {
            return "FindPolicyQuery.FindPolicyQueryBuilder(queryText=" + this.queryText + ")";
        }
    }
}
