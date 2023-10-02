package employeemanagement;

import common.BaseRequest;
import common.ResponseValidationStep;
import configs.RequestPath;
import configs.RequestSpecs;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.model.employeemanagement.EmployeeDto;
import pojo.response.employeemanegement.EmployeeResponseDto;
import staticdata.Messages;

public class PostEmployee extends BaseRequest {

    @Test
    public void shouldCreateNewEmp() {
        RequestSpecification requestSpecification = RequestSpecs.buildCommonEmployeeRequestSpec()
                .basePath(RequestPath.CREATE);

        EmployeeDto employeeDto = EmployeeDto.getDefaultEmployeeBuilder().build();

        Response response = sendPostRequest(requestSpecification, employeeDto);

        ResponseValidationStep.assertResponseCode(response, HttpStatus.SC_OK);

        EmployeeResponseDto employeeResponseDto = response.as(EmployeeResponseDto.class);

        Assertions.assertThat(employeeResponseDto.getMessage()).isEqualTo(Messages.SUCCESSFULLY_RECORD_HAS_BEEN_ADDED);
        Assertions.assertThat(employeeResponseDto.getData().getName()).isEqualTo(employeeDto.getName());
        Assertions.assertThat(employeeResponseDto.getData().getAge()).isEqualTo(employeeDto.getAge());
        Assertions.assertThat(employeeResponseDto.getData().getSalary()).isEqualTo(employeeDto.getSalary());
    }
}
