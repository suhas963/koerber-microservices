package com.koerber.order.service;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class InventoryClient {
 private final RestTemplate rest;
 public InventoryClient(RestTemplate r){rest=r;}
 public void reserve(Long productId,int qty){
  rest.postForObject("http://localhost:8081/inventory/update",
   new Req(productId,qty),Void.class);
 }
 static class Req{public Long productId; public int quantity;
  Req(Long p,int q){productId=p;quantity=q;}}
}