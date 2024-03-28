package com.shopping.order.util;

public enum OrderStatus {
	PENDING("PENDING"), PROCESSING("PROCESSING"), SHIPPED("PROCESSING"), DELIVERED("DELIVERED"), CANCELLED("CANCELLED");

	String value;

	OrderStatus(String value) {
		this.value = value;
	}
	
	public String getOrderStatus() {
        return value;
    }
}
