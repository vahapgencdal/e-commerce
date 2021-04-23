package com.ecommerce.microservices.order.entity;


import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
	
    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;
    
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
    
    @Column(name = "IS_ACTIVE")
    private Boolean isActive = Boolean.TRUE;
    
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

}