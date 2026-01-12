package com.koerber.inventory.service;
import com.koerber.inventory.repository.InventoryRepository;
import com.koerber.inventory.factory.InventoryHandlerFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class InventoryServiceTest {
 @Test
 void contextLoads(){
  InventoryRepository r=Mockito.mock(InventoryRepository.class);
  InventoryHandlerFactory f=Mockito.mock(InventoryHandlerFactory.class);
  new InventoryService(r,f);
 }
}