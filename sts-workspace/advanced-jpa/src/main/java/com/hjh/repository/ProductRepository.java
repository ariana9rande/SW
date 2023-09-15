package com.hjh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjh.entity.Product;

// 예제 6.7
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
