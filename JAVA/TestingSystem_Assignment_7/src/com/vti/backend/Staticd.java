package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

import utils.ScannerUtils;

public class Staticd {

	public static void Question1() {
		Student[] students = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên thứ " + (i + 1) + " Là: ");
			Student st = new Student();
			students[i] = st;
		}

		System.out.println("Danh sách sinh viên");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}

		System.out.println("Thông tin các sinh viên sàn đại học công nghệ: ");
		Student.collect = "Đại học công nghệ";
		System.out.println("thông tin sinh viên sau khi chuyển ");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);

		}
	}

	public static void Question2() {
		Student[] students = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên thứ " + (i + 1) + " Là: ");
			Student st = new Student();
			students[i] = st;
		}

		System.out.println("Các sinh viên nộp quý, mỗi bạn 100k: ");
		System.out.println("Tổng quý: " + (Student.moneyGroup += 300));
		System.out.println("Student thứ 1 lấy 50k đi mua bimbim, kẹo về liên hoan");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50));
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20));
		System.out.println("Student thứ 3 lấy 150k đi mau đồ dùng học tập cho nhóm ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
		System.out.println("Cả nhóm mỗi người lại đóng quý mỗi người 50k");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));

	}

	public static void Question3() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số thứ 1: ");
		int a = scanner.nextInt();
		System.out.print("Nhập số thứ 2: ");
		int b = scanner.nextInt();

		System.out.println("Max a và b: " + MyMath.max(a, b));
		System.out.println("Min a và b: " + MyMath.min(a, b));
		System.out.println("Tổng a và b: " + MyMath.sum(a, b));
	}

	public static void Question4() {
		Student student = new Student();
		System.out.println("Demo collect");
		System.out.println("Collect: " + student.getCollect());
		System.out.println("Thay đổi collect: Đại học Thăng Long");
		student.setCollect("Đại học Thăng Long");
		System.out.println("Collect mới: " + student.getCollect());
	}

	public static void Question5() {
		Student[] students = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên thứ " + (i + 1) + " Là: ");
			Student st = new Student();
			students[i] = st;
		}

		System.out.println("số lương sinh viên là: " + Student.count);
	}

	public static void Question6() {
		Student s1 = new PrimaryStudent();
		Student s2 = new PrimaryStudent();

		Student s3 = new SecondaryStudent();
		Student s4 = new SecondaryStudent();
		Student s5 = new SecondaryStudent();
		Student s6 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên");
		String leftAlignFormat = "| %-20s | %-4d |%n";

		System.out.format("+----------------------+------+%n");
		System.out.format("| Category             | SL   |%n");
		System.out.format("+----------------------+------+%n");

		System.out.format(leftAlignFormat, "Students: ", Student.count);
		System.out.format(leftAlignFormat, "PrimaryStudents: ", PrimaryStudent.CountPr);
		System.out.format(leftAlignFormat, "SecondaryStudents: ", SecondaryStudent.CountSen);
		System.out.format("+----------------------+------+%n");
	}

	public static void Question7() {
		for (int i = 0; i < 6; i++) {
			Student student = new Student();
			System.out.println(student.toString());
		}

		System.out.println("Tạo Primary Stundent");
		PrimaryStudent primaryStudent = new PrimaryStudent();
		System.out.println("Sinh viên Primary Student: " + primaryStudent);

		System.out.println("Tạo Secondary Stundent");
		SecondaryStudent secondaryStudent = new SecondaryStudent();
		System.out.println("Sinh viên Secondary Student: " + secondaryStudent);

	}

	public static void Question8() throws Exception {
		System.out.println("Tạo 4 hình chữ nhật");
		HinhChuNhat[] hinhChuNhats = new HinhChuNhat[4];
		for (int i = 0; i < 4; i++) {
			System.out.println("Hình" + (i + 1) + " là");
			System.out.print("Cạnh a: ");
			float a = ScannerUtils.inputFloat("Không được bỏ trống");
			System.out.print("Cạnh b: ");
			float b = ScannerUtils.inputFloat("Không được bỏ trống");
			HinhChuNhat hinhChuNhat = new HinhChuNhat(a, b);
			hinhChuNhats[i] = hinhChuNhat;
			System.out.println("Chu Vi: " + hinhChuNhat.tinhchuvi(a, b));
			System.out.println("Diện tích: " + hinhChuNhat.tinhdientich(a, b));
		}

		System.out.println("Tạo hình tròn số 1");
		System.out.print("Nhập bán kính: ");
		float bk1 = ScannerUtils.inputFloat("Không được bỏ trống");
		HinhTron hinhTron1 = new HinhTron(bk1, bk1);
		System.out.println("Chu Vi: " + hinhTron1.tinhchuvi(bk1, bk1));
		System.out.println("Diện tích: " + hinhTron1.tinhdientich(bk1, bk1));

		System.out.println("Tạo hình tròn số 2");
		System.out.print("Nhập bán kính: ");
		float bk2 = ScannerUtils.inputFloat("Không được bỏ trống");
		HinhTron hinhTron2 = new HinhTron(bk2, bk2);
		System.out.println("Diện tích: " + hinhTron2.tinhchuvi(bk2, bk2));
		System.out.println("Diện tích: " + hinhTron2.tinhdientich(bk2, bk2));

	}

}
