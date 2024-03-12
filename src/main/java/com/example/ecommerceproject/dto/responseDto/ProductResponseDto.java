package com.example.ecommerceproject.dto.responseDto;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {
    String productName;

    int price;

    ProductCategory productCategory;

    String sellerName;

    ProductStatus productStatus;
}
