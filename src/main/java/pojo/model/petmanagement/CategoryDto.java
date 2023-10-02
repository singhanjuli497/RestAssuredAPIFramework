package pojo.model.petmanagement;

import lombok.Builder;
import lombok.Data;

import static utils.RandomUtils.getRandomIntValue;
import static utils.RandomUtils.getRandomStringValue;

@Data
@Builder
public class CategoryDto {
    private int id;
    private String name;

    public static CategoryDtoBuilder defaultCategoryBuilder() {
        return new CategoryDtoBuilder()
                .id(getRandomIntValue(1))
                .name(getRandomStringValue(5));
    }
}
