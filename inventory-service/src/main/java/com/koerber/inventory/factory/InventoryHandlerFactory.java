package com.koerber.inventory.factory;
import org.springframework.stereotype.Component;
import java.util.Map;
@Component
public class InventoryHandlerFactory {
 private final Map<String,InventoryHandler> handlers;
 public InventoryHandlerFactory(Map<String,InventoryHandler> h){handlers=h;}
 public InventoryHandler get(){return handlers.get("DEFAULT");}
}