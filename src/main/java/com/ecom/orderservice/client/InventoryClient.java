package com.ecom.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface InventoryClient {
    @GetMapping( value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity);

    @PutMapping( value = "/api/inventory")
    boolean useStock(@RequestParam String skuCode, @RequestParam int quantity);
}
