package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SalesTrendsQuery {
    private String filterByProductCode;
    private LocalDateRange filterBySalesDate;
    private TimeAggregationUnit aggregationUnit;

    public SalesTrendsQuery(String filterByProductCode, LocalDateRange filterBySalesDate, TimeAggregationUnit aggregationUnit) {
        this.filterByProductCode = filterByProductCode;
        this.filterBySalesDate = filterBySalesDate;
        this.aggregationUnit = aggregationUnit;
    }

    public static SalesTrendsQueryBuilder builder() {
        return new SalesTrendsQueryBuilder();
    }

    public String getFilterByProductCode() {
        return this.filterByProductCode;
    }

    public LocalDateRange getFilterBySalesDate() {
        return this.filterBySalesDate;
    }

    public TimeAggregationUnit getAggregationUnit() {
        return this.aggregationUnit;
    }

    public static class Result {
        private List<PeriodSales> periodSales;

        public Result(List<PeriodSales> periodSales) {
            this.periodSales = periodSales;
        }

        public static ResultBuilder builder() {
            return new ResultBuilder();
        }

        public List<PeriodSales> getPeriodSales() {
            return this.periodSales;
        }

        public static class ResultBuilder {
            private ArrayList<PeriodSales> periodSales;

            ResultBuilder() {
            }

            public Result.ResultBuilder periodSale(PeriodSales periodSale) {
                if (this.periodSales == null) this.periodSales = new ArrayList<PeriodSales>();
                this.periodSales.add(periodSale);
                return this;
            }

            public Result.ResultBuilder periodSales(Collection<? extends PeriodSales> periodSales) {
                if (this.periodSales == null) this.periodSales = new ArrayList<PeriodSales>();
                this.periodSales.addAll(periodSales);
                return this;
            }

            public Result.ResultBuilder clearPeriodSales() {
                if (this.periodSales != null)
                    this.periodSales.clear();

                return this;
            }

            public Result build() {
                List<PeriodSales> periodSales;
                switch (this.periodSales == null ? 0 : this.periodSales.size()) {
                    case 0:
                        periodSales = java.util.Collections.emptyList();
                        break;
                    case 1:
                        periodSales = java.util.Collections.singletonList(this.periodSales.get(0));
                        break;
                    default:
                        periodSales = java.util.Collections.unmodifiableList(new ArrayList<PeriodSales>(this.periodSales));
                }

                return new Result(periodSales);
            }

            public String toString() {
                return "SalesTrendsQuery.Result.ResultBuilder(periodSales=" + this.periodSales + ")";
            }
        }
    }

    public static class PeriodSales {
        private LocalDate periodDate;
        private String period;
        private SalesResult sales;

        public PeriodSales(LocalDate periodDate, String period, SalesResult sales) {
            this.periodDate = periodDate;
            this.period = period;
            this.sales = sales;
        }

        public static PeriodSalesBuilder builder() {
            return new PeriodSalesBuilder();
        }

        public LocalDate getPeriodDate() {
            return this.periodDate;
        }

        public String getPeriod() {
            return this.period;
        }

        public SalesResult getSales() {
            return this.sales;
        }

        public static class PeriodSalesBuilder {
            private LocalDate periodDate;
            private String period;
            private SalesResult sales;

            PeriodSalesBuilder() {
            }

            public PeriodSales.PeriodSalesBuilder periodDate(LocalDate periodDate) {
                this.periodDate = periodDate;
                return this;
            }

            public PeriodSales.PeriodSalesBuilder period(String period) {
                this.period = period;
                return this;
            }

            public PeriodSales.PeriodSalesBuilder sales(SalesResult sales) {
                this.sales = sales;
                return this;
            }

            public PeriodSales build() {
                return new PeriodSales(periodDate, period, sales);
            }

            public String toString() {
                return "SalesTrendsQuery.PeriodSales.PeriodSalesBuilder(periodDate=" + this.periodDate + ", period=" + this.period + ", sales=" + this.sales + ")";
            }
        }
    }

    public static class SalesTrendsQueryBuilder {
        private String filterByProductCode;
        private LocalDateRange filterBySalesDate;
        private TimeAggregationUnit aggregationUnit;

        SalesTrendsQueryBuilder() {
        }

        public SalesTrendsQuery.SalesTrendsQueryBuilder filterByProductCode(String filterByProductCode) {
            this.filterByProductCode = filterByProductCode;
            return this;
        }

        public SalesTrendsQuery.SalesTrendsQueryBuilder filterBySalesDate(LocalDateRange filterBySalesDate) {
            this.filterBySalesDate = filterBySalesDate;
            return this;
        }

        public SalesTrendsQuery.SalesTrendsQueryBuilder aggregationUnit(TimeAggregationUnit aggregationUnit) {
            this.aggregationUnit = aggregationUnit;
            return this;
        }

        public SalesTrendsQuery build() {
            return new SalesTrendsQuery(filterByProductCode, filterBySalesDate, aggregationUnit);
        }

        public String toString() {
            return "SalesTrendsQuery.SalesTrendsQueryBuilder(filterByProductCode=" + this.filterByProductCode + ", filterBySalesDate=" + this.filterBySalesDate + ", aggregationUnit=" + this.aggregationUnit + ")";
        }
    }
}
