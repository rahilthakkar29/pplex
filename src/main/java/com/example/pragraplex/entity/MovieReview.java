package com.example.pragraplex.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MovieReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REVIEW_ID")
    private Integer id;
    private String review;
    private int noOfStars;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="MovieId",referencedColumnName = "Movie_ID")
    private Movie movie;
}
