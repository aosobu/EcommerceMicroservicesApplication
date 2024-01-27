package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import com.spiritcoders.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductFacade productFacade;

    public Product createProduct(ProductRequest productRequest){
        return productFacade.saveProduct(productRequest);
//        return productFacade.saveProducts(() -> productFacade.saveProduct(productRequest));
    }

    public List<ProductResponse> getAllProducts() {
        return productFacade.getProducts();
    }
}
