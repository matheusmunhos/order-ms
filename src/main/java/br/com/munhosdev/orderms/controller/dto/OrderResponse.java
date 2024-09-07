package br.com.munhosdev.orderms.controller.dto;

import br.com.munhosdev.orderms.domain.Order;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromEntity(Order order) {
        return new OrderResponse(order.getOrderId(), order.getCustomerId(), order.getTotal());
    }
}
