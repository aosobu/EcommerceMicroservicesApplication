package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import com.spiritcoders.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFacade {

    private ProductOperations productOperations;

    public Product saveProduct(ProductRequest productRequest){
        return productOperations.saveProduct(productRequest);
    }

    public List<ProductResponse> getProducts(){
        return productOperations.getProducts();
    }

}
