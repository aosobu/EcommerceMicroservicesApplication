package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import com.spiritcoders.productservice.model.Product;
import com.spiritcoders.productservice.service.components.ProductRetrieveComponent;
import com.spiritcoders.productservice.service.components.ProductSaveComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductOperations {
    private final ProductSaveComponent productSaveComponent;

    private final ProductRetrieveComponent productRetrieveComponent;

    public Product saveProduct(ProductRequest productRequest){
        return productSaveComponent.saveProduct(productRequest);
    }

    public List<ProductResponse> getProducts(){
        return productRetrieveComponent.getProducts();
    }
}
