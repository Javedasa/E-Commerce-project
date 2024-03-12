package com.example.ecommerceproject.service;

import com.example.ecommerceproject.Enum.Gender;
import com.example.ecommerceproject.dto.requestDto.CustomerRequestDto;
import com.example.ecommerceproject.dto.responseDto.CustomerResponseDto;
import com.example.ecommerceproject.model.Cart;
import com.example.ecommerceproject.model.Customer;
import com.example.ecommerceproject.repository.CustomerRepository;
import com.example.ecommerceproject.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartService cartService;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer=CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);

        Cart cart=cartService.createCart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer=customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }

    public List<CustomerResponseDto> getListOfFemaleCustomer() {
        List<Customer>femaleCustomers=customerRepository.findByGender(Gender.FEMALE);
        List<CustomerResponseDto>customerResponseDtoList=new ArrayList<>();
        for(Customer customer:femaleCustomers){
            customerResponseDtoList.add(CustomerTransformer.customerToCustomerResponseDto(customer));
        }
        return customerResponseDtoList;
    }

    public List<CustomerResponseDto> getListOfMaleCustomer() {
        List<Customer>maleCustomers=customerRepository.findByGender(Gender.MALE);
        List<CustomerResponseDto>customerResponseDtoList=new ArrayList<>();
        for(Customer customer:maleCustomers){
            customerResponseDtoList.add(CustomerTransformer.customerToCustomerResponseDto(customer));
        }
        return customerResponseDtoList;
    }

    public List<CustomerResponseDto> customersWhoOrderedKOrders(int k) {
        List<Customer>customers=customerRepository.findAll();
        List<CustomerResponseDto>customerResponseDtoList=new ArrayList<>();
        for(Customer customer:customers){
            if(customer.getOrderEntityList().size()==k){
                customerResponseDtoList.add(CustomerTransformer.customerToCustomerResponseDto(customer));
            }
        }
        return customerResponseDtoList;
    }
}
