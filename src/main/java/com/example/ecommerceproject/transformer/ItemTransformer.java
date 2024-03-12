package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.responseDto.ItemResponseDto;
import com.example.ecommerceproject.model.Customer;
import com.example.ecommerceproject.model.Item;
import com.example.ecommerceproject.model.Product;

public class ItemTransformer {
    public static Item ItemRequestDtoToItem(int quantity){

        Item item= Item.builder()
                .requiredQuantity(quantity)
                .build();

        return item;
    }

    public static ItemResponseDto ItemToItemResponseDto(Item item) {
        ItemResponseDto itemResponseDto=ItemResponseDto.builder()
                .quantityAdded(item.getRequiredQuantity())
                .productName(item.getProduct().getName())
                .price(item.getProduct().getPrice())
                .build();

        return itemResponseDto;
    }
}
