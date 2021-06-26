package com.ecommerce.microservices.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.microservices.order.dto.OrderDto;
import com.ecommerce.microservices.order.entity.Order;
import com.ecommerce.microservices.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	
	private final OrderRepository orderRepository;

	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}


	@Override
	public List<OrderDto> findAll() {
		return orderRepository.findAll().stream().map(OrderDto::toDto).collect(Collectors.toList());
	}
	
	@Override
	public Optional<Order> findById(Long orderId){
		return orderRepository.findById(orderId);
	}

}
