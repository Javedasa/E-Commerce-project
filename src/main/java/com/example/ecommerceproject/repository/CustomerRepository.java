package com.example.ecommerceproject.repository;

import com.example.ecommerceproject.Enum.Gender;
import com.example.ecommerceproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByGender(Gender gender);

    Customer findByEmailId(String emailId);
}
