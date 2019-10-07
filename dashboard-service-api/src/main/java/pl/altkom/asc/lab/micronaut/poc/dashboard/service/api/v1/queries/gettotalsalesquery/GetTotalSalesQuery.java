package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.gettotalsalesquery;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

import java.time.LocalDate;

public class GetTotalSalesQuery implements Query<GetTotalSalesQueryResult> {
    private String productCode;
    private LocalDate saleDateFrom;
    private LocalDate saleDateTo;

    public GetTotalSalesQuery(String productCode, LocalDate saleDateFrom, LocalDate saleDateTo) {
        this.productCode = productCode;
        this.saleDateFrom = saleDateFrom;
        this.saleDateTo = saleDateTo;
    }

    public GetTotalSalesQuery() {
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
