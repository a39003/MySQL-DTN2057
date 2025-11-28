package com.vti.frondend;

import java.util.Scanner;

import com.vti.backend.TuyenSinh;

public class Demo_Exercise1_Question2 {
	public static void main(String[] args) {
		TuyenSinh tuyenSinh = new TuyenSinh();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== MENU TUYỂN SINH =====");
			System.out.println("1. Thêm thí sinh");
			System.out.println("2. Hiển thị thông tin thí sinh");
			System.out.println("3. Tìm kiếm theo số báo danh");
			System.out.println("4. Thoát");
			System.out.print("Lựa chọn: ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1 -> tuyenSinh.addThiSinh();
			case 2 -> tuyenSinh.displayThiSinh();
			case 3 -> tuyenSinh.searchBySBD();
			case 4 -> {
				System.out.println("Thoát chương trình...");
				return;
			}
			default -> System.out.println("Lựa chọn sai!");
			}
		}
	}
}
