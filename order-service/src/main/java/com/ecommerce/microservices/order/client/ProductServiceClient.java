package com.ecommerce.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.microservices.order.client.bean.ProductBean;

//@FeignClient(name="product-service", url="localhost:8800")
@FeignClient(name="product-service")//if you define load balancer settings
public interface ProductServiceClient {

	
	@GetMapping("api/v1/products/{productId}")
    public ProductBean findProductById(@PathVariable Long productId);
    
}
