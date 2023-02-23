package com.example.pragraplex.service;

import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.entity.MovieReview;
import com.example.pragraplex.exceptions.MovieNotFoundException;
import com.example.pragraplex.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo repo;
    private final MovieService movieService;
    @Override
    public MovieReview createReview(MovieReview review) {
        Optional<Movie>movieById=movieService.getMovieById(review.getMovie().getId());
        Movie movie = movieById.orElseThrow(()-> new MovieNotFoundException(String .format("Movie with Id: %d not found",review.getMovie().getId())));
        review.setMovie(movie);
        return repo.save(review);
    }

    @Override
    public List<MovieReview> getAllReviews() {
        return repo.findAll();
    }

    @Override
    public List<MovieReview> findMovieReviewByMovie_Id(Integer id) {
        return repo.findMovieReviewByMovie_Id(id);
    }


    @Override
    public MovieReview updateReview(MovieReview review) {
        if(review.getNoOfStars()==0)
            review.setReview("No Reviews yet");
        review.setNoOfStars(review.getNoOfStars());
        return review;
    }

    @Override
    public void deleteReviewById(Integer id) {
        repo.deleteById(id);
    }
}
