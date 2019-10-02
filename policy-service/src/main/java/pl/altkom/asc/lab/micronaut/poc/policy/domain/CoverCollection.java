package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import java.math.BigDecimal;
import java.util.Set;

public class CoverCollection {
    private final PolicyVersion policyVersion;
    private final Set<Cover> covers;

    public CoverCollection(PolicyVersion policyVersion, Set<Cover> covers) {
        this.policyVersion = policyVersion;
        this.covers = covers;
    }

    Cover add(String code, BigDecimal price) {
        Cover cover = new Cover(policyVersion, code, price);
        covers.add(cover);
        return cover;
    }
}
