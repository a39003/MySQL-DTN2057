package com.vti.program;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Method {
	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
	}

	public static void Question1() {
		// Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("Số chẵn nhỏ hơn 10: " + i);
			}
		}
	}

	public static void Question2() {
		// Question 2: Tạo method để in thông tin các account

		// ====== Account ======
		Account account1 = new Account();
		account1.ID = 1;
		account1.Email = "anh@gmail.com";
		account1.Username = "Anh";
		account1.FullName = "Nguyễn Tuấn Anh";
		account1.CreateDate = LocalDate.now();

		Account account2 = new Account();
		account2.ID = 2;
		account2.Email = "tuan@gmail.com";
		account2.Username = "Tuan";
		account2.FullName = "Nguyễn Đức Tuấn";
		account2.CreateDate = LocalDate.now();
		Account account3 = new Account();
		account3.ID = 3;
		account3.Email = "hieu@gmail.com";
		account3.Username = "Hiếu";
		account3.FullName = "Phạm Minh Hiếu";
		account3.CreateDate = LocalDate.now();

		Account[] accounts = { account1, account2, account3 };
		for (Account account : accounts) {
			System.out.println("ID: " + account.ID + " " + "Email: " + account.Email + " " + "FullName: "
					+ account.FullName + "CreateDate: " + account.CreateDate);
		}

	}

	public static void Question3() {
		// Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10
		for (int i = 0; i < 10; i++) {
			System.out.println("Số nguyên nhỏ hơn 10: " + i);
		}
	}
}
