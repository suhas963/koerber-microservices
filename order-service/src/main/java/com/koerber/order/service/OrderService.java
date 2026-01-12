package com.koerber.order.service;
import com.koerber.order.repository.OrderRepository;
import com.koerber.order.entity.Order;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
@Service
public class OrderService {
 private final OrderRepository repo;
 private final InventoryClient client;
 public OrderService(OrderRepository r,InventoryClient c){
  repo=r; client=c;
 }
 public Order place(Long productId,int qty){
  client.reserve(productId,qty);
  Order o=new Order();
  o.productId=productId;
  o.quantity=qty;
  o.status="PLACED";
  o.orderDate=LocalDate.now();
  return repo.save(o);
 }
}