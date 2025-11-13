package com.vti.program;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Program {
	public static void main(String[] args) {
		// Testingsystem1
		// ====== Department ======
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

		System.out.println("1 Department: " + departments[0].name);
		System.out.println("2 Position: " + positions[0].name);
		System.out.println("3 Account: " + accounts[2].Email + " " + accounts[2].FullName + " - Department: "
				+ accounts[2].departemnt.name + " - Position: " + accounts[2].position.name + " "
				+ accounts[2].CreateDate);
		System.out.println("4 Group: " + groups[0].name + " - Creator: " + groups[0].creator.FullName + " "
				+ groups[0].CreateDate);
		System.out.println(account1.group[1].name);
		// ----- testingsystem2---------
		/*
		 * Question 1: Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department
		 * == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" Nếu không thì sẽ
		 * in ra text "Phòng ban của nhân viên này là ..."
		 */
		System.out.println("-----Question1-----------");
		if (accounts[1].departemnt == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này: " + accounts[1].departemnt.name);
		}

		/*
		 * Question 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
		 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
		 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
		 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
		 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
		 * người hóng chuyện, tham gia tất cả các group"
		 */
		System.out.println("-----Question2-----------");
		if (accounts[1].group == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			int countGroup = accounts[1].group.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			} else if (countGroup == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			} else if (countGroup == 4) {
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			}
		}

		// Question 3: Sử dụng toán tử ternary để làm Question 1
		System.out.println("-----Question3-----------");
		System.out.println(
				(accounts[1].departemnt == null) ? "Chưa có phòng ban " : "Phòng ban: " + accounts[1].departemnt.name);

		/*
		 * Question 4: Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của
		 * account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không
		 * phải thì in ra text "Người này không phải là Developer"
		 */
		System.out.println("-----Question4-----------");
		System.out.println(
				(accounts[0].position.name == PositionName.Dev) ? "Đây là Developer" : "Đây không phải là Developer");

		/*
		 * Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format
		 * sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng
		 * account = 2 thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì
		 * in ra "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
		 */
		System.out.println("-----Question5-----------");
		int soluongacc = groups[0].account.length;
		if (soluongacc == 1) {
			System.out.println("Nhóm có một thành viên");
		} else if (soluongacc == 2) {
			System.out.println("Nhóm có hai thành viên");
		} else if (soluongacc == 3) {
			System.out.println("Nhóm có ba thành viên");
		}

		// Question 6: Sử dụng switch case để làm lại Question 2
		System.out.println("-----Question6-----------");
		int soluongnv = accounts[1].group.length;

		switch (soluongnv) {
		case 0: {

			System.out.println("Nhân viên này chưa có group");
			break;
		}
		case 1:
		case 2: {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		}
		case 3: {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		}
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}

		// Question 7: Sử dụng switch case để làm lại Question 4
		System.out.println("-----Question7-----------");
		switch (accounts[0].position.name) {
		case Dev: {
			System.out.println("Đây là Developer");
			break;
		}
		default:
			System.out.println("Đây không phải là Developer");
			break;
		}

		// Question 8:In ra thông tin các account bao gồm: Email, FullName và tên phòng
		// ban của họ
		System.out.println("-----Question8-----------");
		for (Account account : accounts) {
			System.out.println(
					"ID: " + account.ID + " " + "Email: " + account.Email + " " + "FullName: " + account.FullName);
		}

		// Question 9: In ra thông tin các phòng ban bao gồm: id và name
		System.out.println("-----Question9-----------");
		for (Department department : departments) {
			System.out.println("ID: " + department.ID + " " + "Name: " + department.name);
		}
		/*
		 * Question 10: In ra thông tin các account bao gồm: Email, FullName và tên
		 * phòng ban của họ theo định dạng như sau: Thông tin account thứ 1 là: Email:
		 * NguyenVanA@gmail.com Full name: Nguyễn Văn A Phòng ban: Sale Thông tin
		 * account thứ 2 là: Email: NguyenVanB@gmail.com Full name: Nguyễn Văn B Phòng
		 * ban: Marketting
		 */
		System.out.println("-----Question10-----------");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("--------------------------------------");
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].Email);
			System.out.println("FullName: " + accounts[i].FullName);
			System.out.println("Phòng ban: " + accounts[i].departemnt.name);
		}

		/*
		 * Question 11: In ra thông tin các phòng ban bao gồm: id và name theo định dạng
		 * sau: Thông tin department thứ 1 là: Id: 1 Name: Sale Thông tin department thứ
		 * 2 là: Id: 2 Name: Marketing
		 */
		System.out.println("-----Question11-----------");
		for (int i = 0; i < departments.length; i++) {
			System.out.println("------------------------");
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("ID: " + departments[i].ID);
			System.out.println("Name: " + departments[i].name);
		}

		// Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như
		// Question 10
		System.out.println("-----Question12-----------");
		for (int i = 0; i < 2; i++) {
			System.out.println("------------------------");
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("ID: " + departments[i].ID);
			System.out.println("Name: " + departments[i].name);
		}

		// Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
		System.out.println("-----Question13-----------");
		for (int i = 0; i < accounts.length; i++) {
			if (i != 1) {
				System.out.println("--------------------------------------");
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].Email);
				System.out.println("FullName: " + accounts[i].FullName);
				System.out.println("Phòng ban: " + accounts[i].departemnt.name);
			}
		}

		// Question 14: In ra thông tin tất cả các account có id < 4

		System.out.println("-----Question14-----------");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].ID < 4) {
				System.out.println("--------------------------------------");
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].Email);
				System.out.println("FullName: " + accounts[i].FullName);
				System.out.println("Phòng ban: " + accounts[i].departemnt.name);
			}
		}

		// Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
		System.out.println("-----Question15-----------");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println("Số chắn nhỏ hơn hoặc bằng 20: " + i + " ");
			}

		}
	}
}
