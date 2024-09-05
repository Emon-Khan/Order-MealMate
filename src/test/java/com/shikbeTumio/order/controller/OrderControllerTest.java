package com.shikbeTumio.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbeTumio.order.dto.FoodItem;
import com.shikbeTumio.order.dto.OrderDTO;
import com.shikbeTumio.order.dto.OrderRequestDTO;
import com.shikbeTumio.order.dto.Restaurant;
import com.shikbeTumio.order.dto.User;
import com.shikbeTumio.order.service.OrderService;

public class OrderControllerTest {
	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateOrders() {
		List<FoodItem> mockFoodItems = Arrays.asList(
				new FoodItem(1, "Pizza", "Delicious cheese pizza", true, 9.99, 101, 2),
				new FoodItem(2, "Burger", "Juicy beef burger", false, 7.99, 101, 1));
		Restaurant mockRestaurant = new Restaurant(101, "Gourmet Paradise", "123 Main St", "Food City",
				"The best gourmet food in town");
		Integer mockUserId = 1;
		Integer mockOrderId = 1;
		User mockUser = new User(mockUserId, "john_doe", "securePass123", "456 Elm Street", "Metropolis");
		OrderRequestDTO mockOrderRequestDTO = new OrderRequestDTO(mockFoodItems, mockUserId, mockRestaurant);
		OrderDTO mockOrderDTO = new OrderDTO(mockOrderId, mockFoodItems, mockRestaurant, mockUser);
		when(orderService.createOrders(mockOrderRequestDTO)).thenReturn(mockOrderDTO);

		ResponseEntity<OrderDTO> response = orderController.createOrders(mockOrderRequestDTO);

		verify(orderService, times(1)).createOrders(mockOrderRequestDTO);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockOrderDTO, response.getBody());

	}

}
