package common;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    protected Response sendGetRequest(RequestSpecification requestSpecification) {
        return given().spec(requestSpecification).log().all().when().get().then().log().all().extract().response();
    }

    protected static Response sendPostRequest(RequestSpecification requestSpecification, Object requestBody ) {
        return given().spec(requestSpecification).body(requestBody).log().all().when().post().then().log().all().extract().response();
    }

    protected Response sendPatchRequest(RequestSpecification requestSpecification, Object requestBody) {
        return given().spec(requestSpecification).body(requestBody).log().all().when().patch().then().log().all().extract().response();
    }

    protected Response sendPutRequest(RequestSpecification requestSpecification, Object requestBody) {
        return given().spec(requestSpecification).body(requestBody).log().all().when().put().then().log().all().extract().response();
    }

    protected Response sendDeleteRequest(RequestSpecification requestSpecification) {
        return given().spec(requestSpecification).log().all().when().delete().then().log().all().extract().response();
    }

}
