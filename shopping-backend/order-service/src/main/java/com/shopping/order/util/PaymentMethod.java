package com.shopping.order.util;

public enum PaymentMethod {
	CARD("CARD"), CASH("CASH");

	String value;

	PaymentMethod(String value) {
		this.value = value;
	}

	
	public String getPaymentMethod() {
		return value;
	}
}
