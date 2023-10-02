package configs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.PropOperation.getEnvProperty;

public class RequestSpecs {

    RequestSpecification requestSpecification;

    private static final String EMPLOYEE_BASE_URI = getEnvProperty("employeeServiceUrl");
    private static final String GO_REST_BASE_URI = getEnvProperty("goRestServiceUrl");
    private static final String PET_BASE_URI = getEnvProperty("petServiceUrl");

    public static RequestSpecification buildCommonEmployeeRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(EMPLOYEE_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification buildCommonGoRestRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(GO_REST_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification buildCommonPetRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(PET_BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }
}
