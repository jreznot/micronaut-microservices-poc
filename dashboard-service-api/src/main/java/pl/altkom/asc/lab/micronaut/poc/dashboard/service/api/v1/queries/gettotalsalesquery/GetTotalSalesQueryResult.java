package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.gettotalsalesquery;

import pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.gettotalsalesquery.dto.SalesDto;

import java.util.Map;

public class GetTotalSalesQueryResult {
    private SalesDto total;
    private Map<String,SalesDto> perProductTotal;

    public GetTotalSalesQueryResult(SalesDto total, Map<String, SalesDto> perProductTotal) {
        this.total = total;
        this.perProductTotal = perProductTotal;
    }

    public GetTotalSalesQueryResult() {
    }

    public SalesDto getTotal() {
        return this.total;
    }

    public Map<String, SalesDto> getPerProductTotal() {
        return this.perProductTotal;
    }

    public void setTotal(SalesDto total) {
        this.total = total;
    }

    public void setPerProductTotal(Map<String, SalesDto> perProductTotal) {
        this.perProductTotal = perProductTotal;
    }
}
