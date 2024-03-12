package com.example.ecommerceproject.dto.responseDto;

import com.example.ecommerceproject.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerResponseDto {
    String name;

    Gender gender;

    String contactNumber;

    String emailId;

    String address;
}
