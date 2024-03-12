package com.example.ecommerceproject.dto.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemRequestDto {

    Integer requiredQuantity;

    Integer productId;

    String customerEmailId;
}
