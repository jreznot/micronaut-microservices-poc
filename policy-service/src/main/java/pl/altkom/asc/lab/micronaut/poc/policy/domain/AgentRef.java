package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import io.micronaut.core.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AgentRef {
    @Column(name = "agent_login")
    private String login;

    public AgentRef(String login) {
        this.login = login;
    }

    public AgentRef() {
    }

    public static AgentRef of(String login) {
        if (StringUtils.isNotEmpty(login))
            return new AgentRef(login);

        return null;
    }

    public String getLogin() {
        return this.login;
    }
}
