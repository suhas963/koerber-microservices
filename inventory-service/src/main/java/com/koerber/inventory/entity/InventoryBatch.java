package com.koerber.inventory.entity;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="inventory_batch")
public class InventoryBatch {
 @Id
 private Long batchId;
 private Long productId;
 private String productName;
 private Integer quantity;
 private LocalDate expiryDate;
 public Long getBatchId(){return batchId;}
 public Long getProductId(){return productId;}
 public String getProductName(){return productName;}
 public Integer getQuantity(){return quantity;}
 public LocalDate getExpiryDate(){return expiryDate;}
 public void setBatchId(Long b){batchId=b;}
 public void setProductId(Long p){productId=p;}
 public void setProductName(String p){productName=p;}
 public void setQuantity(Integer q){quantity=q;}
 public void setExpiryDate(LocalDate e){expiryDate=e;}
}