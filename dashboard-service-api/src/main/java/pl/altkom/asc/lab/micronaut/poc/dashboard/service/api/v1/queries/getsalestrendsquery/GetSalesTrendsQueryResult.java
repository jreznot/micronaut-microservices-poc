package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery;

import pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto;

import java.util.List;

public class GetSalesTrendsQueryResult {
    List<PeriodSalesDto> periodSales;

    public GetSalesTrendsQueryResult(List<PeriodSalesDto> periodSales) {
        this.periodSales = periodSales;
    }

    public GetSalesTrendsQueryResult() {
    }

    public List<PeriodSalesDto> getPeriodSales() {
        return this.periodSales;
    }

    public void setPeriodSales(List<PeriodSalesDto> periodSales) {
        this.periodSales = periodSales;
    }
}
