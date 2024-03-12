package com.example.ecommerceproject.model;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.Enum.ProductStatus;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Integer price;

    Integer quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Seller seller;
}
