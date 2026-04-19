package kg.spring.core.model.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    private final String firstName;
    private final String lastName;
    private final String profession;
    private final Integer age;

    @JsonCreator
    public UserRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("profession") String profession,
            @JsonProperty("age") Integer age
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfession() {
        return profession;
    }

    public Integer getAge() {
        return age;
    }
}