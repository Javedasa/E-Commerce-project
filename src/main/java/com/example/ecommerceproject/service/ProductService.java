package com.example.ecommerceproject.service;

import com.example.ecommerceproject.Enum.ProductCategory;
import com.example.ecommerceproject.dto.requestDto.ProductRequestDto;
import com.example.ecommerceproject.dto.responseDto.ItemResponseDto;
import com.example.ecommerceproject.dto.responseDto.ProductResponseDto;
import com.example.ecommerceproject.exception.ProductNotFoundException;
import com.example.ecommerceproject.exception.SellerNotFoundException;
import com.example.ecommerceproject.model.Item;
import com.example.ecommerceproject.model.Product;
import com.example.ecommerceproject.model.Seller;
import com.example.ecommerceproject.repository.ProductRepository;
import com.example.ecommerceproject.repository.SellerRepository;
import com.example.ecommerceproject.transformer.ItemTransformer;
import com.example.ecommerceproject.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception {
         Seller seller=sellerRepository.findByEmailId(productRequestDto.getSellerEmailId());
         if(seller==null){
             throw new SellerNotFoundException("Seller not found");
         }

         Product product= ProductTransformer.productRequestDtoToProduct(productRequestDto);

           product.setSeller(seller);
           seller.getProducts().add(product);
           sellerRepository.save(seller);

          ProductResponseDto productResponseDto=ProductTransformer.productToProductResponseDto(product);
          return productResponseDto;

    }


    public List<ProductResponseDto> getAllProductsByCategoryAndPrice(ProductCategory productCategory, Integer price) {
    List<Product>products=productRepository.findAllProductByProductCategoryAndPrice(productCategory,price);
    List<ProductResponseDto>productResponseDtos=new ArrayList<>();
    for(Product product:products){
        ProductResponseDto productResponseDto=ProductTransformer.productToProductResponseDto(product);
        productResponseDtos.add(productResponseDto);
    }
    return productResponseDtos;
    }

    public List<ProductResponseDto> getProductsOfCategory(ProductCategory productCategory) {
        List<Product>products=productRepository.findByProductCategory(productCategory);
        List<ProductResponseDto>productResponseDtos=new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductTransformer.productToProductResponseDto(product));
        }
        return productResponseDtos;
    }


    public List<ProductResponseDto> getProductsOfCategoryAndPrice(ProductCategory productCategory, Integer price) {
        List<Product>products=productRepository.findByProductCategoryAndPriceGreaterThan(productCategory,price);
        List<ProductResponseDto>productResponseDtos=new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductTransformer.productToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    public List<ItemResponseDto> getItemList(Integer id) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new ProductNotFoundException("Product not found !!!");
        }

        Product product = productOptional.get();
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();

        // Check for null to avoid NullPointerException
        if (product.getItems() != null) {
            List<Item> items = product.getItems();
            for (Item item : items) {
                itemResponseDtos.add(ItemTransformer.ItemToItemResponseDto(item));
            }
        }

        return itemResponseDtos;
    }

}
