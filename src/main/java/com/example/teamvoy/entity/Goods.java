package com.example.teamvoy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
