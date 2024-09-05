package com.shikbeTumio.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.shikbeTumio.order.dto.FoodItem;
import com.shikbeTumio.order.dto.Restaurant;
import com.shikbeTumio.order.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
	private int orderId;
	private List<FoodItem> foodItemsList;
	private Restaurant restaurant;
	private User user;

}
