package ge.btu.nika_goduadze.controller;

import ge.btu.nika_goduadze.dto.movie.DeleteMovieOutput;
import ge.btu.nika_goduadze.dto.movie.*;
import ge.btu.nika_goduadze.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("getMovies")
    public GetMoviesOutput getMovies() {
        return movieService.getMovies();
    }

    @RequestMapping( method = RequestMethod.POST, value = "addMovie", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE )
    public AddMovieOutput addMovie(@RequestBody AddMovieInput addMovieInput, @RequestPart(value = "file", required = true) MultipartFile file) throws IOException {
        return movieService.addMovie(addMovieInput, file);
    }

    @PostMapping("getMovie")
    public GetMovieDetailOutput getMovieDetail(@RequestBody GetMovieDetailInput getMovieDetailInput) {
        return movieService.getMovieDetail(getMovieDetailInput);
    }

    @PostMapping("deleteMovie")
    public DeleteMovieOutput deleteMovie(@RequestBody DeleteMovieInput deletePostInput) {
        return movieService.deleteMovie(deletePostInput);
    }
}
