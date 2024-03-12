package com.example.ecommerceproject.model;

import com.example.ecommerceproject.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true,nullable = false)
    String cardNo;

    int cvv;

    @Enumerated(value = EnumType.STRING)
    CardType cardType;

    Date validTill;

    @OneToOne
    @JoinColumn
    Customer customer;
}
