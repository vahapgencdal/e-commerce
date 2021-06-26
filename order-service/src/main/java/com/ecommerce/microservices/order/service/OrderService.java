package com.ecommerce.microservices.order.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.microservices.order.dto.OrderDto;
import com.ecommerce.microservices.order.entity.Order;


public interface OrderService {
	List<OrderDto> findAll();

	Optional<Order> findById(Long orderId);
	
}
