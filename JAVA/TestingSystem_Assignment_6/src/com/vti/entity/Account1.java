package com.vti.entity;

import com.vti.backend.InvalidAgeInputingException;
import com.vti.utils.ScannerUtils;

public class Account1 {
	public static int countacou1;
	private int ID;
	private String Email;
	private String Username;
	private String FullName;
	private int age;

	@Override
	public String toString() {
		return "Account1 [ID=" + ID + ", Email=" + Email + ", Username=" + Username + ", FullName=" + FullName
				+ ", age=" + age + "]";
	}

	public Account1(int iD, String email, String username, String fullName, int age) {
		super();
		countacou1++;
		this.ID = countacou1;
		this.Email = email;
		this.Username = username;
		this.FullName = fullName;
		this.age = age;
	}

	public Account1() throws InvalidAgeInputingException {
		super();
		System.out.println("Mời bạn nhập thông tin account mới");
		countacou1++;

		this.ID = countacou1;
		System.out.print("Email: ");
		this.Email = ScannerUtils.inputString();
		System.out.print("UserName: ");
		this.Username = ScannerUtils.inputString();
		System.out.print("FullName: ");
		this.FullName = ScannerUtils.inputString();
		this.age = inputAcoountAge();
	}

	private int inputAcoountAge() throws InvalidAgeInputingException {
		System.out.print("Mời bạn nhạp age: ");
		while (true) {
			try {
				int ageinput = ScannerUtils.intputAge();
				if (ageinput < 18) {
					System.out.println("Your age must be greater than 18");
					continue;
				}
				return ageinput;
			} catch (InvalidAgeInputingException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
