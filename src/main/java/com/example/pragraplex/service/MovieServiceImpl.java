package com.example.pragraplex.service;

import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.repo.MovieRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo repo;
    @Override
    public Movie createMovie(Movie movie) {
        return repo.save(movie);
    }

    public List<Movie>createMovieForAll(List<Movie> movies){
        return repo.saveAll(movies);
    }

    @Override
    public List<Movie> getAllMovies() {

        return repo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Integer id) {

        return repo.findById(id);
    }
}
