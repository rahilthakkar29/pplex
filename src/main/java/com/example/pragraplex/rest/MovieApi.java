package com.example.pragraplex.rest;

import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieApi {
    private final MovieService service;
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return service.createMovie(movie);
    }
    @PostMapping("/movie/saveAll")
    public List<Movie>createMoviesForAll(@RequestBody List<Movie> movies){
        return service.createMovieForAll(movies);
    }
    @GetMapping("/movie")
    public List<Movie>getAllMovies(){
        //System.out.println("entered here");
        return service.getAllMovies();
    }
    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovieById(@PathVariable int id){
        return service.getMovieById(id);
    }
}
