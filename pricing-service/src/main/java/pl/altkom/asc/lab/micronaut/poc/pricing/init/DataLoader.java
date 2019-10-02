package pl.altkom.asc.lab.micronaut.poc.pricing.init;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import io.micronaut.spring.tx.annotation.Transactional;
import pl.altkom.asc.lab.micronaut.poc.pricing.domain.Tariffs;

import javax.inject.Singleton;

@Singleton
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    private final Tariffs tariffsDb;

    public DataLoader(Tariffs tariffsDb) {
        this.tariffsDb = tariffsDb;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        if (!tariffsDb.findByCode("HSI").isPresent()) {
            tariffsDb.save(DemoTariffsFactory.house());
        }
        
        if (!tariffsDb.findByCode("TRI").isPresent()) {
            tariffsDb.save(DemoTariffsFactory.travel());
        }

        if (!tariffsDb.findByCode("FAI").isPresent()) {
            tariffsDb.save(DemoTariffsFactory.farm());
        }

        if (!tariffsDb.findByCode("CAR").isPresent()) {
            tariffsDb.save(DemoTariffsFactory.car());
        }
    }
}
