package pl.altkom.asc.lab.micronaut.poc.payment.infrastructure.adapters.jobs;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.InPaymentRegistrationService;

import java.time.LocalDate;

@Prototype
public class BankStatementImportJob {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BankStatementImportJob.class);
    private final BankStatementImportJobCfg jobCfg;
    private final InPaymentRegistrationService inPaymentRegistrationService;

    public BankStatementImportJob(BankStatementImportJobCfg jobCfg, InPaymentRegistrationService inPaymentRegistrationService) {
        this.jobCfg = jobCfg;
        this.inPaymentRegistrationService = inPaymentRegistrationService;
    }

    @Scheduled(fixedRate = "8h")
    public void importBankStatement() {
       log.info("Starting bank statement import job");

       inPaymentRegistrationService.registerInPayments(jobCfg.getImportDir(), LocalDate.now());
    }
}
