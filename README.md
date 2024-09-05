# Order - MealMate

## Overview

The **Order** service is a key microservice in the **MealMate** project, responsible for managing the ordering functionality. This service allows users to place and manage food orders. It is developed using the Spring Boot framework and follows a microservices architecture.

## Features

- **Place Orders**: Users can place new food orders.
- **Order Management**: Users can view, update, and cancel their orders.
- **Spring Boot**: Built using the Spring Boot framework for enterprise-level scalability and reliability.
- **MongoDB**: Stores order data in a MongoDB database.
- **Eureka Integration**: Service discovery using Eureka Server.

## Prerequisites

- **JDK 17** or higher
- **Maven**
- **MongoDB**
- **Eureka Service** (for service discovery)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Emon-Khan/Order-MealMate.git
```


### 2. Navigate to the Project Directory

   ```bash
   cd Order-MealMate
   ```

### 3. Configure the Database

Update the application.properties file with your MongoDB connection details:

   ```bash
   spring.data.mongodb.uri=mongodb://localhost:27017/order_mealmate
   ```


### 4. Build the Project

   ```bash
   mvn clean install
   ```

### 5. Run the application
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
### Place a New Order
- URL: /api/order/orders
- Method: POST
- Description: Creates a new order.
- Request Body: JSON object with order details.
- Response: JSON object of the newly created order.


   ```bash
   {
    "foodItemList": [
        {
            "id": 52,
            "itemName": "Chicken Curry",
            "itemDescription": "Spicy chicken curry flavoured with variety of desi spices & herbs.",
            "isVeg": false,
            "price": 135,
            "restaurantId": 1,
            "quantity": 1
        }
    ],
    "userId": 1,
    "restaurant": {
        "id": 2,
        "address": "House 85, Road 25/a, Block A, Banani",
        "city": "Dhaka",
        "name": "Test Data 2",
        "restaurantDescription": "This restaurant is well known for their indian and western food items!!!"
    }
   }
   ```


### Screenshots
![image](https://github.com/user-attachments/assets/4f24d810-5d38-4d1d-a910-236adf1437af)






