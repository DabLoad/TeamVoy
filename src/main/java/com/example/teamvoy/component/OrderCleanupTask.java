package com.example.teamvoy.component;

import com.example.teamvoy.entity.Order;
import com.example.teamvoy.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderCleanupTask {
    @Autowired
    private OrdersRepo orderRepository;

    // removing unpaid orders older than 10 minutes
    @Scheduled(fixedRate = 600000) // 10 minutes
    public void cleanupOldOrders() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusMinutes(10);
        List<Order> unpaidOrders = orderRepository.findByisPaidFalseAndOrderTimeBefore(cutoffTime);
        orderRepository.deleteAll(unpaidOrders);
    }
}