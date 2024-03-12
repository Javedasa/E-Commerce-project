package com.example.ecommerceproject.controller;

import com.example.ecommerceproject.dto.requestDto.CustomerRequestDto;
import com.example.ecommerceproject.dto.responseDto.CustomerResponseDto;
import com.example.ecommerceproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto=customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponseDto, HttpStatus.CREATED);
    }

    // get all female customers between age 20-30
    @GetMapping("/getListOfFemaleCustomer")
    public ResponseEntity getListOfFemaleCustomer(){
        List<CustomerResponseDto> customerResponseDtoList=customerService.getListOfFemaleCustomer();
        return new ResponseEntity(customerResponseDtoList,HttpStatus.FOUND);
    }

    // get all male customers less than 45
    @GetMapping("/getListOfMaleCustomer")
    public ResponseEntity getListOfMaleCustomer(){
        List<CustomerResponseDto> customerResponseDtoList=customerService.getListOfMaleCustomer();
        return new ResponseEntity(customerResponseDtoList,HttpStatus.FOUND);
    }

    // customers who have ordered atleast 'k' orders
    @GetMapping("/customersWhoOrderedKOrders")
    public ResponseEntity customersWhoOrderedKOrders(@RequestParam int k){
        List<CustomerResponseDto> customerResponseDtoList=customerService.customersWhoOrderedKOrders(k);
        return new ResponseEntity<>(customerResponseDtoList,HttpStatus.FOUND);
    }
}
