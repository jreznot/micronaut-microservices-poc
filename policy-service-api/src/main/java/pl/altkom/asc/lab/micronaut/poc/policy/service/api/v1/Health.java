package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1;

public class Health {
    private String ver;
    private String status;

    public Health(String ver, String status) {
        this.ver = ver;
        this.status = status;
    }

    public Health() {
    }

    public String getVer() {
        return this.ver;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return "Health(ver=" + this.getVer() + ", status=" + this.getStatus() + ")";
    }
}
