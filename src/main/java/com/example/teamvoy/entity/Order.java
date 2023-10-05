package com.example.teamvoy.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private List<Goods> goodsList = new ArrayList<>();
    private boolean isPaid = false;
    private LocalDateTime orderTime = LocalDateTime.now();
}
