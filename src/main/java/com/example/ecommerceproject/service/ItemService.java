package com.example.ecommerceproject.service;

import com.example.ecommerceproject.dto.requestDto.ItemRequestDto;
import com.example.ecommerceproject.exception.CustomerNotFoundException;
import com.example.ecommerceproject.exception.InsufficientQuantityException;
import com.example.ecommerceproject.exception.OutOfStockException;
import com.example.ecommerceproject.exception.ProductNotFoundException;
import com.example.ecommerceproject.model.Customer;
import com.example.ecommerceproject.model.Item;
import com.example.ecommerceproject.model.Product;
import com.example.ecommerceproject.repository.CustomerRepository;
import com.example.ecommerceproject.repository.ProductRepository;
import com.example.ecommerceproject.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Item createItem(ItemRequestDto itemRequestDto) throws Exception{
      Optional<Product> product=productRepository.findById(itemRequestDto.getProductId());
      if(!product.isPresent()){
          throw new ProductNotFoundException("Product does not exist!!!");
      }
      Product product1=product.get();

      Customer customer=customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
     if(customer==null){
         throw new CustomerNotFoundException("Customer does not exist");
     }
     if(product1.getQuantity()==0){
         throw new OutOfStockException("Product is out of Stock");
     }
     if(product1.getQuantity()< itemRequestDto.getRequiredQuantity()){
         throw new InsufficientQuantityException("Sorry!! the required quantity is not available");
     }

        Item item = ItemTransformer.ItemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;
    }
}
