package com.hotel.service;

import com.hotel.model.Order;

public class Chef {

	public Order serveTheOrder(Integer itemId) {

		switch (itemId) {
		case 1:
			return new Order(1, "veg soup", "cooked");
		case 2:
			return new Order(2, "Biryani", "cooked");
		case 3:
			return new Order(3, "kabab", "cooked");
		default:
			return new Order();
		}
	}
}
