package com.koerber.inventory.service;
import com.koerber.inventory.repository.InventoryRepository;
import com.koerber.inventory.factory.InventoryHandlerFactory;
import com.koerber.inventory.entity.InventoryBatch;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class InventoryService {
   private final InventoryRepository repo;
   private final InventoryHandlerFactory factory;
   public InventoryService(InventoryRepository r,InventoryHandlerFactory f){
    repo=r; factory=f;
   }
   public List<InventoryBatch> get(Long productId){
    return repo.findByProductIdOrderByExpiryDateAsc(productId);
   }
   public void update(Long productId,int qty){
    factory.get().reserve(productId,qty);
   }
}