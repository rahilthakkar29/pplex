package com.example.pragraplex.service;

import com.example.pragraplex.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order createOrder(int custId,Order order);
    List<Order> findAll();
    Optional<Order> findOneById(Integer id);
    void deleteOrderByUUID(Integer id);
    Order updateOrder(Order order);

}
