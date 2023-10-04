package com.example.teamvoy.rest;

import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/getList")
    public ResponseEntity<?> getGoodsList() {
        return ResponseEntity.ok().body(goodsService.getGoodsList());
    }

    @RequestMapping("/get")
    public ResponseEntity<?> getGoods(@RequestParam Long id) {
        return ResponseEntity.ok().body(goodsService.getGoods(id));
    }

    @PutMapping("/create")
    public ResponseEntity<?> createGoods(@RequestParam String name,
                                         @RequestParam Double price,
                                         @RequestParam int quantity) {
        return ResponseEntity.ok().body(goodsService.addGoods(name, price, quantity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteGoods(@RequestParam Long id) {
        goodsService.deleteGoods(id);
        return ResponseEntity.ok().body("Success");
    }

}
