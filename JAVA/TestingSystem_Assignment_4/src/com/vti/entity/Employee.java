package com.vti.entity;

public class Employee extends User {

	public Employee(String name, double salatyratio) {
		super(name, salatyratio);
	}

	@Override
	public double calculatePay() {
		return getSalatyratio() * 420;
	}
}
