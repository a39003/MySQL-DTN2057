package com.vti.entity;

public abstract class User {
	private String name;
	private double salatyratio;

	public User() {

	}

	public User(String name, double salatyratio) {
		this.name = name;
		this.salatyratio = salatyratio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalatyratio() {
		return salatyratio;
	}

	public void setSalatyratio(double salatyratio) {
		this.salatyratio = salatyratio;
	}

	public abstract double calculatePay();

	public void displayInfor() {
		System.out.println("Tên: " + name);
		System.out.println("Hệ số lương: " + salatyratio);
		System.out.println("Thu nhập: " + calculatePay());
		System.out.println("-----------------------------");
	}

}
