package com.koerber.inventory.factory;
import com.koerber.inventory.repository.InventoryRepository;
import com.koerber.inventory.entity.InventoryBatch;
import org.springframework.stereotype.Component;
import java.util.List;
@Component("DEFAULT")
public class DefaultInventoryHandler implements InventoryHandler{
 private final InventoryRepository repo;
 public DefaultInventoryHandler(InventoryRepository r){repo=r;}
 public void reserve(Long productId,int qty){
  List<InventoryBatch> batches=repo.findByProductIdOrderByExpiryDateAsc(productId);
  int remaining=qty;
  for(InventoryBatch b:batches){
   if(remaining<=0) break;
   int used=Math.min(b.getQuantity(),remaining);
   b.setQuantity(b.getQuantity()-used);
   remaining-=used;
  }
  if(remaining>0) throw new RuntimeException("Insufficient inventory");
  repo.saveAll(batches);
 }
}