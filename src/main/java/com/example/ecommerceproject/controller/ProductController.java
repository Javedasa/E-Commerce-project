package com.example.ecommerceproject.controller;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.dto.requestDto.ProductRequestDto;
import com.example.ecommerceproject.dto.responseDto.ItemResponseDto;
import com.example.ecommerceproject.dto.responseDto.ProductResponseDto;
import com.example.ecommerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
       try{
           ProductResponseDto productResponseDto=productService.addProduct(productRequestDto);
           return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
       }
       catch (Exception e){
          return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/getAllProductsByCategoryAndPrice/{productCategory}/{price}")
    public ResponseEntity<ProductResponseDto> getAllProductsByCategoryAndPrice(@PathVariable("productCategory") ProductCategory productCategory,
                                                           @PathVariable("price") Integer price){

        List<ProductResponseDto> productResponseDtos = productService.getAllProductsByCategoryAndPrice(productCategory,price);
        return new ResponseEntity(productResponseDtos,HttpStatus.FOUND);
    }

    // get all the products of a category
    @GetMapping("/getProductsOfCategory/{productCategory}")
    public ResponseEntity<ProductResponseDto> getProductsOfCategory(@PathVariable("productCategory")ProductCategory productCategory){
      List<ProductResponseDto>products=productService.getProductsOfCategory(productCategory);
      return new ResponseEntity(products,HttpStatus.FOUND);
    }


    // get all the products in a category who have price greater than 500
    @GetMapping("/getProductsOfCategoryAndPrice/{productCategory}/{price}")
    public ResponseEntity<ProductResponseDto> getProductsOfCategoryAndPrice(@PathVariable("productCategory")ProductCategory productCategory,
                                                                            @PathVariable("price")Integer price){
        List<ProductResponseDto>products=productService.getProductsOfCategoryAndPrice(productCategory,price);
        return new ResponseEntity(products,HttpStatus.FOUND);
    }

    @GetMapping("/getItemList/{id}")
    public ResponseEntity getItemList(@PathVariable("id")Integer id){
        try{
            List<ItemResponseDto>itemResponseDtos=productService.getItemList(id);
            return new ResponseEntity(itemResponseDtos,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    // get the top 5 cheapest products in a category

    // get top 5 costliest products in a category

    // get all the products of seller based on emailid

    // get all the out of stock products for a particular catgeory

    // send an email to the seller of the product if the product is out os stock.

}
