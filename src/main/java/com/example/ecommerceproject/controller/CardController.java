package com.example.ecommerceproject.controller;

import com.example.ecommerceproject.dto.requestDto.CardRequestDto;
import com.example.ecommerceproject.dto.responseDto.CardResponseDto;
import com.example.ecommerceproject.model.Card;
import com.example.ecommerceproject.service.CardService;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/addcard")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        try{
            CardResponseDto cardResponseDto=cardService.addCard(cardRequestDto);
            return new ResponseEntity(cardResponseDto, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.FOUND);
        }
    }
}
