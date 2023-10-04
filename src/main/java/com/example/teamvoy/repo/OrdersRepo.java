package com.example.teamvoy.repo;

import com.example.teamvoy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.orderTime <= :tenMinutesAgo AND o.isPaid = false")
    List<Order> findOldUnpaidOrders(LocalDateTime tenMinutesAgo);
}
