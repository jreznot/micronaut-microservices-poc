package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Policy {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private Set<PolicyVersion> versions;

    public Policy(String number) {
        this.number = number;
        this.versions = new HashSet<>();
    }

    public Policy(Long id, String number, Set<PolicyVersion> versions) {
        this.id = id;
        this.number = number;
        this.versions = versions;
    }

    protected Policy() {
    }

    public LocalDate getLastVersionValidityFrom() {
        return versions().lastVersion().getVersionValidityPeriod().getFrom();
    }

    public LocalDate getLastVersionValidityTo() {
        return versions().lastVersion().getVersionValidityPeriod().getTo();
    }

    public PolicyVersionCollection versions() {
        return new PolicyVersionCollection(this, versions);
    }

    public void terminate() {
        //TODO implement terminate business logic (specification pattern example)
    }

    public Long getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public Set<PolicyVersion> getVersions() {
        return this.versions;
    }
}
