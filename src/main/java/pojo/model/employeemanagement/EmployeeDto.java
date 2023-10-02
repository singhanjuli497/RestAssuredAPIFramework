package pojo.model.employeemanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import static utils.RandomUtils.getRandomIntValue;
import static utils.RandomUtils.getRandomStringValue;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmployeeDto {

    private String name;
    private int age;
    private int salary;

    public static EmployeeDtoBuilder getDefaultEmployeeBuilder() {
        return new EmployeeDtoBuilder()
                .age(getRandomIntValue(2))
                .name(getRandomStringValue(5))
                .salary(getRandomIntValue(5));
    }
}
