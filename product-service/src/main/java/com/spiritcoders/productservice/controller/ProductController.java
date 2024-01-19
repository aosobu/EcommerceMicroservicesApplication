package com.spiritcoders.productservice.controller;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import com.spiritcoders.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
