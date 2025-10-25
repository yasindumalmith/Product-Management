package com.example.productmanagement.service.impl;

import com.example.productmanagement.DTO.ProductDTO;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public ProductDTO mapToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
    @Override
    public Product mapToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mapToProduct(productDTO);
        Product saved = productRepository.save(product);
        return mapToDto(saved);

    }
    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product->modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }
    public List<ProductDTO> getProductByProductName(String productName){
        List<Product> products = productRepository.findByProductNameIgnoreCase(productName);
        return products.stream().map(product->modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }
    public List<ProductDTO> getProductByCategory(String category){
        List<Product> products = productRepository.findByCategoryIgnoreCase(category);
        return products.stream().map(product->modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }
    public void deleteProductByProductName(String productName){
        productRepository.deleteByProductNameIgnoreCase(productName);
    }
}
