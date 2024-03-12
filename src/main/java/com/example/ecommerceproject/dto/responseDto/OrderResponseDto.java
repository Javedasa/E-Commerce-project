package com.example.ecommerceproject.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderResponseDto {

    String customerName;

    String orderNo;

    int totalValue;

    String cardUsed;

    Date orderDate;

    List<ItemResponseDto> items;
}
