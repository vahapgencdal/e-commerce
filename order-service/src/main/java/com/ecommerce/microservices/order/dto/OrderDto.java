package com.ecommerce.microservices.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.ecommerce.microservices.order.entity.Order;

import lombok.Data;

@Data
public class OrderDto {
	
	
    private Long id;
	
    private Long productId;
    private Long customerId;
    private Integer quantity;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Boolean isActive;
    
    public static OrderDto  toDto(Order order) {
    	OrderDto dto = new OrderDto();
    	dto.setId(order.getId());
    	dto.setProductId(order.getProductId());
    	dto.setCustomerId(order.getCustomerId());
    	dto.setQuantity(order.getQuantity());
    	dto.setAmount(order.getAmount());
    	return dto;
    }
   
}
