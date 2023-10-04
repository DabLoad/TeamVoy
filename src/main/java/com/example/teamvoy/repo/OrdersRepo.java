package com.example.teamvoy.repo;

import com.example.teamvoy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
    List<Order> findByisPaidFalseAndOrderTimeBefore(LocalDateTime cutoffTime);
}
