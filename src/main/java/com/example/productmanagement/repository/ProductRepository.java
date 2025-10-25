package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findByProductNameIgnoreCase(String productName);
    @Transactional
    void deleteByProductNameIgnoreCase(String productName);
}
