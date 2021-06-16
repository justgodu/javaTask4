package ge.btu.nika_goduadze.services;

import ge.btu.nika_goduadze.dto.movie.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MovieService {
    GetMoviesOutput getMovies();

    AddMovieOutput addMovie(AddMovieInput addStudentInput, MultipartFile file) throws IOException;

    DeleteMovieOutput deleteMovie(DeleteMovieInput deleteStudentInput);

    GetMovieDetailOutput getMovieDetail(GetMovieDetailInput getPostDetailInput);
}
