package ge.btu.nika_goduadze.dto.category;

import ge.btu.nika_goduadze.models.Category;
import lombok.Data;

import java.util.List;

@Data
public class GetCategoriesOutput {
    private List<CategoryDTO> categories;
}
