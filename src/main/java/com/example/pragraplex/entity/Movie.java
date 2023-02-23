package com.example.pragraplex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Movie_ID")
    private Integer id;
    private String movieName;
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Order> orders;
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieReview> reviews;

}
