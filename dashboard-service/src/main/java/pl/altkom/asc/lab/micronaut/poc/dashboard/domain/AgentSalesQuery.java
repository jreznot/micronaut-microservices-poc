package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.util.Map;

public class AgentSalesQuery {
    private String filterByAgentLogin;
    private String filterByProductCode;
    private LocalDateRange filterBySalesDate;

    public AgentSalesQuery(String filterByAgentLogin, String filterByProductCode, LocalDateRange filterBySalesDate) {
        this.filterByAgentLogin = filterByAgentLogin;
        this.filterByProductCode = filterByProductCode;
        this.filterBySalesDate = filterBySalesDate;
    }

    public static pl.altkom.asc.lab.micronaut.poc.dashboard.domain.AgentSalesQuery.AgentSalesQueryBuilder builder() {
        return new AgentSalesQueryBuilder();
    }

    public String getFilterByAgentLogin() {
        return this.filterByAgentLogin;
    }

    public String getFilterByProductCode() {
        return this.filterByProductCode;
    }

    public LocalDateRange getFilterBySalesDate() {
        return this.filterBySalesDate;
    }

    public static class Result {
        private Map<String, SalesResult> perAgentTotal;

        public Result(Map<String, SalesResult> perAgentTotal) {
            this.perAgentTotal = perAgentTotal;
        }

        public Map<String, SalesResult> getPerAgentTotal() {
            return this.perAgentTotal;
        }
    }

    public static class AgentSalesQueryBuilder {
        private String filterByAgentLogin;
        private String filterByProductCode;
        private LocalDateRange filterBySalesDate;

        AgentSalesQueryBuilder() {
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.domain.AgentSalesQuery.AgentSalesQueryBuilder filterByAgentLogin(String filterByAgentLogin) {
            this.filterByAgentLogin = filterByAgentLogin;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.domain.AgentSalesQuery.AgentSalesQueryBuilder filterByProductCode(String filterByProductCode) {
            this.filterByProductCode = filterByProductCode;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.domain.AgentSalesQuery.AgentSalesQueryBuilder filterBySalesDate(LocalDateRange filterBySalesDate) {
            this.filterBySalesDate = filterBySalesDate;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.domain.AgentSalesQuery build() {
            return new AgentSalesQuery(filterByAgentLogin, filterByProductCode, filterBySalesDate);
        }

        public String toString() {
            return "AgentSalesQuery.AgentSalesQueryBuilder(filterByAgentLogin=" + this.filterByAgentLogin + ", filterByProductCode=" + this.filterByProductCode + ", filterBySalesDate=" + this.filterBySalesDate + ")";
        }
    }
}
