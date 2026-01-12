package com.koerber.inventory.controller;
import com.koerber.inventory.service.InventoryService;
import com.koerber.inventory.entity.InventoryBatch;
import com.koerber.inventory.dto.*;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/inventory")
public class InventoryController {
 private final InventoryService service;
 public InventoryController(InventoryService s){service=s;}
 @GetMapping("/{productId}")
 public InventoryResponse get(@PathVariable Long productId){
   java.util.List<com.koerber.inventory.entity.InventoryBatch> batches = service.get(productId);
   InventoryResponse r=new InventoryResponse();
   r.productId=productId;
   r.productName=batches.get(0).getProductName();
   r.batches=batches.stream().map(b->{
    InventoryBatchDto d=new InventoryBatchDto();
    d.batchId=b.getBatchId();
    d.quantity=b.getQuantity();
    d.expiryDate=b.getExpiryDate();
    return d;
   }).collect(Collectors.toList());
   return r;
 }
 @PostMapping("/update")
 public void update(@RequestBody UpdateReq r){
  service.update(r.productId,r.quantity);
 }
 static class UpdateReq{public Long productId; public int quantity;}
}