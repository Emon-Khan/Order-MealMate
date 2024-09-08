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

## Docker Instructions

If you prefer using Docker for this service, you can pull and run the Order-MealMate image directly from Docker Hub.

### Pulling the Image from Docker Hub

1. To pull the image, use the following command:
    ```bash
    docker pull rkemon94/order-service:latest
    ```

### Running the Order Service with Docker

2. Run the Order service in a Docker container:
    ```bash
    docker run --name order-service-container -p 9093:9093 rkemon94/order-service:latest
    ```

3. Access the service:

   After running the container, you can access the API on http://localhost:9093.

### Stopping and Removing the Container

- To stop the running container:
    ```bash
    docker stop order-service-container
    ```

- To remove the container after stopping it:
    ```bash
    docker rm order-service-container
    ```

## Conclusion

The Order service is responsible for managing all order-related functionalities in the MealMate microservices ecosystem. Running it via Docker provides a simplified way to deploy and test the service locally. Integrating it with Eureka ensures that it works seamlessly with other microservices within the project.




