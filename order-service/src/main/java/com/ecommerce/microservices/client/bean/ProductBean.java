package com.ecommerce.microservices.client.bean;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductBean {
	
	private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private Boolean isActive;
   
}
