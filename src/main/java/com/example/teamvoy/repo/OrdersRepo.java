package com.example.teamvoy.repo;

import com.example.teamvoy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
}
