package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.requestDto.CustomerRequestDto;
import com.example.ecommerceproject.dto.responseDto.CustomerResponseDto;
import com.example.ecommerceproject.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        Customer customer=Customer.builder()
                .name(customerRequestDto.getName())
                .emailId(customerRequestDto.getEmailId())
                .contactNumber(customerRequestDto.getContactNumber())
                .gender(customerRequestDto.getGender())
                .build();

        return customer;
    }
    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        CustomerResponseDto customerResponseDto=CustomerResponseDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .contactNumber(customer.getContactNumber())
                .build();

    return customerResponseDto;
    }
}
