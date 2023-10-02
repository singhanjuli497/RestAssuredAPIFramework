package pojo.response.employeemanegement;

import lombok.Data;
import pojo.response.employeemanegement.DataResponseDto;

@Data
public class EmployeeResponseDto {

    private String status;
    private String message;
    private DataResponseDto data;
}

