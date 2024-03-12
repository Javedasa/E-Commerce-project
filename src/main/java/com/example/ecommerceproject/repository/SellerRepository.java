package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.model.Product;
import com.example.ecommerceproject.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
    Seller findByEmailId(String emailId);

}
