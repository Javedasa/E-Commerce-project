package com.example.ecommerceproject.dto.requestDto;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
    String sellerEmailId;

    String name;

    Integer price;

    Integer quantity;

    ProductCategory productCategory;
}
