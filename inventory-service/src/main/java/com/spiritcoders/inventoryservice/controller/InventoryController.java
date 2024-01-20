package com.spiritcoders.inventoryservice.controller;

import com.spiritcoders.inventoryservice.dto.InventoryResponse;
import com.spiritcoders.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/sku-code")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodeList){
        return inventoryService.isInStock(skuCodeList);
    }
}
