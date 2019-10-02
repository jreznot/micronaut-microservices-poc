package pl.altkom.asc.lab.micronaut.poc.pricing.service.api.v1.commands.calculateprice.dto;

public class QuestionAnswer<T> {
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
