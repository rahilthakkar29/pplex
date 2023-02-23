package com.example.pragraplex.service;

import com.example.pragraplex.entity.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    Movie createMovie(Movie movie);
    List<Movie>getAllMovies();
    Optional<Movie>getMovieById(Integer id);
    List<Movie>createMovieForAll(List<Movie> movies);

}
