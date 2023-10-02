package usermanagement;

import common.BaseRequest;
import configs.RequestPaths;
import configs.RequestSpecs;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.models.UserDto;
import pojo.response.usermanagement.UserResponse;

import java.util.ArrayList;

public class PostUser extends BaseRequest {


    @Test
    public void createUser () {
        RequestSpecification requestSpecification = RequestSpecs.buildCommonPetRequestSpec()
                .basePath(RequestPaths.USER_CREATE_WITH_ARRAY);

        ArrayList <Object> list = new ArrayList<>();
        UserDto userDto = UserDto.defaultUserBuilder().build();
        list.add(userDto);

        Response response = sendPostRequest(requestSpecification, list);

        UserResponse userResponse = response.as(UserResponse.class);
        Assertions.assertThat(userResponse.getCode()).isEqualTo(200);
    }
}
