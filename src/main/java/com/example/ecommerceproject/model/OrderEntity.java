package com.example.ecommerceproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String orderNo;

    int totalValue;

    Integer quantity;

    @CreationTimestamp
    Date orderDate;

    String cardUsed;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> items=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;
}
