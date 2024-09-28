package com.ecom.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponse(String orderNumber,String skuNumber,Integer qty,BigDecimal price) {
}
