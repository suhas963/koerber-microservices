package com.koerber.order.controller;
import com.koerber.order.service.OrderService;
import com.koerber.order.entity.Order;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/order")
public class OrderController {
 private final OrderService service;
 public OrderController(OrderService s){service=s;}
 @PostMapping
 public Order place(@RequestBody Req r){
  return service.place(r.productId,r.quantity);
 }
 static class Req{public Long productId; public int quantity;}
}