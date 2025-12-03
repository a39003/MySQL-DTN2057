package com.vti.frondend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.backend.Exceptiond;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.utils.ScannerUtils;

public class Exercise2 {
	private static Exceptiond exceptiond = new Exceptiond();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Question1_2();
		// Question3();
		// Question4();
		// Question5_6();
		// Question7();
		// Question8();
		// Questin9();
		Question10();

	}

	public static void Question1_2() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập số thứ 1: ");
		int a = scanner.nextInt();
		System.out.print("Mời bạn nhập số thứ 2: ");
		int b = scanner.nextInt();
		try {
			System.out.println("Kết quả là: " + exceptiond.divide(a, b));
		} catch (Exception e) {
			System.out.println("cannot divide 0");
		} finally {
			System.out.println("divide completed!");
		}
	}

	public static void Question3() {
		int[] numbers = { 1, 2, 3 };

		try {
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.out.println("Lỗi rồi ");
		}

	}

	public static void Question4() {
		Department department1 = new Department(1, "Jvav");
		Department department2 = new Department(2, "MySQL");
		Department department3 = new Department(3, "Core");

		Department[] departments = { department1, department2, department3 };

		try {
			System.out.println(departments[4]);
		} catch (Exception e) {
			System.out.println("Cannot find department.");
		}

	}

	public static int Question5_6() {

		while (true) {
			System.out.print("Mời bạn nhập tuổi: ");
			String iput = scanner.nextLine();
			try {
				int age = Integer.parseInt(iput);
				if (age > 0) {
					System.out.println(age);
					return age;
				} else {
					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				}
			} catch (Exception e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}

		}
	}

	public static void Question7() {
		int id = ScannerUtils.inputInt("ID phải là số! Nhập lại:");
		System.out.println("ID của bạn là: " + id);
	}

	public static void Question8() {
		while (true) {
			System.out.println("\n======== MENU ========");
			System.out.println("1. Nhập int");
			System.out.println("2. Nhập float");
			System.out.println("3. Nhập double");
			System.out.println("4. Nhập String");
			System.out.println("5. Thoát");
			System.out.print("Chọn: ");
			int choose = scanner.nextInt();

			switch (choose) {
			case 1:
				int id = ScannerUtils.inputInt("ID phải là số!");
				System.out.println("ID của bạn là: " + id);
				break;
			case 2:
				Float id1 = ScannerUtils.inputFloat("ID phải là số! Nhập lại:");
				System.out.println("ID của bạn là: " + id1);
				break;
			case 3:
				Double id2 = ScannerUtils.inputDouble("ID phải là số! Nhập lại:");
				System.out.println("ID của bạn là: " + id2);
				break;
			case 4:
				String name = ScannerUtils.inputString();
				System.out.println("Chuỗi của bạn là: " + name);
				break;
			case 5:
				System.out.println("Thoát khỏi chương trình.....");
				return;
			default:
				System.out.println("Nhập theo đúng menu");
				break;
			}
		}

	}

	public static void Questin9() {
		while (true) {
			System.out.println("\n======== MENU ========");
			System.out.println("1. Tạo Position");
			System.out.println("2. Tạo Department");
			System.out.println("3. Thoát");
			System.out.print("Chọn: ");

			int choce = scanner.nextInt();

			switch (choce) {
			case 1:
				System.out.println("Tạo Position");
				Position pos1 = new Position();
				System.out.println("Thông tin Position vừa nhập: ");
				System.out.println(pos1);
				break;
			case 2:
				Department dep1 = new Department();
				Department dep2 = new Department();
				Department dep3 = new Department();
				ArrayList<Department> listDep = new ArrayList<Department>();
				listDep.add(dep1);
				listDep.add(dep2);
				listDep.add(dep3);
				System.out.println("Thông tin phòng vừa nhập: ");
				for (Department department : listDep) {
					System.out.println(department);
				}
				break;
			case 3:
				System.out.println("thoát chương trình....");
				return;
			default:
				System.out.println("chọn đúng menu");
				break;
			}
		}

	}

	private static void Question10() {
		System.out.println("Tạo group");
		Group group = new Group();
		group.printGroup();
	}

}
