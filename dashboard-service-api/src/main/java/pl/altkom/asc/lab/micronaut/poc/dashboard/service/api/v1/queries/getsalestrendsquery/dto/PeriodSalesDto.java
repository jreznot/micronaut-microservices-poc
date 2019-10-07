package pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PeriodSalesDto {
    private LocalDate periodDate;
    private String period;
    private Long policiesCount;
    private BigDecimal premiumAmount;

    public PeriodSalesDto(LocalDate periodDate, String period, Long policiesCount, BigDecimal premiumAmount) {
        this.periodDate = periodDate;
        this.period = period;
        this.policiesCount = policiesCount;
        this.premiumAmount = premiumAmount;
    }

    public PeriodSalesDto() {
    }

    public static pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto.PeriodSalesDtoBuilder builder() {
        return new PeriodSalesDtoBuilder();
    }

    public LocalDate getPeriodDate() {
        return this.periodDate;
    }

    public String getPeriod() {
        return this.period;
    }

    public Long getPoliciesCount() {
        return this.policiesCount;
    }

    public BigDecimal getPremiumAmount() {
        return this.premiumAmount;
    }

    public static class PeriodSalesDtoBuilder {
        private LocalDate periodDate;
        private String period;
        private Long policiesCount;
        private BigDecimal premiumAmount;

        PeriodSalesDtoBuilder() {
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto.PeriodSalesDtoBuilder periodDate(LocalDate periodDate) {
            this.periodDate = periodDate;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto.PeriodSalesDtoBuilder period(String period) {
            this.period = period;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto.PeriodSalesDtoBuilder policiesCount(Long policiesCount) {
            this.policiesCount = policiesCount;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto.PeriodSalesDtoBuilder premiumAmount(BigDecimal premiumAmount) {
            this.premiumAmount = premiumAmount;
            return this;
        }

        public pl.altkom.asc.lab.micronaut.poc.dashboard.service.api.v1.queries.getsalestrendsquery.dto.PeriodSalesDto build() {
            return new PeriodSalesDto(periodDate, period, policiesCount, premiumAmount);
        }

        public String toString() {
            return "PeriodSalesDto.PeriodSalesDtoBuilder(periodDate=" + this.periodDate + ", period=" + this.period + ", policiesCount=" + this.policiesCount + ", premiumAmount=" + this.premiumAmount + ")";
        }
    }
}
