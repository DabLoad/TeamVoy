package com.example.teamvoy.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/goodies")
public class GoodsController {
    @RequestMapping("/getList")
    public ResponseEntity<?> getGoodsList() {
        return null;
    }

    @RequestMapping("/get")
    public ResponseEntity<?> getGoods(@RequestParam long id) {
        return null;
    }
}