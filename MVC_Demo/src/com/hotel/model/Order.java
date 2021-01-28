package com.hotel.model;

public class Order {

	private Integer itemId;
	private String itemName;
	private String orderStatus;
	
	
	public Order() {
		super();
	}
	
	public Order(Integer itemId, String itemName, String orderStatus) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.orderStatus = orderStatus;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
