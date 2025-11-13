package com.vti.backend;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		/*
		 * System.out.println("Hello VTI"); int a = 10; int b = 20; Gender gender =
		 * Gender.MALE; int restls = a + b; System.out.println("Tổng hai số: " + restls
		 * + gender);
		 * 
		 * String[] DTN_name = { "Đức Anh", "Minh", "linh", "Huyền" };
		 * 
		 * System.out.println("Tên: " + DTN_name[0]);
		 * 
		 * student Student1 = new student();
		 * 
		 * }
		 * 
		 * public enum Gender { MALE, FEMALE }
		 * 
		 */
		int x = 10;
		if (x % 2 == 0) {
			System.out.print("Số thực");
		} else {
			System.out.print("không phải số thực");
		}

		// Tìm số lớn nhất
		int a = 10;
		int b = 20;
		// int max = (a > b) ? a:b;
		if (a > b) {
			System.out.println("Max: " + a);
		} else {
			System.out.println("Max: " + b);
		}

		// Người dùng nhập 1-7 in ra 1: cn, 2: thứ 2, ....

		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập một số từ 1-7: ");
		int day = sc.nextInt();

//		if (day == 1) {
//			System.out.print("Chủ Nhật");
//		} else if (day == 2) {
//			System.out.print("thứ 2");
//		} else if (day == 3) {
//			System.out.print("thứ 3");
//		} else if (day == 4) {
//			System.out.print("thứ 4");
//		} else if (day == 5) {
//			System.out.print("thứ 5");
//		} else if (day == 6) {
//			System.out.print("thứ 6");
//		} else if (day == 6) {
//			System.out.print("thứ 7");
//		} else {
//			System.out.print("Không đúng dữ liệu");
//		}
		switch (day) {
		case 1: {

			System.out.println("Chủ Nhật");
			break;
		}
		case 2: {

			System.out.println("thứ 2");
			break;
		}
		case 3: {

			System.out.println("thứ 3");
			break;
		}
		case 4: {

			System.out.println("thứ 4");
			break;
		}
		case 5: {

			System.out.println("thứ 5");
			break;
		}
		case 6: {

			System.out.println("thứ 6");
			break;
		}
		case 7: {

			System.out.println("thứ 7");
			break;
		}
		default:
			System.out.println("Không đúng dữ liệu");
			break;
		}

		int[] numbers = { 2, 5, 6, 7, 5, 6, 7, 4 };

		for (int i = 0; i <= numbers.length - 1; i++) {
			System.out.println(numbers[i]);
		}

	}
}
