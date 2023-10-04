package com.example.teamvoy.service;

import com.example.teamvoy.dto.TinyGoods;
import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.entity.Order;
import com.example.teamvoy.repo.GoodsRepo;
import com.example.teamvoy.repo.OrdersRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrdersRepo ordersRepo;
    private final GoodsRepo goodsRepo;

    @Autowired
    public OrderService(GoodsRepo goodsRepo, OrdersRepo ordersRepo) {
        this.goodsRepo = goodsRepo;
        this.ordersRepo = ordersRepo;
    }
    public Order createOrder(TinyGoods[] goodsIdMap) {
        Order order = new Order();
        List<Goods> goodsList = new ArrayList<>();
        for (TinyGoods tinyGoods : goodsIdMap) {
            Goods goods = goodsRepo.findById(tinyGoods.getId()).get();
            goodsList.add(goods);
            goods.setQuantity(tinyGoods.getQuantity());
            if (tinyGoods.getQuantity() > goods.getQuantity()) return null;
        }
        order.setGoodsList(goodsList);
        ordersRepo.save(order);
        return order;
    }

    public Order getOrder(Long id) {
        if (ordersRepo.findById(id).isPresent()) return ordersRepo.findById(id).get();
        return null;
    }

    public List<Order> getOrdersList() {
        return ordersRepo.findAll();
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

    @Scheduled(fixedRate = 60000) // 1 minute
    public void cleanupOldOrders() {
        LocalDateTime tenMinutesAgo = LocalDateTime.now().minusMinutes(10);

        // Логирование для отладки
        System.out.println("Cleanup started at: " + LocalDateTime.now());
        System.out.println("Looking for old unpaid orders...");

        List<Order> oldUnpaidOrders = ordersRepo.findOldUnpaidOrders(tenMinutesAgo);

        // Логирование для отладки
        System.out.println("Found " + oldUnpaidOrders.size() + " old unpaid orders.");

        ordersRepo.deleteAll(oldUnpaidOrders);

        // Логирование для отладки
        System.out.println("Old unpaid orders removed at: " + LocalDateTime.now());
    }

}
