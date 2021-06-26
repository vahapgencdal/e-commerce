package com.ecommerce.microservices.product.dto;

import java.math.BigDecimal;

import com.ecommerce.microservices.product.entity.Product;

import lombok.Data;

@Data
public class ProductDto {
	
	private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private Boolean isActive;
    
    
    public static ProductDto toDto(Product product) {
    	
    	ProductDto productDto = new ProductDto();
    	productDto.setDescription(product.getDescription());
    	productDto.setId(product.getId());
    	productDto.setName(product.getName());
    	productDto.setQuantity(product.getQuantity());
    	productDto.setPrice(product.getPrice());
    	productDto.setIsActive(product.getIsActive());
    	
    	return productDto;
    	
    }
   
}
