package pl.altkom.asc.lab.micronaut.poc.pricing.intrastructure.adapters.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.validation.Validated;
import pl.altkom.asc.lab.micronaut.poc.pricing.commands.CalculatePriceHandler;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.PricingOperations;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceCommand;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceResult;

@Controller("/pricing")
@Validated
public class PricingController implements PricingOperations {

    private final CalculatePriceHandler calculatePriceHandler;

    public PricingController(CalculatePriceHandler calculatePriceHandler) {
        this.calculatePriceHandler = calculatePriceHandler;
    }

    @Override
    public CalculatePriceResult calculatePrice(CalculatePriceCommand cmd) {
        return calculatePriceHandler.handle(cmd);
    }
}
