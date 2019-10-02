package pl.altkom.asc.lab.micronaut.poc.policy.domain;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Person {
    private String firstName;
    private String lastName;
    private String pesel;

    public Person(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    protected Person() {
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPesel() {
        return this.pesel;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private String pesel;

        PersonBuilder() {
        }

        public Person.PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Person.PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person.PersonBuilder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, pesel);
        }

        public String toString() {
            return "Person.PersonBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName
                    + ", pesel=" + this.pesel + ")";
        }
    }
}
