package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
