package pl.altkom.asc.lab.micronaut.poc.payment.infrastructure.adapters.web;

import io.micronaut.configuration.hystrix.annotation.HystrixCommand;
import io.micronaut.http.annotation.Controller;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.PolicyAccountRepository;
import pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1.PolicyAccountBalanceDto;
import pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1.PolicyAccountDto;
import pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1.exceptions.PolicyAccountNotFound;
import pl.altkom.asc.lab.micronaut.poc.payment.service.api.v1.operations.PaymentOperations;

import java.time.LocalDate;
import java.util.Collection;

@Controller("/payment")
public class PaymentController implements PaymentOperations {

    private final PolicyAccountRepository policyAccountRepository;

    public PaymentController(PolicyAccountRepository policyAccountRepository) {
        this.policyAccountRepository = policyAccountRepository;
    }

    @Override
    @HystrixCommand
    public Collection<PolicyAccountDto> accounts() {
        return policyAccountRepository.findAll();
    }

    @Override
    @HystrixCommand
    public PolicyAccountBalanceDto accountBalance(String accountNumber) {
        return policyAccountRepository.findByPolicyAccountNumber(accountNumber)
                .map(account -> new PolicyAccountBalanceDto(
                        account.getPolicyNumber(),
                        account.getPolicyAccountNumber(),
                        account.balanceAt(LocalDate.now()),
                        account.getCreated(),
                        account.getUpdated()))
                .orElseThrow(() -> new PolicyAccountNotFound(accountNumber));
    }
}
