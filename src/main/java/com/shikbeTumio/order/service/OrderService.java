package com.shikbeTumio.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shikbeTumio.order.dto.OrderDTO;
import com.shikbeTumio.order.dto.OrderRequestDTO;
import com.shikbeTumio.order.dto.User;
import com.shikbeTumio.order.entity.Order;
import com.shikbeTumio.order.mapper.OrderMapper;
import com.shikbeTumio.order.repo.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;

	@Autowired
	SequenceGenerator sequenceGenerator;

	@Autowired
	RestTemplate restTemplate;

	public OrderDTO createOrders(OrderRequestDTO orderRequestDTO) {
		Integer orderId = sequenceGenerator.generateNextOrderId();
		User user = fetchUserDetailFromUserId(orderRequestDTO.getUserId());

		Order newOrder = new Order(orderId, orderRequestDTO.getFoodItemsList(), orderRequestDTO.getRestaurant(), user);
		Order savedOrder = orderRepo.save(newOrder);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(savedOrder);
	}

	private User fetchUserDetailFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/users/" + userId, User.class);
	}

}
