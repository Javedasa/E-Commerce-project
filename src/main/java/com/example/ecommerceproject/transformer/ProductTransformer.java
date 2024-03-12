package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.Enum.ProductStatus;
import com.example.ecommerceproject.dto.requestDto.ProductRequestDto;
import com.example.ecommerceproject.dto.responseDto.ProductResponseDto;
import com.example.ecommerceproject.model.Product;

public class ProductTransformer {
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product=Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .productCategory(productRequestDto.getProductCategory())
                .build();
        return product;
    }

    public static ProductResponseDto productToProductResponseDto(Product product){
        ProductResponseDto productResponseDto=ProductResponseDto.builder()
                .productName(product.getName())
                .productStatus(product.getProductStatus())
                .productCategory(product.getProductCategory())
                .price(product.getPrice())
                .sellerName(product.getSeller().getName())
                .build();

        return productResponseDto;
    }
}
