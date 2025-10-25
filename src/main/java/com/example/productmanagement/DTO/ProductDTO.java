package com.example.productmanagement.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Product Name is Requird")
    private String productName;
    @NotBlank(message = "Category is Requird ")
    private String category;
    @NotNull(message = "Price must requird")
    @Min(value = 1, message = "Value must be at least 1")
    private Double price;
    @NotNull(message = "Quantity must requird")
    @Min(value = 1, message = "Value must be at least 1")
    private Integer quantity;
}
