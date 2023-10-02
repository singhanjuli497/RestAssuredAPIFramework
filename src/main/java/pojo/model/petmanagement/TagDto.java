package pojo.model.petmanagement;

import lombok.Builder;
import lombok.Data;

import static utils.RandomUtils.getRandomIntValue;
import static utils.RandomUtils.getRandomStringValue;

@Data
@Builder
public class TagDto {

    private int id;
    private String name;

    public static TagDtoBuilder defaultTagBuilder() {
        return new TagDtoBuilder()
                .id(getRandomIntValue(1))
                .name(getRandomStringValue(5));
    }
}
