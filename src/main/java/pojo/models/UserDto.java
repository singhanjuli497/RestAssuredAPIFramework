package pojo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomIntValue;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDto {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    public static UserDtoBuilder defaultUserBuilder() {
        return new UserDtoBuilder()
                .id(getRandomIntValue(2))
                .username(getRandomStringValue(5))
                .firstName(getRandomStringValue(5))
                .lastName(getRandomStringValue(5))
                .email(getRandomStringValue(5)+"@gmail.com")
                .password("P" + getRandomAlphaNumericValue(5))
                .phone("9"+getRandomLongValue(9))
                .userStatus(getRandomIntValue(2));
    }
}
