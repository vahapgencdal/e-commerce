package com.ecommerce.microservices.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ecommerce.microservices.client.bean.ProductBean;
import com.ecommerce.microservices.order.entity.Order;

import lombok.Data;

@Data
public class OrderDetailDto {
	
	
    private Long id;
	
    private ProductBean productBean;
    private Long customerId;
    private Integer quantity;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Boolean isActive;
    
    public static OrderDetailDto  toDto(Order order, ProductBean productBean) {
    	OrderDetailDto dto = new OrderDetailDto();
    	dto.setId(order.getId());
    	dto.setProductBean(productBean);
    	dto.setCustomerId(order.getCustomerId());
    	dto.setQuantity(order.getQuantity());
    	dto.setAmount(order.getAmount());
    	return dto;
    }
   
}
