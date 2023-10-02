package common;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public abstract class ResponseValidationStep {

    public static void assertResponseCode(Response response, int statusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    public static void assertJsonSchema(Response response, String filePath) {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(filePath));
    }
}
