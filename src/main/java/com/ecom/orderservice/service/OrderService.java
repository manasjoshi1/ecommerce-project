package com.ecom.orderservice.service;

import com.ecom.orderservice.client.InventoryClient;
import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.dto.OrderResponse;
import com.ecom.orderservice.model.Order;
import com.ecom.orderservice.repos.OrderRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepo orderRepo;
    private final InventoryClient inventoryClient;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        if(inventoryClient.isInStock(orderRequest.skuNumber(),orderRequest.qty())) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .qty(orderRequest.qty())
                    .skuCode(orderRequest.skuNumber())
                    .price(orderRequest.price())
                    .build();
            orderRepo.save(order);
            return new OrderResponse(order.getOrderNumber(), order.getSkuCode(), order.getQty(),order.getPrice());
        }else{
            throw new RuntimeException("Product with skuCode "+ orderRequest.skuNumber() + " is not in stock");
        }
    }


    public List<OrderResponse> getAllOrders() {
        return orderRepo.findAll().stream().map(order ->
         new OrderResponse(order.getOrderNumber(), order.getSkuCode(), order.getQty(),order.getPrice())).toList();
    }
}
