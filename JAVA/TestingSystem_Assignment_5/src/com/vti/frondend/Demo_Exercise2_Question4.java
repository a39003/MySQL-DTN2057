package com.vti.frondend;

import java.util.Scanner;

import com.vti.entity.MyMath;

public class Demo_Exercise2_Question4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyMath math = new MyMath();

		while (true) {
			System.out.println("---------Menu tính tổng----------");
			System.out.println("1. Tính tổng 2 số nguyên theo int");
			System.out.println("2. Tính tổng 2 số nguyên theo byte");
			System.out.println("3. Tính tổng 2 số nguyên theo float");
			System.out.println("4. Thoát");
			System.out.print("Chọn: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.print("Mời bạn nhập số thứ nhất: ");
				int a = scanner.nextInt();
				System.out.print("Mời bạn nhập số thứ hai: ");
				int b = scanner.nextInt();
				System.out.println("Tổng hai số nguyên: " + math.sum(a, b));
				break;
			case 2:
				System.out.print("Mời bạn nhập số thứ nhất: ");
				Byte a1 = scanner.nextByte();
				System.out.print("Mời bạn nhập số thứ hai: ");
				Byte b1 = scanner.nextByte();
				System.out.println("Tổng hai số nguyên: " + math.sum(a1, b1));
				break;
			case 3:
				System.out.print("Mời bạn nhập số thứ nhất: ");
				Float a2 = scanner.nextFloat();
				System.out.print("Mời bạn nhập số thứ hai: ");
				Float b2 = scanner.nextFloat();
				System.out.println("Tổng hai số nguyên: " + math.sum(a2, b2));
				break;
			case 4:
				System.out.println("Thoát khỏi chương trình........");
				return;
			default:
				System.out.println("Mời bạn chọn theo đúng menu!");
				break;
			}
		}
	}
}
