package com.spiritcoders.inventoryservice.service;

import com.spiritcoders.inventoryservice.dto.InventoryResponse;
import com.spiritcoders.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodeList) {
         return inventoryRepository.findBySkuCodeIn(skuCodeList)
                .stream().map(inventory ->
                                InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build())
                            .toList();
    }
}
