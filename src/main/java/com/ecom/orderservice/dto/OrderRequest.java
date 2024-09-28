package com.ecom.orderservice.dto;


import java.math.BigDecimal;


public record OrderRequest(String skuNumber,Integer qty,BigDecimal price) {
}
