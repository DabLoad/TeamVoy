package com.example.teamvoy.rest;

import com.example.teamvoy.dto.TinyGoodsDto;
import com.example.teamvoy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PutMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody TinyGoodsDto[] goodsIdMap) {
        return ResponseEntity.ok().body(orderService.createOrder(goodsIdMap));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOrder(@RequestParam Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @GetMapping("/getList")
    public ResponseEntity<?> getOrdersList() {
        return ResponseEntity.ok().body(orderService.getOrdersList());
    }

    @PutMapping("/pay")
    public ResponseEntity<?> payOrder(@RequestParam Long id) {
        return ResponseEntity.ok().body(orderService.payOrder(id));
    }
}
