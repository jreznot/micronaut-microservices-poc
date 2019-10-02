package pl.altkom.asc.lab.micronaut.poc.policy.search.readmodel;

import java.time.LocalDate;

public class PolicyView {
    private String number;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String policyHolder;

    public PolicyView(String number) {
        this.number = number;
    }

    public PolicyView(String number, LocalDate dateFrom, LocalDate dateTo, String policyHolder) {
        this.number = number;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.policyHolder = policyHolder;
    }

    public PolicyView() {
    }

    public static PolicyViewBuilder builder() {
        return new PolicyViewBuilder();
    }

    public String getNumber() {
        return this.number;
    }

    public LocalDate getDateFrom() {
        return this.dateFrom;
    }

    public LocalDate getDateTo() {
        return this.dateTo;
    }

    public String getPolicyHolder() {
        return this.policyHolder;
    }

    public static class PolicyViewBuilder {
        private String number;
        private LocalDate dateFrom;
        private LocalDate dateTo;
        private String policyHolder;

        PolicyViewBuilder() {
        }

        public PolicyView.PolicyViewBuilder number(String number) {
            this.number = number;
            return this;
        }

        public PolicyView.PolicyViewBuilder dateFrom(LocalDate dateFrom) {
            this.dateFrom = dateFrom;
            return this;
        }

        public PolicyView.PolicyViewBuilder dateTo(LocalDate dateTo) {
            this.dateTo = dateTo;
            return this;
        }

        public PolicyView.PolicyViewBuilder policyHolder(String policyHolder) {
            this.policyHolder = policyHolder;
            return this;
        }

        public PolicyView build() {
            return new PolicyView(number, dateFrom, dateTo, policyHolder);
        }

        public String toString() {
            return "PolicyView.PolicyViewBuilder(number=" + this.number + ", dateFrom=" + this.dateFrom
                    + ", dateTo=" + this.dateTo + ", policyHolder=" + this.policyHolder + ")";
        }
    }
}
