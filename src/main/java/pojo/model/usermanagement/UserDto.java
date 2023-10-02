package pojo.model.usermanagement;

import lombok.Builder;
import lombok.Data;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomIntValue;

@Data
@Builder
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
                .email(getRandomStringValue(6)+"@gmail.com")
                .password("P" + getRandomAlphaNumericValue(5))
                .phone(getRandomLongValue(10))
                .userStatus(getRandomIntValue(2));
    }
}
