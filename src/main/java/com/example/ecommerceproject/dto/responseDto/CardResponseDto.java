package com.example.ecommerceproject.dto.responseDto;

import com.example.ecommerceproject.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {
    String name;

    String cardNo;

    CardType cardType;
}
