package com.example.teamvoy.service;

import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.entity.Order;
import com.example.teamvoy.repo.OrdersRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrdersRepo ordersRepo;

    public Order createOrder(List<Goods> goodsList) {
        Order order = new Order();
        order.setGoodsList(goodsList);
        ordersRepo.save(order);
        return order;
    }

    public Order getOrder(Long id) {
        if (ordersRepo.findById(id).isPresent()) return ordersRepo.findById(id).get();
        return null;
    }

    public String payOrder(Long id) {
        if (ordersRepo.findById(id).isPresent()) {
            Order order = ordersRepo.findById(id).get();
            order.setPaid(true);
            ordersRepo.save(order);
            return "Order paid";
        }
        return null;
    }
}
