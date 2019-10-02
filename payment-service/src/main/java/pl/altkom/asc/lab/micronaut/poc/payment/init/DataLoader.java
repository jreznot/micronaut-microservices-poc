package pl.altkom.asc.lab.micronaut.poc.payment.init;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import io.micronaut.spring.tx.annotation.Transactional;
import org.slf4j.Logger;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.PolicyAccount;
import pl.altkom.asc.lab.micronaut.poc.payment.domain.PolicyAccountRepository;

import javax.inject.Singleton;

@Singleton
public class DataLoader  implements ApplicationEventListener<ServerStartupEvent> {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DataLoader.class);
    private final PolicyAccountRepository policyAccountDb;

    public DataLoader(PolicyAccountRepository policyAccountDb) {
        this.policyAccountDb = policyAccountDb;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        DemoAccountsFactory.demoAccounts().forEach(this::addIfNotExists);
        log.info("Demo data added");
    }
    
    private void addIfNotExists(PolicyAccount account) {
        if (!policyAccountDb.findByPolicyAccountNumber(account.getPolicyAccountNumber()).isPresent()) {
            policyAccountDb.save(account);
        }
    }
}
