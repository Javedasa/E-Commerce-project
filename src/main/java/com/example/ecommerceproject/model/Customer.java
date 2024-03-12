package com.example.ecommerceproject.model;

import com.example.ecommerceproject.Enum.Gender;
import jakarta.persistence.*;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(unique = true,nullable = false)
    String emailId;

    @Column(unique = true,nullable = false)
    String contactNumber;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cards = new ArrayList<>();

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orderEntityList=new ArrayList<>();
}
