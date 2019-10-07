package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getagentssalesquery;

import pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getagentssalesquery.dto.SalesDto;

import java.util.ArrayList;
import java.util.Map;

public class GetAgentsSalesQueryResult {
    private Map<String, SalesDto> perAgentTotal;

    public GetAgentsSalesQueryResult(Map<String, SalesDto> perAgentTotal) {
        this.perAgentTotal = perAgentTotal;
    }

    public GetAgentsSalesQueryResult() {
    }

    public static GetAgentsSalesQueryResultBuilder builder() {
        return new GetAgentsSalesQueryResultBuilder();
    }

    public Map<String, SalesDto> getPerAgentTotal() {
        return this.perAgentTotal;
    }

    public void setPerAgentTotal(Map<String, SalesDto> perAgentTotal) {
        this.perAgentTotal = perAgentTotal;
    }

    public static class GetAgentsSalesQueryResultBuilder {
        private ArrayList<String> perAgentTotal$key;
        private ArrayList<SalesDto> perAgentTotal$value;

        GetAgentsSalesQueryResultBuilder() {
        }

        public GetAgentsSalesQueryResult.GetAgentsSalesQueryResultBuilder agentTotal(String agentTotalKey, SalesDto agentTotalValue) {
            if (this.perAgentTotal$key == null) {
                this.perAgentTotal$key = new ArrayList<>();
                this.perAgentTotal$value = new ArrayList<>();
            }
            this.perAgentTotal$key.add(agentTotalKey);
            this.perAgentTotal$value.add(agentTotalValue);
            return this;
        }

        public GetAgentsSalesQueryResult.GetAgentsSalesQueryResultBuilder perAgentTotal(Map<? extends String, ? extends SalesDto> perAgentTotal) {
            if (this.perAgentTotal$key == null) {
                this.perAgentTotal$key = new ArrayList<>();
                this.perAgentTotal$value = new ArrayList<>();
            }
            for (final Map.Entry<? extends String, ? extends SalesDto> entry : perAgentTotal.entrySet()) {
                this.perAgentTotal$key.add(entry.getKey());
                this.perAgentTotal$value.add(entry.getValue());
            }
            return this;
        }

        public GetAgentsSalesQueryResult.GetAgentsSalesQueryResultBuilder clearPerAgentTotal() {
            if (this.perAgentTotal$key != null) {
                this.perAgentTotal$key.clear();
                this.perAgentTotal$value.clear();
            }

            return this;
        }

        public GetAgentsSalesQueryResult build() {
            Map<String, SalesDto> perAgentTotal;
            switch (this.perAgentTotal$key == null ? 0 : this.perAgentTotal$key.size()) {
                case 0:
                    perAgentTotal = java.util.Collections.emptyMap();
                    break;
                case 1:
                    perAgentTotal = java.util.Collections.singletonMap(this.perAgentTotal$key.get(0), this.perAgentTotal$value.get(0));
                    break;
                default:
                    perAgentTotal = new java.util.LinkedHashMap<>(this.perAgentTotal$key.size() < 1073741824 ? 1 + this.perAgentTotal$key.size() + (this.perAgentTotal$key.size() - 3) / 3 : Integer.MAX_VALUE);
                    for (int $i = 0; $i < this.perAgentTotal$key.size(); $i++)
                        perAgentTotal.put(this.perAgentTotal$key.get($i), this.perAgentTotal$value.get($i));
                    perAgentTotal = java.util.Collections.unmodifiableMap(perAgentTotal);
            }

            return new GetAgentsSalesQueryResult(perAgentTotal);
        }

        public String toString() {
            return "GetAgentsSalesQueryResult.GetAgentsSalesQueryResultBuilder(perAgentTotal$key=" + this.perAgentTotal$key + ", perAgentTotal$value=" + this.perAgentTotal$value + ")";
        }
    }
}
