package com.example.ecommerceproject.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {

     Integer cartTotalPrice;

     String customerName;

     List<ItemResponseDto> items;
}
