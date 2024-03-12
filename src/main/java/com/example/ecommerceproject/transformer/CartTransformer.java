package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.responseDto.CartResponseDto;
import com.example.ecommerceproject.dto.responseDto.ItemResponseDto;
import com.example.ecommerceproject.model.Cart;
import com.example.ecommerceproject.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {
    public static CartResponseDto CartToCartResponseDto(Cart cart) {

        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        for(Item item: cart.getItems()){
            itemResponseDtos.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        CartResponseDto cartResponseDto=CartResponseDto.builder()
                .cartTotalPrice(cart.getCartTotalPrice())
                .customerName(cart.getCustomer().getName())
                .items(itemResponseDtos)
                .build();

        return cartResponseDto;
    }
}
