package com.spiritcoders.productservice.service;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.dto.ProductResponse;
import com.spiritcoders.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class ProductFacade {

    private final ProductOperations productOperations;

    public Product saveProduct(ProductRequest productRequest){
        return productOperations.saveProduct(productRequest);
    }

    public Product saveProducts(Supplier<Product> productSaveProcess ) {
        return productSaveProcess.get();
    }

    public List<ProductResponse> getProducts(){
        return productOperations.getProducts();
    }

}
