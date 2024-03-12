package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
    Card findByCardNo(String cardNo);
}
