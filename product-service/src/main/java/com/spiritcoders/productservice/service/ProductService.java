package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductFacade productFacade;

    public void createProduct(ProductRequest productRequest){
        productFacade.saveProduct(productRequest);
    }

    public List<ProductResponse> getAllProducts() {
        return productFacade.getProducts();
    }
}
