package com.ecommerce.microservices.product.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.microservices.product.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findById(Long productId);

}
