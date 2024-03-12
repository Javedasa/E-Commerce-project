package com.example.ecommerceproject.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    Integer quantityAdded;

    String productName;

    Integer price;
}
