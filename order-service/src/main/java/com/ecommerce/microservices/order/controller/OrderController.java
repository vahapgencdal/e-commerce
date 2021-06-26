package com.ecommerce.microservices.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microservices.client.ProductServiceClient;
import com.ecommerce.microservices.client.bean.ProductBean;
import com.ecommerce.microservices.order.dto.OrderDetailDto;
import com.ecommerce.microservices.order.dto.OrderDto;
import com.ecommerce.microservices.order.entity.Order;
import com.ecommerce.microservices.order.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	private final OrderService orderService;
    private final ProductServiceClient productServiceClient;
	

	@Autowired
	public OrderController(OrderService orderService, ProductServiceClient productServiceClient) {
		super();
		this.orderService = orderService;
		this.productServiceClient=productServiceClient;
	}
	
	
	@GetMapping
    public ResponseEntity<List<OrderDto>> orderList() {

        List<OrderDto> orderList = orderService.findAll();
        
        return CollectionUtils.isEmpty(orderList) ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(orderList, HttpStatus.OK);
    }
	
	
	@GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailDto> productById(@PathVariable Long orderId) {

         Optional<Order> product = orderService.findById(orderId);
         
         if(product.isPresent()) {
        	 ProductBean productBean=productServiceClient.findProductById(product.get().getProductId());
             
             OrderDetailDto orderDetailDto=OrderDetailDto.toDto(product.get(),productBean);
             
             return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
         }
         
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
                
    }
	
	
	
}
