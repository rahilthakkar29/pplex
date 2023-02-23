package com.example.pragraplex.repo;

import com.example.pragraplex.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
