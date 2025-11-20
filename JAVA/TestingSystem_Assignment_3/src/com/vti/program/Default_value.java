package com.vti.program;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;

public class Default_value {
	public static void main(String[] args) {
		Question1();
	}

	public static void Question1() {
		/*
		 * Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi tạo 5
		 * phần tử theo cú pháp (sử dụng vòng for để khởi tạo):  Email: "Email 1" 
		 * Username: "User name 1"  FullName: "Full name 1"  CreateDate: now
		 */
		Scanner sc = new Scanner(System.in);

		Account[] account = new Account[5];

		for (int i = 0; i < 5; i++) {
			Account acc = new Account();
			acc.Email = "Email " + i;
			acc.Username = "UserName " + i;
			acc.FullName = "FullName " + i;
			acc.CreateDate = LocalDate.now();
			account[i] = acc;
			System.out.println("Thông tin account: " + (i + 1) + "\n" + "Email: " + account[i].Email + "\n"
					+ "UserName: " + account[i].Username + "\n" + "FullName: " + account[i].FullName + "\n"
					+ "CreateDate: " + account[i].CreateDate);

		}
	}
}
