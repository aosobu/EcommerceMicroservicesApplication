package com.spiritcoders.productservice;

import com.spiritcoders.productservice.dto.ProductRequest;
import com.spiritcoders.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class ProductServiceApplication implements CommandLineRunner {

	private final ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ProductRequest productRequest = ProductRequest.builder()
//				.name("Bandana Ravens")
//				.description("trendy bandana for men")
//				.price(new BigDecimal(3500))
//				.build();
//		productService.createProduct(productRequest);
	}
}
