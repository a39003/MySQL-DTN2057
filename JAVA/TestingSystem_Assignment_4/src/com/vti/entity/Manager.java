package com.vti.entity;

public class Manager extends User {
	public Manager(String name, double salatyratio) {
		super(name, salatyratio);
	}

	@Override
	public double calculatePay() {
		return getSalatyratio() * 520;
	}
}
