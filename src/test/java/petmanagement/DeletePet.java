package petmanagement;

import common.BaseRequest;
import common.ResponseValidationStep;
import configs.RequestPath;
import configs.RequestSpecs;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.model.petmanagement.PetDto;
import pojo.response.petmanagement.PetResponseDto;

import static staticdata.Messages.PET_NOT_FOUND;

public class DeletePet extends BaseRequest {

    RequestSpecification requestSpecification;
    Response response;

    @Test
    public void shouldDeletePet() {
        requestSpecification = RequestSpecs.buildCommonPetRequestSpec()
                .basePath(RequestPath.PET);

        PetDto petDto = PetDto.defaultPetBuilder().build();

        response = sendPostRequest(requestSpecification, petDto);
        ResponseValidationStep.assertResponseCode(response, HttpStatus.SC_OK);

        String petId = response.jsonPath().getString("id");
        System.out.println("Pet id is : " + response.jsonPath().getString("id"));

        PetResponseDto petResponseDto = response.as(PetResponseDto.class);

        System.out.println("Pet id from POJO : " + petResponseDto.getId());

        requestSpecification = RequestSpecs.buildCommonPetRequestSpec()
                .basePath(RequestPath.PET_ID)
                .pathParam("id", petId);

        response = sendDeleteRequest(requestSpecification);
        ResponseValidationStep.assertResponseCode(response, HttpStatus.SC_OK);

        PetResponseDto petResponseDto1 = response.as(PetResponseDto.class);

        Assertions.assertThat(petResponseDto1.getMessage()).isEqualTo(petId);

        response = sendGetRequest(requestSpecification);
        ResponseValidationStep.assertResponseCode(response, HttpStatus.SC_NOT_FOUND);

        PetResponseDto petResponseDto2 = response.as(PetResponseDto.class);
        Assertions.assertThat(petResponseDto2.getMessage()).isEqualTo(PET_NOT_FOUND);
    }
}
