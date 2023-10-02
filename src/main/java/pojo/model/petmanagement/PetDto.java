package pojo.model.petmanagement;

import lombok.Builder;
import lombok.Data;
import utils.RandomUtils;

import java.util.List;

import static utils.RandomUtils.getRandomIntValue;

@Builder
@Data
public class PetDto {

    private int id;
    private CategoryDto category;
    private String name;
    private List<String> photoUrls;
    private String status;
    private List<TagDto> tags;

    public static PetDtoBuilder defaultPetBuilder() {
        return new PetDtoBuilder()
                .id(getRandomIntValue(1))
                .category(CategoryDto.defaultCategoryBuilder().build())
                .name("doggie")
                .photoUrls(List.of("www.abc.com", "www.ced.com"))
                .status("available")
                .tags(List.of(TagDto.defaultTagBuilder().build()));

    }

}
