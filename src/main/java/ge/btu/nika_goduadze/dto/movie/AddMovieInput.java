package ge.btu.nika_goduadze.dto.movie;

import ge.btu.nika_goduadze.dto.category.CategoryDTO;
import lombok.Data;

import java.util.List;

@Data
public class AddMovieInput {
    private String title;
    private String country;

    private List<CategoryDTO> categories;
}
