package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Account {
	public static int countacou;
	private int ID;
	private String Email;
	private String Username;
	private String FullName;

	@Override
	public String toString() {
		return "Account [ID=" + ID + ", Email=" + Email + ", Username=" + Username + ", FullName=" + FullName + "]";
	}

	public Account(int iD, String email, String username, String fullName) {
		super();
		countacou++;
		this.ID = countacou;
		this.Email = email;
		this.Username = username;
		this.FullName = fullName;
	}

	public Account() {
		System.out.println("Nhập thông tin account");
		countacou++;
		this.ID = countacou;

		System.out.println("Nhập email: ");
		this.Email = ScannerUtils.inputString();
		System.out.print("Nhập userName: ");
		this.Username = ScannerUtils.inputString();
		System.out.print("Nhập fullName: ");
		this.FullName = ScannerUtils.inputString();
	}

}
