package pl.altkom.asc.lab.micronaut.poc.auth;

import java.util.List;

class InsuranceAgent {

    private String login;
    private String password;
    private String avatar;
    private List<String> availableProducts;

    InsuranceAgent(String login, String password, String avatar, List<String> availableProducts) {
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.availableProducts = availableProducts;
    }

    protected InsuranceAgent() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<String> getAvailableProducts() {
        return availableProducts;
    }

    boolean passwordMatches(String passwordToTest) {
        return this.password.equals(passwordToTest);
    }
}
