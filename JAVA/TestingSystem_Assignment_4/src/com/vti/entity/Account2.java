package com.vti.entity;

public class Account2 {
	private String id;
	private String name;
	private int balance;

	public Account2() {

	}

	public Account2(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public void credit(int amount) {
		balance += amount;
	}

	public void debit(int amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			System.out.println("Số dư không đủ!");
		}
	}

	public void tranfer(Account2 account2, int amount) {
		if (amount <= balance) {
			this.balance -= amount;
			account2.balance += amount;
		} else {
			System.out.println("Số dư không đủ để chuyển khoản!");
		}
	}

}
