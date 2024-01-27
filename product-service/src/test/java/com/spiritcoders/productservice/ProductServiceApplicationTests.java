package com.spiritcoders.productservice;

import com.spiritcoders.productservice.model.Product;
import com.spiritcoders.productservice.service.Discount;
import com.spiritcoders.productservice.service.DiscountRules;
import com.spiritcoders.productservice.service.Rule;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class ProductServiceApplicationTests {
	@Test
	void context() throws Exception {

	}

	@Test
	void whenValidProductAdded_then_shouldCreateProduct() throws Exception {
		DiscountRules discountRules = new DiscountRules();
		discountRules.getDiscount(getProducts());
	}

	private static List<Product> getProducts (){
		return List.of(
				new Product("1", "flowers", "flowers", new BigDecimal(900))
		);
	}
}
