package com.example.teamvoy.rest;

import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PutMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Goods[] goodsList) {
        return ResponseEntity.ok().body(orderService.createOrder(List.of(goodsList)));
    }

    @PutMapping("/get")
    public ResponseEntity<?> getOrder(@RequestParam Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PutMapping("/pay")
    public ResponseEntity<?> payOrder(@RequestParam Long id) {
        return ResponseEntity.ok().body(orderService.payOrder(id));
    }
}
