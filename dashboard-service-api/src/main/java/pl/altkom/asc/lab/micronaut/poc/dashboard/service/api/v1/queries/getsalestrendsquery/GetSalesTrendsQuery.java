package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

import java.time.LocalDate;

public class GetSalesTrendsQuery implements Query<GetSalesTrendsQueryResult> {
    private String productCode;
    private LocalDate saleDateFrom;
    private LocalDate saleDateTo;
    private String aggregationUnitCode;

    public GetSalesTrendsQuery(String productCode, LocalDate saleDateFrom, LocalDate saleDateTo, String aggregationUnitCode) {
        this.productCode = productCode;
        this.saleDateFrom = saleDateFrom;
        this.saleDateTo = saleDateTo;
        this.aggregationUnitCode = aggregationUnitCode;
    }

    public GetSalesTrendsQuery() {
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

    public String getAggregationUnitCode() {
        return this.aggregationUnitCode;
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

    public void setAggregationUnitCode(String aggregationUnitCode) {
        this.aggregationUnitCode = aggregationUnitCode;
    }
}
