package com.koerber.inventory.dto;
import java.util.List;
public class InventoryResponse {
 public Long productId;
 public String productName;
 public List<InventoryBatchDto> batches;
}