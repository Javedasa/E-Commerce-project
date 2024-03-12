package com.example.ecommerceproject.dto.requestDto;

import com.example.ecommerceproject.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {
    String name;

    String emailId;

    String contactNumber;

    Gender gender;
}
