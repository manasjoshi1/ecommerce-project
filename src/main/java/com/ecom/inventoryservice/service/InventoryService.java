package com.ecom.inventoryservice.service;

import com.ecom.inventoryservice.model.Inventory;
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

    public boolean useStock(String skuCode, Integer quantity) {
        Inventory inventory = inventoryRepo.findBySkuCode(skuCode);
        if (inventory != null) {
            if (inventory.getQty() >= quantity) {
                inventory.setQty(inventory.getQty() - quantity);
                inventoryRepo.save(inventory);
                return true;
            }
            throw new RuntimeException("IS : Stock is not available for " + skuCode);
        } else {
            throw new RuntimeException("IS : SkuCode Not found " + skuCode);
        }
    }
}
