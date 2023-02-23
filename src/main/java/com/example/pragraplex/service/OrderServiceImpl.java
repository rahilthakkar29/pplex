package com.example.pragraplex.service;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.entity.Movie;
import com.example.pragraplex.entity.Order;
import com.example.pragraplex.exceptions.CustomerNotFoundException;
import com.example.pragraplex.exceptions.MovieNotFoundException;
import com.example.pragraplex.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo repo;
    private final CustomerService customerService;
    private final MovieService movieService;

    public Order createOrder(int custId,Order order){
        Optional<Customer> customerById = customerService.getCustomerById(custId);
        Optional<Movie> movieById = movieService.getMovieById(order.getMovie().getId());
        log.debug("Customer id {} provided to create order",custId);
        Movie movie = movieById.orElseThrow(()-> new MovieNotFoundException(String .format("Movie with Id: %d not found",order.getMovie().getId())));
        Customer customer=customerById.orElseThrow(()->new CustomerNotFoundException(String.format("Customer with id %d not found",custId)));

        order.setMovie(movieById.get());
        order.setCustomer(customerById.get());
        return repo.save(order);
        }



    public List<Order> findAll(){

        return repo.findAll();
    }

    public Optional<Order> findOneById(Integer id){

        return repo.findById(id);
    }

    public void deleteAnOrder(Order order){
        repo.delete(order);
    }

    public void deleteOrderByUUID(Integer id){
        repo.deleteById(id);
    }
    public Order updateOrder(Order order){
        return repo.save(order);
    }





}
