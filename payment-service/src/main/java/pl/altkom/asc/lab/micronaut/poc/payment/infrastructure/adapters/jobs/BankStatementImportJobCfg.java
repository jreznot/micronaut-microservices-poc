package pl.altkom.asc.lab.micronaut.poc.payment.infrastructure.adapters.jobs;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("payments")
class BankStatementImportJobCfg {
    private String importDir = "./bank_imports";

    public String getImportDir() {
        return this.importDir;
    }

    public void setImportDir(String importDir) {
        this.importDir = importDir;
    }
}
