package com.example.productmanagement.controller;

import com.example.productmanagement.DTO.ProductDTO;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        return new ResponseEntity<ProductDTO>(productService.saveProduct(productDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/category/{category}")
    public List<ProductDTO> getProductsByCategory(@PathVariable("category") String category){
        return productService.getProductByCategory(category);
    }
    @DeleteMapping("{name}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("name") String productName){
        productService.deleteProductByProductName(productName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
