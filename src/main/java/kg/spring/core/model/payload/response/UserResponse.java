package kg.spring.core.model.payload.response;

public class UserResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String profession;
    private final Integer age;

    public UserResponse(Long id, String firstName, String lastName,
                        String profession, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.age = age;
    }

    public Long getId() {
        return id;
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
