package com.example.pragraplex.rest;

import com.example.pragraplex.entity.MovieReview;
import com.example.pragraplex.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService service;
    @PostMapping("/review")
    public MovieReview createReview(@RequestBody MovieReview review){
        return service.createReview(review);
    }
    @GetMapping("/review")
    public List<MovieReview> getAllReviews(){
        return service.getAllReviews();
    }
    @GetMapping("/review/{id}")
    public List<MovieReview> findMovieReviewByMovie_Id(@PathVariable Integer id){
        return service.findMovieReviewByMovie_Id(id);
    }
    @PutMapping("/updateReview")
    public MovieReview updateReview(@RequestBody MovieReview review){
        return service.updateReview(review);
    }
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReviewById(@PathVariable Integer id){
        service.deleteReviewById(id);
    }


}
