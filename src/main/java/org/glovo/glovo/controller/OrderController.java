package org.glovo.glovo.controller;

import lombok.RequiredArgsConstructor;
import org.glovo.glovo.model.Order;
import org.glovo.glovo.model.Product;
import org.glovo.glovo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        updatedOrder.setId(orderId);
        orderService.updateOrder(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping("/{orderId}/addProduct")
    public void addProductToOrder(@PathVariable Long orderId, @RequestBody Product product) {
        orderService.addProductToOrder(orderId, product);
    }

    @DeleteMapping("/{orderId}/removeProduct/{productId}")
    public void removeProductFromOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.removeProductFromOrder(orderId, productId);
    }



}
