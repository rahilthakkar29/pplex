package com.example.pragraplex.repo;

import com.example.pragraplex.entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<MovieReview,Integer> {
    List<MovieReview> findMovieReviewByMovie_Id(Integer id);
}
