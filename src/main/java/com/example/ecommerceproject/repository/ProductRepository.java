package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllProductByProductCategoryAndPrice(ProductCategory productCategory, Integer price);

    List<Product> findByProductCategory(ProductCategory productCategory);

    List<Product> findByProductCategoryAndPriceGreaterThan(ProductCategory productCategory, Integer price);
}
