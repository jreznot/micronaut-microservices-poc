package pl.altkom.asc.lab.micronaut.poc.policy.commands;

import io.micronaut.spring.tx.annotation.Transactional;
import pl.altkom.asc.lab.micronaut.poc.command.bus.CommandHandler;
import pl.altkom.asc.lab.micronaut.poc.policy.domain.Offer;
import pl.altkom.asc.lab.micronaut.poc.policy.domain.OfferFactory;
import pl.altkom.asc.lab.micronaut.poc.policy.domain.OfferRepository;
import pl.altkom.asc.lab.micronaut.poc.policy.infrastructure.adapters.restclient.PricingClient;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.CreateOfferCommand;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.CreateOfferResult;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceCommand;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.CalculatePriceResult;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.ChoiceQuestionAnswer;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.NumericQuestionAnswer;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.QuestionAnswer;
import pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto.TextQuestionAnswer;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CreateOfferHandler implements CommandHandler<CreateOfferResult, CreateOfferCommand> {

    private final OfferRepository offerRepository;
    private final PricingClient pricingOperations;

    public CreateOfferHandler(OfferRepository offerRepository, PricingClient pricingOperations) {
        this.offerRepository = offerRepository;
        this.pricingOperations = pricingOperations;
    }

    @Transactional
    @Override
    public CreateOfferResult handle(CreateOfferCommand cmd) {
        //calculate price
        CalculatePriceCommand calcPriceCmd = constructPriceCmd(cmd);
        CalculatePriceResult price = pricingOperations.calculatePrice(calcPriceCmd);

        //create & save offer
        Offer offer = OfferFactory.offerFromPrice(calcPriceCmd, price);
        offerRepository.save(offer);

        //return result
        return constructResult(offer);
    }

    private CalculatePriceCommand constructPriceCmd(CreateOfferCommand cmd) {
        return new CalculatePriceCommand(
                cmd.getProductCode(),
                cmd.getPolicyFrom(),
                cmd.getPolicyTo(),
                cmd.getSelectedCovers(),
                constructAnswers(cmd.getAnswers()));
    }

    private CreateOfferResult constructResult(Offer offer) {
        return new CreateOfferResult(
                offer.getNumber(),
                offer.getTotalPrice(),
                offer.getCoversPrices());
    }

    private List<QuestionAnswer> constructAnswers(List<pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.QuestionAnswer> answers) {
        List<QuestionAnswer> result = new ArrayList<>();
        for (pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.QuestionAnswer answer : answers) {
            if (answer instanceof pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.TextQuestionAnswer) {
                result.add(new TextQuestionAnswer(answer.getQuestionCode(), (String) answer.getAnswer()));
            } else if (answer instanceof pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.ChoiceQuestionAnswer) {
                result.add(new ChoiceQuestionAnswer(answer.getQuestionCode(), (String) answer.getAnswer()));
            } else if (answer instanceof pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto.NumericQuestionAnswer) {
                result.add(new NumericQuestionAnswer(answer.getQuestionCode(), (BigDecimal) answer.getAnswer()));
            }
        }
        return result;
    }
}
