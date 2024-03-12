package com.example.ecommerceproject.dto.requestDto;

import com.example.ecommerceproject.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerRequestDto {
    String name;

    Gender gender;

    String contactNumber;

    String emailId;

    String address;
}
