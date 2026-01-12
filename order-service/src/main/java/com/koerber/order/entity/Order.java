package com.koerber.order.entity;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="orders")
public class Order {
 @Id @GeneratedValue
 public Long orderId;
 public Long productId;
 public Integer quantity;
 public String status;
 public LocalDate orderDate;
}