package com.vti.entity;

public class Waiter extends User {
	public Waiter(String name, double salatyratio) {
		super(name, salatyratio);
	}

	@Override
	public double calculatePay() {
		return getSalatyratio() * 220;
	}
}
