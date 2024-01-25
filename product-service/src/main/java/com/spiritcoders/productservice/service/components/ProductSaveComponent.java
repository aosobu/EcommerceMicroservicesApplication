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

    private ProductEntityManager productEntityManager;

    public Product saveProduct(ProductRequest productRequest){

        Product product = mapProductRequestToProduct(productRequest);
        log.info("Product is {} is save", product.getId());

        return productEntityManager.saveProduct(product);
    }

    private Product mapProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
