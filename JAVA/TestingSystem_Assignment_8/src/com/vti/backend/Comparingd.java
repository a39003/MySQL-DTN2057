package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.student1;
import com.vti.entity.studentSortByAll;
import com.vti.utils.ScannerUtils;

public class Comparingd {
	public static void Question1_2() {
		int choice;
		List<student1> student1s = new ArrayList<student1>();
		while (true) {
			System.out.println("------Menu-------");
			System.out.println("1.Nhập thông tin sinh viên");
			System.out.println("2.In danh sách sắp xếp theo name");
			System.out.println("3. In danh sách name,ngày sinh, điểm");
			System.out.print("chọn: ");
			choice = ScannerUtils.intputIntPositve();

			switch (choice) {
			case 1:
				System.out.print("Nhập số lượng sinh viên: ");
				int n = ScannerUtils.intputIntPositve();
				for (int i = 0; i < n; i++) {
					System.out.println("Nhập tên sinh viên " + (i + 1) + ": ");
					String namString = ScannerUtils.inputString();
					System.out.println("Nhập điểm số: ");
					Double point = ScannerUtils.inputDouble("Không được bỏ trống");
					System.out.println("Nhập ngày tháng năm sinh: ");
					LocalDate brithDate = ScannerUtils.intputLocalDate();

					student1 stud = new student1(namString, brithDate, point);
					student1s.add(stud);
				}

				System.out.println("Danh sách sinh viên");
				for (student1 st : student1s) {
					System.out.println(st);
				}
				break;
			case 2:
				System.out.println("Danh sách sắp xếp theo tên");
				Collections.sort(student1s);
				for (student1 st : student1s) {
					System.out.println(st);
				}
				break;
			case 3:
				System.out.println("Danh sách sắp xếp tên, ngày tháng sinh, điểm");
				Collections.sort(student1s, new studentSortByAll());
				for (student1 st : student1s) {
					System.out.println(st);
				}
			case 4:
				System.out.println("thoát chương trình....");
				return;
			default:
				break;
			}
		}
	}
}
