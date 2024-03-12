package com.example.ecommerceproject.dto.requestDto;

import com.example.ecommerceproject.Enum.CardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {
    String emailId;

    String cardNo;

    int cvv;

    CardType cardType;

    Date validTill;
}
