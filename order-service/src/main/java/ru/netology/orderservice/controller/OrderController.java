package ru.netology.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.common.model.Order;
import ru.netology.common.model.OrderItem;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
public class OrderController {

    private final Map<Long, List<Order>> userOrders = new HashMap<>();

    public OrderController() {
        // Инициализация тестовых данных
        Order order1 = new Order(1L, 1L, BigDecimal.valueOf(1500), "RUB",
                List.of(new OrderItem("Ноутбук", 1, BigDecimal.valueOf(1500))));

        Order order2 = new Order(2L, 1L, BigDecimal.valueOf(500), "RUB",
                Arrays.asList(
                        new OrderItem("Мышь", 1, BigDecimal.valueOf(300)),
                        new OrderItem("Коврик", 1, BigDecimal.valueOf(200))));

        Order order3 = new Order(3L, 2L, BigDecimal.valueOf(750), "USD",
                List.of(new OrderItem("Клавиатура", 1, BigDecimal.valueOf(750))));

        userOrders.put(1L, Arrays.asList(order1, order2));
        userOrders.put(2L, List.of(order3));
    }

    @GetMapping("/by-user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return userOrders.getOrDefault(userId, List.of());
    }
}
