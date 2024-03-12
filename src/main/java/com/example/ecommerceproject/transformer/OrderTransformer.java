package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.requestDto.OrderRequestDto;
import com.example.ecommerceproject.dto.responseDto.ItemResponseDto;
import com.example.ecommerceproject.dto.responseDto.OrderResponseDto;
import com.example.ecommerceproject.model.Customer;
import com.example.ecommerceproject.model.Item;
import com.example.ecommerceproject.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {

    public static OrderEntity OrderRequestDtoToOrderEntity(Item item, Customer customer){
    OrderEntity orderEntity= OrderEntity.builder()
                .orderNo(String.valueOf(UUID.randomUUID()))
                .customer(customer)
                .items(new ArrayList<>())
                .totalValue(item.getRequiredQuantity()*item.getProduct().getPrice())
                .build();

    return orderEntity;
    }

    public static OrderResponseDto OrderToOrderResponseDto(OrderEntity orderEntity) {
        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for(Item item: orderEntity.getItems()){
            itemResponseDtoList.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        OrderResponseDto orderResponseDto= OrderResponseDto.builder()
                .orderDate(orderEntity.getOrderDate())
                .cardUsed(orderEntity.getCardUsed())
                .customerName(orderEntity.getCustomer().getName())
                .totalValue(orderEntity.getTotalValue())
                .orderNo(orderEntity.getOrderNo())
                .items(itemResponseDtoList)
                .build();

        return orderResponseDto;
    }
}
