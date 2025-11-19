package com.vti.program;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Input_from_console {
	public static void main(String[] args) {
		// Question1();
		// Question2();
		// Question3();
		// Question4();
		Question5();
	}

	public static void Question1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------Question 1 ----------------------");
		// Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		System.out.println("Mời bạn nhập thông tin");
		System.out.print("Mời bạn nhập số thứ nhất: ");
		int a = scanner.nextInt();
		System.out.print("Mời bạn nhập số thứ 2: ");
		int a1 = scanner.nextInt();
		System.out.print("Mời bạn nhập số thứ 3: ");
		int a2 = scanner.nextInt();

		System.out.println("Số thứ 1: " + a + "\n" + "Số thứ 2: " + a1 + "\n" + "Số thứ 3: " + a2);
		scanner.close();
	}

	public static void Question2() {
		Scanner scanner = new Scanner(System.in);
		// Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
		System.out.println("-------------Question 2 ----------------------");
		System.out.print("Mời bạn nhập số thực thứ 1: ");
		float b = scanner.nextFloat();
		System.out.print("Mời bạn nhập só thực thứ 2: ");
		float b1 = scanner.nextFloat();

		System.out.println("Số thực thứ 1: " + b + "\n" + "Số thực thứ 2: " + b1);
		scanner.close();
	}

	public static void Question3() {
		// Question 3:Viết lệnh cho phép người dùng nhập họ và tên
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------Question 3 ----------------------");
		System.out.print("Mời bạn Nhập họ và tên đệm: ");
		String name = scanner.nextLine();
		System.out.print("Mời bạn nhập tên: ");
		String name1 = scanner.nextLine();

		System.out.println("Họ và tên: " + name + " " + name1);
		scanner.close();
	}

	public static void Question4() {
		// Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------Question 4 ----------------------");
		System.out.print("Mời bạn nhập ngày sinh: ");
		int day = scanner.nextInt();
		System.out.print("Mời bạn nhập tháng sinh: ");
		int mom = scanner.nextInt();
		System.out.print("Mời bạn nhập năm sinh: ");
		int year = scanner.nextInt();

		LocalDate brithDate = LocalDate.of(year, mom, day);
		System.out.println("Ngày sinh của bạn: " + brithDate);
		scanner.close();
	}

	public static void Question5() {
		/*
		 * Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method) Đối
		 * với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ
		 * chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
		 */
		Scanner scanner = new Scanner(System.in);
		Account acounts = new Account();
		System.out.println("Mời bạn nhập thông tin");
		System.out.print("Mời bạn nhập ID: ");
		acounts.ID = scanner.nextInt();
		System.out.print("Mời bạn nhập Email: ");
		acounts.Email = scanner.next();
		System.out.print("Mời bạn nhập username: ");
		acounts.Username = scanner.next();
		System.out.print("Mời bạn nhập fullname: ");
		acounts.FullName = scanner.next();
		System.out.print("Mời bạn chọn Position 1-4( 1:Dev, 2:Test, 3:ScrumMaster, 4: PM) ");
		int posNum = scanner.nextInt();
		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.Dev;
			acounts.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.Test;
			acounts.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.Scrum_Master;
			acounts.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acounts.position = pos4;
			break;
		}
		System.out.println("Thông tin acount vừa tạo" + "\n" + "ID: " + acounts.ID + "\n" + "Email: " + acounts.Email
				+ "\n" + "UserName: " + acounts.Username + "\n" + "FullName: " + acounts.FullName + "\n" + "Postion: "
				+ acounts.position.name);
		scanner.close();
	}
}
