package pojo.response.petmanagement;

import lombok.Data;
import pojo.model.petmanagement.CategoryDto;
import pojo.model.petmanagement.TagDto;
import java.util.List;


@Data
public class PetResponseDto {

    private long id;
    private CategoryResponseDto category;
    private String name;
    private List<String> photoUrls;
    private String status;
    private List<TagResponseDto> tags;
    private int code;
    private String type;
    private String message;

}
