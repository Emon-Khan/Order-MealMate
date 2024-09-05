package com.shikbeTumio.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private Double price;
	private Integer restaurantId;
	private Integer quantity;

}
