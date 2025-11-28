package Frondend;

import java.util.Scanner;

import com.vti.entity.VietnamesePhone;

public class Exercise5_Question6 {
	public static void main(String[] args) {
		VietnamesePhone phone = new VietnamesePhone();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("------ MENU ------");
			System.out.println("1. Thêm contact");
			System.out.println("2. Xóa contact");
			System.out.println("3. Cập nhật số điện thoại");
			System.out.println("4. Tìm kiếm contact");
			System.out.println("5. In danh sách contact");
			System.out.println("0. Thoát");
			System.out.print("Chọn chức năng: ");

			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1: {
				System.out.print("Nhập tên: ");
				String nameAdd = sc.nextLine();
				System.out.print("Nhập số điện thoại: ");
				String phoneAdd = sc.nextLine();
				phone.insertContact(nameAdd, phoneAdd);
				break;
			}
			case 2: {
				System.out.print("Nhập tên cần xóa: ");
				String nameRemove = sc.nextLine();
				phone.removeContact(nameRemove);
				break;
			}
			case 3: {
				System.out.print("Nhập tên cần cập nhật: ");
				String nameUpdate = sc.nextLine();
				System.out.print("Nhập số mới: ");
				String newPhone = sc.nextLine();
				phone.updateContact(nameUpdate, newPhone);
				break;
			}
			case 4: {
				System.out.print("Nhập tên cần tìm: ");
				String nameSearch = sc.nextLine();
				phone.searchContact(nameSearch);
				break;
			}
			case 5: {
				phone.printAll();
				break;
			}
			case 0:
				System.out.println("Thoát chương trình...");
				return;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
	}
}
