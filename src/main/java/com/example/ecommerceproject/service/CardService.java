package com.example.ecommerceproject.service;

import com.example.ecommerceproject.dto.requestDto.CardRequestDto;
import com.example.ecommerceproject.dto.responseDto.CardResponseDto;
import com.example.ecommerceproject.exception.CustomerNotFoundException;
import com.example.ecommerceproject.model.Card;
import com.example.ecommerceproject.model.Customer;
import com.example.ecommerceproject.repository.CustomerRepository;
import com.example.ecommerceproject.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws Exception {
        Customer customer=customerRepository.findByEmailId(cardRequestDto.getEmailId());
        if(customer==null){
           throw new CustomerNotFoundException("Email id is incorrect");
        }

        Card card= CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);
       Customer savedCustomer= customerRepository.save(customer);

       return CardTransformer.CardToCardResponseDto(card);
    }
}
