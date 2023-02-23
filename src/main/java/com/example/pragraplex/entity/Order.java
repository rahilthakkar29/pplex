package com.example.pragraplex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "TABLE_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String movieName;
    private Date orderDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date showDate;
    @JsonProperty("charge_amount")
    private double amount;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName = "CUSTOMER_ID ")
    @JsonIgnore
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="MovieId",referencedColumnName = "Movie_ID")
    private Movie movie;
}
