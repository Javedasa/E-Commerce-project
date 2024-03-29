package com.example.ecommerceproject.controller;

import com.example.ecommerceproject.dto.requestDto.SellerRequestDto;
import com.example.ecommerceproject.dto.responseDto.SellerResponseDto;
import com.example.ecommerceproject.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/addSeller")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        SellerResponseDto sellerResponseDto=sellerService.addSeller(sellerRequestDto);
        return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
    }


    // update the seller info based on email.

    // get all the sellers who sell products of a particular category

    // get all the products sold by a seller in a category

    // seller with highest number of products

    // seller with minimum number of products

    // seller(s) selling the costliest product

    // seller(s) selling the cheapest product
}
