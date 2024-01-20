package com.spiritcoders.orderservice.service;

import com.spiritcoders.orderservice.dto.InventoryResponse;
import com.spiritcoders.orderservice.dto.OrderLineItemsDto;
import com.spiritcoders.orderservice.dto.OrderRequest;
import com.spiritcoders.orderservice.model.Order;
import com.spiritcoders.orderservice.model.OrderLineItems;
import com.spiritcoders.orderservice.repository.OrderRepository;
import com.spiritcoders.orderservice.wrapper.WebClientWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClientWrapper webClientWrapper;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = orderLineItems.stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        InventoryResponse [] inventoryResponseArray = webClientWrapper.fetchTemp("http://localhost:8082/api/inventory", skuCodes, "skuCode");

        boolean allProductsInStock =
                Arrays.stream(inventoryResponseArray)
                        .allMatch(InventoryResponse::isInStock);

        if ( allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
