package com.shikbeTumio.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shikbeTumio.order.dto.OrderDTO;
import com.shikbeTumio.order.dto.OrderRequestDTO;
import com.shikbeTumio.order.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<OrderDTO> createOrders(@RequestBody OrderRequestDTO orderRequestDTO) {
		OrderDTO orderAdded = orderService.createOrders(orderRequestDTO);
		return new ResponseEntity<>(orderAdded, HttpStatus.CREATED);
	}

}
