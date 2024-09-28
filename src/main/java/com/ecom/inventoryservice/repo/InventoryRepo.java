package com.ecom.inventoryservice.repo;

import com.ecom.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {

    Boolean existsBySkuCodeAndQtyIsGreaterThanEqual(String skuCode, int qty);
    Inventory findBySkuCode(String skuCode);
}
