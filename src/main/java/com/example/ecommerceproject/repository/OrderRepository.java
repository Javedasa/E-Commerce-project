package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
}
