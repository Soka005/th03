package com.example.th03.models;

import java.math.BigDecimal;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity 
@Table(name = "products") 
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor 
public class Product { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
 
    @Column(nullable = false, length = 200) 
    private String name; 
 
    @Column(nullable = false, precision = 12, scale = 2) 
    private BigDecimal price; 
 
    @Column(length = 1000) 
    private String description; 
 
    @ManyToOne 
    @JoinColumn(name = "category_id") 
    private Category category; 
 
    @OneToMany(mappedBy = "product") 
    private List<OrderDetail> orderDetails; 
}