package com.example.teamvoy.service;

import com.example.teamvoy.entity.Goods;
import com.example.teamvoy.repo.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepo goodsRepo;

    public Goods addGoods(Goods goods) {
        goodsRepo.save(goods);
        return goods;
    }

    public void deleteGoods(Long id) {
        goodsRepo.deleteById(id);
    }

    public Goods getGoods(Long id) {
        if (goodsRepo.findById(id).isPresent()) return goodsRepo.findById(id).get();
        return null;
    }

    public List<Goods> getGoodsList() {
        return goodsRepo.findAll();
    }
}
