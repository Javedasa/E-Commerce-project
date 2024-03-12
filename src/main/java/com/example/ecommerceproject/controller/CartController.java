package com.example.ecommerceproject.controller;

import com.example.ecommerceproject.dto.requestDto.CheckoutCartRequestDto;
import com.example.ecommerceproject.dto.requestDto.ItemRequestDto;
import com.example.ecommerceproject.dto.responseDto.CartResponseDto;
import com.example.ecommerceproject.dto.responseDto.OrderResponseDto;
import com.example.ecommerceproject.model.Item;
import com.example.ecommerceproject.service.CartService;
import com.example.ecommerceproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
       try{
         Item item=itemService.createItem(itemRequestDto);
         CartResponseDto cartResponseDto=cartService.addToCart(item,itemRequestDto);
         return new ResponseEntity(cartResponseDto, HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }


    @PostMapping("/checkout")
    public ResponseEntity checkoutCart(@RequestBody CheckoutCartRequestDto checkoutCartRequestDto){

        try{
            OrderResponseDto orderResponseDto = cartService.checkOutCart(checkoutCartRequestDto);
            return new ResponseEntity(orderResponseDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    // correct the bug
    // add the functionality of email sending in direct order and checkout cart
    // integrate swagger
}
