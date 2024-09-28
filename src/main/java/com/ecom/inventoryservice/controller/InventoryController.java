package com.ecom.inventoryservice.controller;

import com.ecom.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean useStock(@RequestParam String skuCode, @RequestParam int quantity) {
        return inventoryService.useStock(skuCode, quantity);
    }

}
