package com.example.ecommerceproject.dto.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDto {
    String emailId;

    int productId;

    String cardNo;

    int cvv;

    int requiredQuantity;
}
