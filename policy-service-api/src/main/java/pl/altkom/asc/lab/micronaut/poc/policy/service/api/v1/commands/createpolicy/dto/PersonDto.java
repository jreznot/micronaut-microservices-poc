package pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.commands.createpolicy.dto;

public class PersonDto {
    private String firstName;
    private String lastName;
    private String taxId;

    public PersonDto(String firstName, String lastName, String taxId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxId = taxId;
    }

    public PersonDto() {
    }

    public static PersonDtoBuilder builder() {
        return new PersonDtoBuilder();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTaxId() {
        return this.taxId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public static class PersonDtoBuilder {
        private String firstName;
        private String lastName;
        private String taxId;

        PersonDtoBuilder() {
        }

        public PersonDto.PersonDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonDto.PersonDtoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonDto.PersonDtoBuilder taxId(String taxId) {
            this.taxId = taxId;
            return this;
        }

        public PersonDto build() {
            return new PersonDto(firstName, lastName, taxId);
        }

        public String toString() {
            return "PersonDto.PersonDtoBuilder(firstName=" + this.firstName + ", lastName="
                    + this.lastName + ", taxId=" + this.taxId + ")";
        }
    }
}
