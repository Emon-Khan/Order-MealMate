package com.shikbeTumio.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
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
import org.springframework.web.client.RestTemplate;

import com.shikbeTumio.order.dto.FoodItem;
import com.shikbeTumio.order.dto.OrderDTO;
import com.shikbeTumio.order.dto.OrderRequestDTO;
import com.shikbeTumio.order.dto.Restaurant;
import com.shikbeTumio.order.dto.User;
import com.shikbeTumio.order.entity.Order;
import com.shikbeTumio.order.mapper.OrderMapper;
import com.shikbeTumio.order.repo.OrderRepo;

public class OrderServiceTest {

	@Mock
	OrderRepo orderRepo;

	@Mock
	SequenceGenerator sequenceGenerator;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
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
		Order mockSavedOrder = new Order(mockOrderId, mockFoodItems, mockRestaurant, mockUser);
		OrderDTO mockOrderDTO = OrderMapper.INSTANCE.mapOrderToOrderDTO(mockSavedOrder);
		when(sequenceGenerator.generateNextOrderId()).thenReturn(mockOrderId);
		when(restTemplate.getForObject(anyString(), eq(User.class))).thenReturn(mockUser);
		when(orderRepo.save(mockSavedOrder)).thenReturn(mockSavedOrder); //
//		when(orderService.createOrders(mockOrderRequestDTO)).thenReturn(mockOrderDTO);

		OrderDTO orderDTO = orderService.createOrders(mockOrderRequestDTO);

		verify(sequenceGenerator, times(1)).generateNextOrderId();
		verify(restTemplate, times(1)).getForObject(anyString(), eq(User.class));
		verify(orderRepo, times(1)).save(mockSavedOrder);
		assertEquals(mockOrderDTO, orderDTO);

	}

}
