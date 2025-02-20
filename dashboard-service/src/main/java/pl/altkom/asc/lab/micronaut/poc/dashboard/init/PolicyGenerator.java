package pl.altkom.asc.lab.micronaut.poc.dashboard.init;

import pl.altkom.asc.lab.micronaut.poc.dashboard.domain.LocalDateRange;
import pl.altkom.asc.lab.micronaut.poc.dashboard.domain.PolicyDocument;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PolicyGenerator {
    private final LocalDateRange generationPeriod;
    private final List<String> agents;
    private final List<String> products;
    private List<String> policyHolders = Arrays.asList(
            "Mike Smith", "Tim Jones", "Berry Cline", "Marion Jones", "Larry Bird",
            "Tara Zane", "Leon Moulder", "Dana Savic", "Evelyn Crowford", "Andrews Eldritch"
    );

    public PolicyGenerator(LocalDateRange generationPeriod, List<String> agents, List<String> products) {
        this.generationPeriod = generationPeriod;
        this.agents = agents;
        this.products = products;
    }

    public static PolicyGeneratorBuilder builder() {
        return new PolicyGeneratorBuilder();
    }

    public List<PolicyDocument> generate() {
        List<PolicyDocument> policies = new ArrayList<>();

        LocalDate salesDate = generationPeriod.getFrom();

        while (!salesDate.isAfter(generationPeriod.getTo())) {
            final LocalDate theDate = salesDate;
            agents.forEach(agent ->
                products.forEach(product -> policies.addAll(generatePolicies(theDate, agent, product)))
            );
            salesDate = salesDate.plusDays(7);
        }

        return policies;
    }

    private List<PolicyDocument> generatePolicies(LocalDate salesDate, String agent, String product) {
        List<PolicyDocument> policiesForDay = new ArrayList<>();
        int numberOfPolicies = randomIntFromRange(1,2);
        for (int i=0; i<numberOfPolicies; i++) {
            PolicyDocument policy = new PolicyDocument(
                    policyNumber(i, salesDate, agent, product),
                    salesDate,
                    salesDate.plusYears(1).minusDays(1),
                    randomHolder(),
                    product,
                    randomPremium(product),
                    agent
            );
            policiesForDay.add(policy);
        }
        return policiesForDay;
    }

    private BigDecimal randomPremium(String product) {
        return new BigDecimal("1000.00");
    }

    private String randomHolder() {
        return policyHolders.get(randomIntFromRange(0,policyHolders.size()-1));
    }

    private String policyNumber(int i,LocalDate salesDate, String agent, String product) {
        return salesDate.getYear() + "/" + salesDate.getMonthValue() + "/" + salesDate.getDayOfMonth()
                + "/" + products.indexOf(product) + "/" + agents.indexOf(agent) + "/" + i;
    }

    private int randomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }

    public static class PolicyGeneratorBuilder {
        private LocalDateRange generationPeriod;
        private List<String> agents;
        private List<String> products;

        PolicyGeneratorBuilder() {
        }

        public PolicyGeneratorBuilder generationPeriod(LocalDateRange generationPeriod) {
            this.generationPeriod = generationPeriod;
            return this;
        }

        public PolicyGeneratorBuilder agents(List<String> agents) {
            this.agents = agents;
            return this;
        }

        public PolicyGeneratorBuilder products(List<String> products) {
            this.products = products;
            return this;
        }

        public PolicyGenerator build() {
            return new PolicyGenerator(generationPeriod, agents, products);
        }

        public String toString() {
            return "PolicyGenerator.PolicyGeneratorBuilder(generationPeriod=" + this.generationPeriod + ", agents=" + this.agents + ", products=" + this.products + ")";
        }
    }
}
