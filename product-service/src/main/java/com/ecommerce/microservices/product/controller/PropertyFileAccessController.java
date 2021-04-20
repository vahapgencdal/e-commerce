package com.ecommerce.microservices.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microservices.product.beans.PropertyAccessBean;
import com.ecommerce.microservices.product.beans.PropertyAccessValue;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessController {
	
	@Autowired
	private PropertyAccessBean propertyAccessBean;

	@GetMapping("/accessPropertyFile")
    public PropertyAccessValue accesPropertyFile(){

        return new PropertyAccessValue(propertyAccessBean.getName(),
                propertyAccessBean.getDescription());
    }
}
