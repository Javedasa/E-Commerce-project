package com.example.ecommerceproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Item {
    @Id
    @GeneratedValue
    Integer id;

    Integer requiredQuantity;

    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @ManyToOne
    @JoinColumn
    Product product;
}
