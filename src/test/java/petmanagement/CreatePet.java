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
import java.util.ArrayList;
import java.util.List;

public class CreatePet extends BaseRequest{

    @Test
    public void createNewPet() {
        RequestSpecification requestSpecification = RequestSpecs.buildCommonPetRequestSpec()
                .basePath(RequestPath.PET);
        PetDto petDto = PetDto.defaultPetBuilder().build();

        Response response = sendPostRequest(requestSpecification, petDto);

        ResponseValidationStep.assertResponseCode(response, HttpStatus.SC_OK);

        PetResponseDto petResponseDto = response.as(PetResponseDto.class);

        Assertions.assertThat(petResponseDto.getName()).isEqualTo(petDto.getName());
        Assertions.assertThat(petResponseDto.getStatus()).isEqualTo(petDto.getStatus());

        List<Integer> list = new ArrayList<>();
        for(int i =0;i<petResponseDto.getTags().size();i++) {
            list.add(petResponseDto.getTags().get(i).getId());
        }
        
        Assertions.assertThat(list).contains(petDto.getTags().get(0).getId());
        Assertions.assertThat(petResponseDto.getCategory().getName()).isEqualTo(petDto.getCategory().getName());
        Assertions.assertThat(petResponseDto.getPhotoUrls()).containsExactlyInAnyOrderElementsOf(petDto.getPhotoUrls());
    }
}
