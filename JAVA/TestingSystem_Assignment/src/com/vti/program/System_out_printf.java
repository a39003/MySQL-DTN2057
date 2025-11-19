package com.vti.program;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class System_out_printf {
	public static void main(String[] args) {

		Department departments1 = new Department();
		departments1.ID = 1;
		departments1.name = "sale";

		Department departments2 = new Department();
		departments2.ID = 2;
		departments2.name = "marketing";

		Department departments3 = new Department();
		departments3.ID = 3;
		departments3.name = "IT";

		Department[] departments = { departments1, departments2, departments3 };

		// ====== Position ======
		Position position1 = new Position();
		position1.ID = 1;
		position1.name = PositionName.Dev;

		Position position2 = new Position();
		position2.ID = 2;
		position2.name = PositionName.PM;

		Position position3 = new Position();
		position3.ID = 3;
		position3.name = PositionName.Scrum_Master;

		Position[] positions = { position1, position2, position3 };

		// ====== Account ======
		Account account1 = new Account();
		account1.ID = 1;
		account1.Email = "anh@gmail.com";
		account1.Username = "Anh";
		account1.FullName = "Nguyễn Tuấn Anh";
		account1.departemnt = departments[0];
		account1.position = positions[0];
		account1.CreateDate = LocalDate.now();

		Account account2 = new Account();
		account2.ID = 2;
		account2.Email = "tuan@gmail.com";
		account2.Username = "Tuan";
		account2.FullName = "Nguyễn Đức Tuấn";
		account2.departemnt = departments[1];
		account2.position = positions[1];
		account2.CreateDate = LocalDate.now();

		Account account3 = new Account();
		account3.ID = 3;
		account3.Email = "hieu@gmail.com";
		account3.Username = "Hiếu";
		account3.FullName = "Phạm Minh Hiếu";
		account3.departemnt = departments[2];
		account3.position = positions[2];
		account3.CreateDate = LocalDate.now();

		Account[] accounts = { account1, account2, account3 };

		// ====== Group ======
		Group group1 = new Group();
		group1.ID = 1;
		group1.name = "MySQL";
		group1.creator = accounts[0];
		group1.CreateDate = LocalDate.now();

		Group group2 = new Group();
		group2.ID = 2;
		group2.name = "Java";
		group2.creator = accounts[1];
		group2.CreateDate = LocalDate.now();

		Group group3 = new Group();
		group3.ID = 3;
		group3.name = "JavCore";
		group3.creator = accounts[2];
		group3.CreateDate = LocalDate.now();

		Group[] groups = { group1, group2, group3 };

		// add vào account
		Group[] groupsaccount1 = { group1, group2 };
		account1.group = groupsaccount1;

		Group[] groupsaccount2 = { group2 };
		account2.group = groupsaccount2;

		Group[] groupsaccount3 = { group1, group2, group3 };
		account3.group = groupsaccount3;

		// add add vào group
		groups[0].account = new Account[] { account1, account3 };
		groups[1].account = new Account[] { account2, account3 };
		groups[2].account = new Account[] { account1, account2, account3 };
//		Question 1:
//			Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//			nguyên đó
		System.out.println("-------------Question 1 ----------------------");
		int a = 5;
		System.out.printf("Số nguyên là: %d %n", a);

//		Question 2:
//			Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//			ra số nguyên đó thành định dạng như sau: 100,000,000
		System.out.println("-------------Question 2 ----------------------");

		int b = 100000000;
		System.out.printf(Locale.US, "Số nguyên: %,d  %n", b);

//		Question 3:
//			Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//			thực đó chỉ bao gồm 4 số đằng sau
		System.out.println("-------------Question 3 ----------------------");

		float c = 5.567098f;
		System.out.printf("%5.4f %n", c);

//		Question 4:
//			Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//			dạng như sau:
//			Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//			Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		System.out.println("-------------Question 4 ----------------------");

		String name = "Nguyễn Văn A";
		System.out.printf("Tên tôi là %s và tôi đang độc thân %n", name);

//			Question 5:
//			Lấy thời gian bây giờ và in ra theo định dạng sau:
//			24/04/2020 11h:16p:20s
		System.out.println("-------------Question 5 ----------------------");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
		String formatterdDate = now.format(formatter);
		System.out.println(formatterdDate);

//			Question 6:
//			In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//			table (giống trong Database)
		System.out.println("-------------Question 6 ----------------------");
		System.out.println("+----+-------------------------+----------------------+-----------------+");
		System.out.printf("| %-2s | %-23s | %-20s | %-15s |\n", "ID", "Email", "Full Name", "Department");
		System.out.println("+----+-------------------------+----------------------+-----------------+");
		for (Account account : accounts) {
			System.out.printf("| %-2d | %-23s | %-20s | %-15s |\n", account.ID, account.Email, account.FullName,
					account.departemnt == null ? "Không có" : account.departemnt.name);
		}
		System.out.println("+----+-------------------------+----------------------+-----------------+");

	}
}
