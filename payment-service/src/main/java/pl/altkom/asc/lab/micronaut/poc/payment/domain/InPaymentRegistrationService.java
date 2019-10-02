package pl.altkom.asc.lab.micronaut.poc.payment.domain;

import io.micronaut.spring.tx.annotation.Transactional;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.BankStatementFile.BankStatement;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.List;

@Singleton
public class InPaymentRegistrationService {

    private final PolicyAccountRepository policyAccountRepository;

    public InPaymentRegistrationService(PolicyAccountRepository policyAccountRepository) {
        this.policyAccountRepository = policyAccountRepository;
    }

    @Transactional
    public void registerInPayments(String directory, LocalDate date) {
        BankStatementFile fileToImport = new BankStatementFile(directory, date);

        if (!fileToImport.exists()) {
            return;
        }

        List<BankStatement> bankStatements = fileToImport.read();
        bankStatements.forEach(this::registerInPayment);
        fileToImport.markProcessed();
    }

    private void registerInPayment(BankStatement bankStatement) {
        policyAccountRepository
                .findByPolicyAccountNumber(bankStatement.getAccountNumber())
                .ifPresent(account -> {
                    account.inPayment(bankStatement.getAmount(), bankStatement.getAccountingDate());
                });
    }
}
