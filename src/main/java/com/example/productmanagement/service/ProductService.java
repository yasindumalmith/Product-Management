package com.example.productmanagement.service;

import com.example.productmanagement.DTO.ProductDTO;
import com.example.productmanagement.model.Product;

import java.util.List;

public interface ProductService {
    ProductDTO mapToDto(Product product);
    Product mapToProduct(ProductDTO productDTO);
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductByCategory(String category);
    List<ProductDTO> getProductByProductName(String productName);
    void deleteProductByProductName(String productName);
}
