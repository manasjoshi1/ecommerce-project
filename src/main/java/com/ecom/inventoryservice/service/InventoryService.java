package com.ecom.inventoryservice.service;

import com.ecom.inventoryservice.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepo.existsBySkuCodeAndQtyIsGreaterThanEqual(skuCode, quantity);
    }
}
