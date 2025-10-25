package com.example.productmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name",nullable = false)
    private String productName;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;

}
