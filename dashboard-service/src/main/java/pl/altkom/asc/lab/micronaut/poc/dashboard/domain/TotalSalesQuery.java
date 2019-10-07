package pl.altkom.asc.lab.micronaut.poc.dashboard.domain;

import java.util.ArrayList;
import java.util.Map;

public class TotalSalesQuery {
    private String filterByProductCode;
    private LocalDateRange filterBySalesDate;

    public TotalSalesQuery(String filterByProductCode, LocalDateRange filterBySalesDate) {
        this.filterByProductCode = filterByProductCode;
        this.filterBySalesDate = filterBySalesDate;
    }

    public static TotalSalesQueryBuilder builder() {
        return new TotalSalesQueryBuilder();
    }

    public String getFilterByProductCode() {
        return this.filterByProductCode;
    }

    public LocalDateRange getFilterBySalesDate() {
        return this.filterBySalesDate;
    }

    public static class Result {
        private SalesResult total;
        private Map<String, SalesResult> perProductTotal;

        public Result(SalesResult total, Map<String, SalesResult> perProductTotal) {
            this.total = total;
            this.perProductTotal = perProductTotal;
        }

        public static ResultBuilder builder() {
            return new ResultBuilder();
        }

        public SalesResult getTotal() {
            return this.total;
        }

        public Map<String, SalesResult> getPerProductTotal() {
            return this.perProductTotal;
        }

        public static class ResultBuilder {
            private SalesResult total;
            private ArrayList<String> perProductTotal$key;
            private ArrayList<SalesResult> perProductTotal$value;

            ResultBuilder() {
            }

            public Result.ResultBuilder total(SalesResult total) {
                this.total = total;
                return this;
            }

            public Result.ResultBuilder productTotal(String productTotalKey, SalesResult productTotalValue) {
                if (this.perProductTotal$key == null) {
                    this.perProductTotal$key = new ArrayList<String>();
                    this.perProductTotal$value = new ArrayList<SalesResult>();
                }
                this.perProductTotal$key.add(productTotalKey);
                this.perProductTotal$value.add(productTotalValue);
                return this;
            }

            public Result.ResultBuilder perProductTotal(Map<? extends String, ? extends SalesResult> perProductTotal) {
                if (this.perProductTotal$key == null) {
                    this.perProductTotal$key = new ArrayList<String>();
                    this.perProductTotal$value = new ArrayList<SalesResult>();
                }
                for (final Map.Entry<? extends String, ? extends SalesResult> $lombokEntry : perProductTotal.entrySet()) {
                    this.perProductTotal$key.add($lombokEntry.getKey());
                    this.perProductTotal$value.add($lombokEntry.getValue());
                }
                return this;
            }

            public Result.ResultBuilder clearPerProductTotal() {
                if (this.perProductTotal$key != null) {
                    this.perProductTotal$key.clear();
                    this.perProductTotal$value.clear();
                }

                return this;
            }

            public Result build() {
                Map<String, SalesResult> perProductTotal;
                switch (this.perProductTotal$key == null ? 0 : this.perProductTotal$key.size()) {
                    case 0:
                        perProductTotal = java.util.Collections.emptyMap();
                        break;
                    case 1:
                        perProductTotal = java.util.Collections.singletonMap(this.perProductTotal$key.get(0), this.perProductTotal$value.get(0));
                        break;
                    default:
                        perProductTotal = new java.util.LinkedHashMap<String, SalesResult>(this.perProductTotal$key.size() < 1073741824 ? 1 + this.perProductTotal$key.size() + (this.perProductTotal$key.size() - 3) / 3 : Integer.MAX_VALUE);
                        for (int $i = 0; $i < this.perProductTotal$key.size(); $i++)
                            perProductTotal.put(this.perProductTotal$key.get($i), this.perProductTotal$value.get($i));
                        perProductTotal = java.util.Collections.unmodifiableMap(perProductTotal);
                }

                return new Result(total, perProductTotal);
            }

            public String toString() {
                return "TotalSalesQuery.Result.ResultBuilder(total=" + this.total + ", perProductTotal$key=" + this.perProductTotal$key + ", perProductTotal$value=" + this.perProductTotal$value + ")";
            }
        }
    }

    public static class TotalSalesQueryBuilder {
        private String filterByProductCode;
        private LocalDateRange filterBySalesDate;

        TotalSalesQueryBuilder() {
        }

        public TotalSalesQuery.TotalSalesQueryBuilder filterByProductCode(String filterByProductCode) {
            this.filterByProductCode = filterByProductCode;
            return this;
        }

        public TotalSalesQuery.TotalSalesQueryBuilder filterBySalesDate(LocalDateRange filterBySalesDate) {
            this.filterBySalesDate = filterBySalesDate;
            return this;
        }

        public TotalSalesQuery build() {
            return new TotalSalesQuery(filterByProductCode, filterBySalesDate);
        }

        public String toString() {
            return "TotalSalesQuery.TotalSalesQueryBuilder(filterByProductCode=" + this.filterByProductCode + ", filterBySalesDate=" + this.filterBySalesDate + ")";
        }
    }
}
