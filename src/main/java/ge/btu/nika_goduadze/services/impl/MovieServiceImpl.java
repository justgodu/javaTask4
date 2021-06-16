package ge.btu.nika_goduadze.services.impl;


import ge.btu.nika_goduadze.dto.category.CategoryDTO;
import ge.btu.nika_goduadze.dto.movie.*;
import ge.btu.nika_goduadze.models.Category;
import ge.btu.nika_goduadze.models.Movie;
import ge.btu.nika_goduadze.repository.CategoryRepository;
import ge.btu.nika_goduadze.repository.MovieRepository;
import ge.btu.nika_goduadze.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public GetMoviesOutput getMovies() {

        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setTitle(movie.getTitle());
            movieDTO.setCountry(movie.getCountry());

            movieDTOList.add(movieDTO);
        }

        GetMoviesOutput getMovieOutput = new GetMoviesOutput();
        getMovieOutput.setMovies(movieDTOList);
        return getMovieOutput;
    }

    @Override
    public AddMovieOutput addMovie(AddMovieInput addMovieInput, MultipartFile file) throws IOException {
        Movie movie = new Movie();
        movie.setTitle(addMovieInput.getTitle());
        movie.setCountry(addMovieInput.getCountry());
        movie.setData(file.getBytes());
        List<Category> categories = new ArrayList<>();
        for (CategoryDTO categoryDTO : addMovieInput.getCategories()) {
            Category category = categoryRepository.getOne(categoryDTO.getId());
            categories.add(category);
        }
        movie.setCategories(categories);

        movieRepository.save(movie);

        AddMovieOutput addMovieOutput = new AddMovieOutput();
        addMovieOutput.setMsg("პოსტი დაემატა");
        return addMovieOutput;
    }

    @Override
    public GetMovieDetailOutput getMovieDetail(GetMovieDetailInput getMovieDetailInput) {
        Movie movie = movieRepository.getOne(getMovieDetailInput.getMovieId());

        GetMovieDetailOutput getMovieDetailOutput = new GetMovieDetailOutput();
        getMovieDetailOutput.setTitle(movie.getTitle());
        getMovieDetailOutput.setCountry(movie.getCountry());

        return getMovieDetailOutput;
    }

    @Override
    public DeleteMovieOutput deleteMovie(DeleteMovieInput deleteMovieInput) {
        Movie movie = movieRepository.getOne(deleteMovieInput.getMovieId());
        movieRepository.delete(movie);

        DeleteMovieOutput deleteMovieOutput = new DeleteMovieOutput();
        deleteMovieOutput.setMsg("პოსტი წარმატებით წაიშალა");
        return deleteMovieOutput;
    }
}
