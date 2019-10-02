package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import javax.persistence.Embeddable;

@Embeddable
class PolicyRef {
    private String policyNumber;

    public PolicyRef(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    protected PolicyRef() {
    }

    static PolicyRef of(Policy policy) {
        return new PolicyRef(policy.getNumber());
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PolicyRef)) return false;
        final PolicyRef other = (PolicyRef) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$policyNumber = this.getPolicyNumber();
        final Object other$policyNumber = other.getPolicyNumber();
        if (this$policyNumber == null ? other$policyNumber != null : !this$policyNumber.equals(other$policyNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PolicyRef;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $policyNumber = this.getPolicyNumber();
        result = result * PRIME + ($policyNumber == null ? 43 : $policyNumber.hashCode());
        return result;
    }
}
