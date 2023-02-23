package com.example.pragraplex.service;


import com.example.pragraplex.entity.MovieReview;

import java.util.List;

public interface ReviewService {
    MovieReview createReview (MovieReview review);
    List<MovieReview>getAllReviews();
    List<MovieReview> findMovieReviewByMovie_Id(Integer id);
    MovieReview updateReview(MovieReview review);
    void deleteReviewById(Integer id);
}
