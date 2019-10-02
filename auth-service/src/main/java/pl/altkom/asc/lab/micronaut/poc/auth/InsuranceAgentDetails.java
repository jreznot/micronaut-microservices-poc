package pl.altkom.asc.lab.micronaut.poc.auth;

import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;

class InsuranceAgentDetails extends UserDetails {

    private String avatarUrl;

    InsuranceAgentDetails(String username, String avatarUrl, Collection<String> roles) {
        super(username, roles);
        this.avatarUrl = avatarUrl;
   }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
