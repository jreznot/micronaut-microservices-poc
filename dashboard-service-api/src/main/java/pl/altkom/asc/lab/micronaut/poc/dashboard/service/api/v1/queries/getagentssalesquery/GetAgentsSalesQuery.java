package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getagentssalesquery;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

import java.time.LocalDate;

public class GetAgentsSalesQuery implements Query<GetAgentsSalesQueryResult> {
    private String agentLogin;
    private String productCode;
    private LocalDate saleDateFrom;
    private LocalDate saleDateTo;

    public GetAgentsSalesQuery(String agentLogin, String productCode, LocalDate saleDateFrom, LocalDate saleDateTo) {
        this.agentLogin = agentLogin;
        this.productCode = productCode;
        this.saleDateFrom = saleDateFrom;
        this.saleDateTo = saleDateTo;
    }

    public GetAgentsSalesQuery() {
    }

    public String getAgentLogin() {
        return this.agentLogin;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public LocalDate getSaleDateFrom() {
        return this.saleDateFrom;
    }

    public LocalDate getSaleDateTo() {
        return this.saleDateTo;
    }

    public void setAgentLogin(String agentLogin) {
        this.agentLogin = agentLogin;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setSaleDateFrom(LocalDate saleDateFrom) {
        this.saleDateFrom = saleDateFrom;
    }

    public void setSaleDateTo(LocalDate saleDateTo) {
        this.saleDateTo = saleDateTo;
    }
}
