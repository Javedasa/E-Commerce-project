package com.example.ecommerceproject.service;

import com.example.ecommerceproject.dto.requestDto.CheckoutCartRequestDto;
import com.example.ecommerceproject.dto.requestDto.ItemRequestDto;
import com.example.ecommerceproject.dto.responseDto.CartResponseDto;
import com.example.ecommerceproject.dto.responseDto.OrderResponseDto;
import com.example.ecommerceproject.exception.CustomerNotFoundException;
import com.example.ecommerceproject.exception.EmptyCartException;
import com.example.ecommerceproject.exception.InsufficientQuantityException;
import com.example.ecommerceproject.exception.InvalidCardException;
import com.example.ecommerceproject.model.*;
import com.example.ecommerceproject.repository.*;
import com.example.ecommerceproject.transformer.CartTransformer;
import com.example.ecommerceproject.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    public Cart createCart() {
       Cart cart=new Cart();
       cart.setCartTotalPrice(0);
       return cart;
    }

    public CartResponseDto addToCart(Item item, ItemRequestDto itemRequestDto) {
        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        Product product = productRepository.findById(itemRequestDto.getProductId()).get();

        Cart cart = customer.getCart();
        cart.setCartTotalPrice(cart.getCartTotalPrice()+item.getRequiredQuantity()*product.getPrice());
        cart.getItems().add(item);
        item.setCart(cart);
        item.setProduct(product);

        Cart savedCart = cartRepository.save(cart);  // saves both cart and item
        Item savedItem = cart.getItems().get(cart.getItems().size()-1);
      //  product.getItems().add(savedItem);
      //i have made this comment to check will it effect the code or not
        //prepare response dto
        return CartTransformer.CartToCartResponseDto(savedCart);
    }


    public OrderResponseDto checkOutCart(CheckoutCartRequestDto checkoutCartRequestDto) throws Exception{

        Customer customer = customerRepository.findByEmailId(checkoutCartRequestDto.getEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Card card = cardRepository.findByCardNo(checkoutCartRequestDto.getCardNo());
        Date date = new Date();
        if(card==null || card.getCvv()!= checkoutCartRequestDto.getCvv() || date.after(card.getValidTill())){
            throw new InvalidCardException("Sorry! You can't use this card!");
        }

        Cart cart = customer.getCart();
        if(cart.getItems().size()==0){
            throw new EmptyCartException("Cart is empty!!");
        }

        try{
            OrderEntity order = orderService.placeOrder(cart,card);
            resetCart(cart);

            OrderEntity savedOrder = orderRepository.save(order);
            customer.getOrderEntityList().add(savedOrder);

            return OrderTransformer.OrderToOrderResponseDto(savedOrder);
        }
        catch (InsufficientQuantityException e){
            throw e;
        }
    }

    private void resetCart(Cart cart){

        cart.setCartTotalPrice(0);
        for(Item item: cart.getItems())
            item.setCart(null);
        cart.setItems(new ArrayList<>());
    }
}
