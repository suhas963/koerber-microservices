# Korber Java Microservices Assignment

## Services
- inventory-service (8081)
- order-service (8082)

## Tech Stack
- Java 8
- Spring Boot 2.7.x
- H2 Database
- Liquibase
- JUnit 5, Mockito

## How to Run
1. Install Maven dependencies in both inventory-service and order-service
2. Start inventory-service
3. Start order-service

## Steps
1. Check inventory for product 1001 by using endpoint GET - http://localhost:8081/inventory/1001
- Expected Response
{
   "productId": 1001,
   "productName": "Laptop",
   "batches": [
       { "batchId": 1, "quantity": 68, "expiryDate": "2026-06-25" },
       { "batchId": 2, "quantity": 30, "expiryDate": "2026-09-01" }
   ]
}
2. Reserve (reduce stock) using update endpoint POST - http://localhost:8081/inventory/update
- Body = {"productId":1001,"quantity":5}

3. Now check again http://localhost:8081/inventory/1001
- Expected Response
  {
  "productId": 1001,
  "productName": "Laptop",
  "batches": [
      { "batchId": 1, "quantity": 63, "expiryDate": "2026-06-25" },
      { "batchId": 2, "quantity": 30, "expiryDate": "2026-09-01" }
  ]
}
4. Place an order (this will call inventory-service internally) using endpoint POST - http://localhost:8082/order
- Body = {"productId":1001,"quantity":2}
  - Expected Response 
  {
    "orderId": 1,
    "productId": 1001,
    "quantity": 2,
    "status": "PLACED",
    "orderDate": "2026-01-12"
  }
5. Then verify inventory reduced using endpoint http://localhost:8081/inventory/1001
- Expected Response
  {
      "productId": 1001,
      "productName": "Laptop",
      "batches": [
          { "batchId": 1, "quantity": 61, "expiryDate": "2026-06-25" },
          { "batchId": 2, "quantity": 30, "expiryDate": "2026-09-01" }
      ]
  }
6. View Inventory DB in browser (H2 Console) using URL http://localhost:8081/h2-console
#### Use:
- JDBC URL: jdbc:h2:mem:inventorydb
- User: sa
- Password: (blank)
- Run: select * from inventory_batch;


