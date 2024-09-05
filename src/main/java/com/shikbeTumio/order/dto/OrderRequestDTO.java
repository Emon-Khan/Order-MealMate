package com.shikbeTumio.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

	private List<FoodItem> foodItemsList;
	private Integer userId;
	private Restaurant restaurant;

}
