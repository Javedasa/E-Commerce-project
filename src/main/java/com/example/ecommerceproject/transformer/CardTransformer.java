package com.example.ecommerceproject.transformer;

import com.example.ecommerceproject.dto.requestDto.CardRequestDto;
import com.example.ecommerceproject.dto.responseDto.CardResponseDto;
import com.example.ecommerceproject.model.Card;

public class CardTransformer {

    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){
        Card card=Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .validTill(cardRequestDto.getValidTill())
                .build();

        return card;
    }

    public static CardResponseDto CardToCardResponseDto(Card card){
        CardResponseDto cardResponseDto=CardResponseDto.builder()
                .name(card.getCustomer().getName())
                .cardNo(card.getCardNo())
                .cardType(card.getCardType())
                .build();

        return cardResponseDto;
    }
}
