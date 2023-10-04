package com.example.teamvoy.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @PutMapping("/create")
    public ResponseEntity<?> createOrder() {
        return null;
    }

    @PutMapping("/get")
    public ResponseEntity<?> getOrder() {
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrder() {
        return null;
    }
}
