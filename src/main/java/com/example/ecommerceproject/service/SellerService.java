package com.example.ecommerceproject.service;

import com.example.ecommerceproject.dto.requestDto.SellerRequestDto;
import com.example.ecommerceproject.dto.responseDto.SellerResponseDto;
import com.example.ecommerceproject.model.Seller;
import com.example.ecommerceproject.repository.SellerRepository;
import com.example.ecommerceproject.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {
       Seller seller=SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);
       Seller savedSeller=sellerRepository.save(seller);
       SellerResponseDto sellerResponseDto=SellerTransformer.sellerToSellerResponseDto(savedSeller);
       return sellerResponseDto;
    }
}
