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
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @JoinColumn(unique = true,nullable = false)
    String contactNumber;

    @JoinColumn(unique = true,nullable = false)
    String emailId;

    String address;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products=new ArrayList<>();
}
