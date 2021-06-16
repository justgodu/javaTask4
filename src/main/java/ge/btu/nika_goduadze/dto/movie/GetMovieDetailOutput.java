package ge.btu.nika_goduadze.dto.movie;

import lombok.Data;

@Data
public class GetMovieDetailOutput {
    private String title;
    private String country;
    private byte[] data;
}
