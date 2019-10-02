package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PolicyVersionRef {

    private String policyNumber;
    private Long versionNumber;

    public PolicyVersionRef(String policyNumber, Long versionNumber) {
        this.policyNumber = policyNumber;
        this.versionNumber = versionNumber;
    }

    protected PolicyVersionRef() {
    }

    static PolicyVersionRef of(PolicyVersion policyVersion) {
        return new PolicyVersionRef(policyVersion.getPolicy().getNumber(), policyVersion.getVersionNumber());
    }

    public PolicyRef policyRef() {
        return new PolicyRef(policyNumber);
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public Long getVersionNumber() {
        return this.versionNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PolicyVersionRef)) return false;
        final PolicyVersionRef other = (PolicyVersionRef) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$policyNumber = this.getPolicyNumber();
        final Object other$policyNumber = other.getPolicyNumber();
        if (this$policyNumber == null ? other$policyNumber != null : !this$policyNumber.equals(other$policyNumber))
            return false;
        final Object this$versionNumber = this.getVersionNumber();
        final Object other$versionNumber = other.getVersionNumber();
        if (this$versionNumber == null ? other$versionNumber != null : !this$versionNumber.equals(other$versionNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PolicyVersionRef;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $policyNumber = this.getPolicyNumber();
        result = result * PRIME + ($policyNumber == null ? 43 : $policyNumber.hashCode());
        final Object $versionNumber = this.getVersionNumber();
        result = result * PRIME + ($versionNumber == null ? 43 : $versionNumber.hashCode());
        return result;
    }
}
