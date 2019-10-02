package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Entity
public class Offer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "policy_from")
    private LocalDate policyFrom;

    @Column(name = "policy_to")
    private LocalDate policyTo;

    @ElementCollection
    @CollectionTable(name = "offer_answers", joinColumns = @JoinColumn(name = "offer_id"))
    @MapKeyColumn(name = "question_code")
    @Column(name = "answer")
    private Map<String, String> answers;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ElementCollection
    @CollectionTable(name = "offer_cover", joinColumns = @JoinColumn(name = "offer_id"))
    @MapKeyColumn(name = "cover_code")
    @Column(name = "price")
    private Map<String, BigDecimal> coversPrices;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OfferStatus status;
    
    @Column(name = "creation_date")
    private LocalDate creationDate;

    public Offer(Long id, String number, String productCode, LocalDate policyFrom, LocalDate policyTo, Map<String, String> answers, BigDecimal totalPrice, Map<String, BigDecimal> coversPrices, OfferStatus status, LocalDate creationDate) {
        this.id = id;
        this.number = number;
        this.productCode = productCode;
        this.policyFrom = policyFrom;
        this.policyTo = policyTo;
        this.answers = answers;
        this.totalPrice = totalPrice;
        this.coversPrices = coversPrices;
        this.status = status;
        this.creationDate = creationDate;
    }

    protected Offer() {
    }

    /*
    Offers are valid only for 30 days
    */
    public boolean isExpired(LocalDate theDate) {
        return creationDate.plusDays(30).isBefore(theDate);
    }

    public Long getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public LocalDate getPolicyFrom() {
        return this.policyFrom;
    }

    public LocalDate getPolicyTo() {
        return this.policyTo;
    }

    public Map<String, String> getAnswers() {
        return this.answers;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, BigDecimal> getCoversPrices() {
        return this.coversPrices;
    }

    public OfferStatus getStatus() {
        return this.status;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }
}
