package com.vti.backend;

import java.util.Scanner;

public class demo1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Mời Bạn Nhập thông tin");
		System.out.println("Mời bạn nhập tên: ");
		String name = scanner.nextLine();

		System.out.println("Mời bạn nhập tuổi: ");
		int age = scanner.nextInt();

		System.out.printf("Tên tôi là %s, năm nay %d tuổi", name, age);

		scanner.close();
	}
}
