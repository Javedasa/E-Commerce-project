package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.requestDto.SellerRequestDto;
import com.example.ecommerceproject.dto.responseDto.SellerResponseDto;
import com.example.ecommerceproject.model.Seller;

public class SellerTransformer {
    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        Seller seller=Seller.builder()
                .name(sellerRequestDto.getName())
                .address(sellerRequestDto.getAddress())
                .emailId(sellerRequestDto.getEmailId())
                .contactNumber(sellerRequestDto.getContactNumber())
                .gender(sellerRequestDto.getGender())
                .build();

        return seller;
    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        SellerResponseDto sellerResponseDto=SellerResponseDto.builder()
                .name(seller.getName())
                .gender(seller.getGender())
                .contactNumber(seller.getContactNumber())
                .emailId(seller.getEmailId())
                .address(seller.getAddress())
                .build();

        return sellerResponseDto;
    }
}
