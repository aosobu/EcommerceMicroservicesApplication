package com.spiritcoders.productservice.service.components;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.model.Product;
import com.spiritcoders.productservice.repository.ProductEntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductSaveComponent {

    private final ProductEntityManager productEntityManager;

    public Product saveProduct(ProductRequest productRequest){

        Product product = mapProductRequestToProduct(productRequest);
        Product savedProduct =  productEntityManager.saveProduct(product);

        log.info("Product is {} is save", savedProduct.getId());
        return savedProduct;
    }

    private Product mapProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
