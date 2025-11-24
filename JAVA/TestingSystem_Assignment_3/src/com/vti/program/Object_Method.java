package com.vti.program;

import com.vti.entity.Department;

public class Object_Method {
	public static void main(String[] args) {
		Department[] departments = new Department[5];

		Department department1 = new Department();
		department1.ID = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.ID = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.ID = 3;
		department3.name = "Boss of director";

		Department department4 = new Department();
		department4.ID = 4;
		department4.name = "Waiting room";

		Department department5 = new Department();
		department5.ID = 5;
		department5.name = "Accounting";

		Department[] department = { department1, department2, department3, department4, department5 };

		Question1(department[0]);
		Question2(department);
		Question3(department[0]);
		Question4(department[0]);
		Question5(department[0], department[1]);
		Question6(department);
		Question7(department);

	}

	public static void Question1(Department department) {
		// In ra thông tin của phòng ban thứ 1 (sử dụng toString())
		System.out.println(department.toString());
	}

	public static void Question2(Department[] departments) {
		// In ra thông tin của tất cả phòng ban (sử dụng toString())
		for (Department department : departments) {
			System.out.println(department);
		}
	}

	public static void Question3(Department departments) {
		// Question 3: In ra địa chỉ của phòng ban thứ 1

		System.out.println(departments.hashCode());
	}

	public static void Question4(Department departments) {
		if (departments.name.equals("Phòng A")) {
			System.out.println("Có phòng tên là A");
		} else {
			System.out.println("Không có phòng tên là A");
		}
	}

	public static void Question5(Department department1, Department department2) {
//		So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//		không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
		if (department1.name.equals(department2.name)) {
			System.out.println("Hai phòng ban bằng nhau");
		} else {
			System.out.println("Không bằng nhau");
		}

	}

	public static void Question6(Department[] departments) {
		/*
		 * Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban
		 * theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD: Accounting Boss of
		 * director Marketing Sale Waiting room
		 */

		for (int i = 0; i < departments.length - 1; i++) {
			for (int j = 0; j < departments.length - 1 - i; j++) {
				if (departments[j].name.compareTo(departments[j + 1].name) > 0) {
					Department temp = departments[j];
					departments[j] = departments[j + 1];
					departments[j + 1] = temp;
				}
			}
		}

		for (Department department : departments) {
			System.out.println(department);
		}
	}

	public static void Question7(Department[] departments) {
		/*
		 * Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban
		 * được sắp xếp theo tên VD: Accounting, Boss of director, Marketing, waiting
		 * room Sale
		 */
        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = 0; j < departments.length - 1 - i; j++) {
                if (departments[j].name.compareTo(departments[j + 1].name) > 0) {
                    Department temp = departments[j];
                    departments[j] = departments[j + 1];
                    departments[j + 1] = temp;
                }
            }
        }

		System.out.println("Danh sách phòng ban sau khi sắp xếp:");
		for (int i = 0; i < departments.length; i++) {
			System.out.println(departments[i]);
		}
	}
}
