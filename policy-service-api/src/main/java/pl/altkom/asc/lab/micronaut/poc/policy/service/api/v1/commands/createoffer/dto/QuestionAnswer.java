package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createoffer.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY, 
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChoiceQuestionAnswer.class, name = "choice"),
    @JsonSubTypes.Type(value = TextQuestionAnswer.class, name = "text"),
    @JsonSubTypes.Type(value = NumericQuestionAnswer.class, name = "numeric"),
})
public abstract class QuestionAnswer<T> {
    private String questionCode;
    private T answer;

    public QuestionAnswer(String questionCode, T answer) {
        this.questionCode = questionCode;
        this.answer = answer;
    }

    public QuestionAnswer() {
    }

    public String getQuestionCode() {
        return this.questionCode;
    }

    public T getAnswer() {
        return this.answer;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }
}
