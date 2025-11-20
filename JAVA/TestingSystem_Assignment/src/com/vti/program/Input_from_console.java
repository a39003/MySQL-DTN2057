package com.vti.program;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Input_from_console {
	public static void main(String[] args) {
		// Question1();
		// Question2();
		// Question3();
		// Question4();
		// Question5();
		// Question6();
		// Question7();
		// Question8();
		Question9();
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
		acounts.FullName = scanner.next().trim();
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

	public static void Question6() {
		// Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
		Scanner scanner = new Scanner(System.in);
		Department departments = new Department();
		System.out.println("Tạo mới Department");
		System.out.print("Nhập ID: ");
		departments.ID = scanner.nextInt();
		System.out.print("Nhập name: ");
		departments.name = scanner.next();

		System.out.println(
				"Thông tin Department mới tạo" + "\n" + "ID: " + departments.ID + "\n" + "Name: " + departments.name);
	}

	public static void Question7() {
		// Question 7: Nhập số chẵn từ console
		Scanner scanner = new Scanner(System.in);

		System.out.print("Mời nhập số chẵn: ");
		int a = scanner.nextInt();
		if (a % 2 == 0) {
			System.out.println("Đây là số chắn: " + a);
		} else {
			System.out.println("Đây không phải số chẵn");
		}
	}

	public static void Question8() {
		/*
		 * Question 8: Viết chương trình thực hiện theo flow sau: Bước 1: Chương trình
		 * in ra text "mời bạn nhập vào chức năng muốn sử dụng" Bước 2: Nếu người dùng
		 * nhập vào 1 thì sẽ thực hiện tạo account Nếu người dùng nhập vào 2 thì sẽ thực
		 * hiện chức năng tạo department Nếu người dùng nhập vào số khác thì in ra text
		 * "Mời bạn nhập lại" và quay trở lại bước 1
		 */

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Mời bạn chọn chức năng: 1.Tạo account, 2.Tạo department:");
			int b = scanner.nextInt();
			if (b == 1 || b == 2) {
				switch (b) {
				case 1: {
					Question5();
					break;
				}
				case 2: {
					Question6();
					break;
				}
				}
				return;
			} else {
				System.out.println("Nhập lại: ");
			}
		}

	}

	public static void Question9() {

		// Question 9: Viết method cho phép người dùng thêm group vào account theo flow
		// sau:

		Scanner scanner = new Scanner(System.in);
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

		// ====== Group ======
		Group group1 = new Group();
		group1.ID = 1;
		group1.name = "MySQL";
		group1.CreateDate = LocalDate.now();

		Group group2 = new Group();
		group2.ID = 2;
		group2.name = "Java";
		group2.CreateDate = LocalDate.now();

		Group group3 = new Group();
		group3.ID = 3;
		group3.name = "JavCore";
		group3.CreateDate = LocalDate.now();

		Group[] groups = { group1, group2, group3 };

		// Bước 1: In ra tên các usernames của user cho người dùng xem
		System.out.println("Danh sách các user có trong danh sách: ");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].Username);
		}
//Bước 2: Yêu cầu người dùng nhập vào username của account
		System.out.print(" Nhập tên user có trong account: ");
		String name = scanner.next();
// Bước 3: In ra tên các group cho người dùng xem Bước
		System.out.println("Danh sách các group có trong danh sách: ");
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i].name);
		}
//4: Yêu cầu người dùng nhập vào tên của group
		System.out.print(" Nhập tên user có trong account: ");
		String namegroup = scanner.next();

		// Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm
		// account vào group đó .
	}

}
