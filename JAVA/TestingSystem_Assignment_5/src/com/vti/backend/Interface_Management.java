package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Person;
import com.vti.entity.Square;
import com.vti.entity.Student;
import com.vti.entity.Student_Person;

public class Interface_Management {
	// ---------------------------Question1--------------------------------------
	private ArrayList<Student> listStudent = new ArrayList<Student>();
	private Random random = new Random();
	private Scanner sc = new Scanner(System.in);
	private Square square;

	public void Question1() {
		while (true) {
			System.out.println("\n======== MENU QUẢN LÝ LỚP ========");
			System.out.println("1. Tạo danh sách sinh viên");
			System.out.println("2. Hiển thị danh sách sinh viên trong lớp");
			System.out.println("3. Điểm danh lớp");
			System.out.println("4. Nhóm 1 đi học bài");
			System.out.println("5. Nhóm 2 đi dọm vệ sinh");
			System.out.println("6. Thoát");
			System.out.print("Chọn: ");

			int choose = sc.nextInt();
			switch (choose) {
			case 1: {
				addStudent();
				System.out.println("Tạo thành công 10 sinh viên");
				break;
			}
			case 2: {
				for (Student student : listStudent) {
					System.out.println(student);
				}
				break;
			}
			case 3: {
				System.out.println("Cả lớp điểm danh: ");
				for (Student student : listStudent) {
					student.diemDanh();
				}
				break;
			}
			case 4: {
				System.out.println("Nhóm 1 đi bọc bài: ");
				for (Student student : listStudent) {
					if (student.getGroup() == 1) {
						student.hocBai();
					}
				}
				break;
			}
			case 5: {
				System.out.println("Nhóm 2 đi dọn vệ sinh: ");
				for (Student student : listStudent) {
					if (student.getGroup() == 2) {
						student.donVeSinh();
					}
				}
				break;
			}
			case 6: {
				return;
			}
			default:
				System.out.println("Lựa chọn đúng tren menu");
				break;
			}
		}
	}

	private void addStudent() {
		for (int i = 0; i < 10; i++) {
			Student student = new Student("Student: " + (i + 1), random.nextInt(3) + 1);
			listStudent.add(student);
		}
	}

	// --------------------Question2------------------------------
	public void Question2() {
		while (true) {
			System.out.println("\n======== MENU ========");
			System.out.println("1. Person");
			System.out.println("2. Student");
			System.out.println("3. Thoát");
			System.out.print("Chọn: ");
			int Choose = sc.nextInt();

			switch (Choose) {
			case 1: {
				demoPerson();
				break;
			}
			case 2: {
				demoStudent();
				break;
			}
			case 3: {
				System.out.println("thoát chuiwng trình....");
				return;
			}
			default:
				System.out.println("Lựa chọn đúng menu");
			}
		}
	}

	public void demoStudent() {
		Student_Person st = new Student_Person();
		st.inputInfo();
		System.out.println("Thông tin Student vừa nhập vào: ");
		st.showInfo();
		if (st.isScholarship()) {
			System.out.println("Sinh viên này đạt học bổng");
		} else {
			System.out.println("Sinh viên này không đạt học bổng");
		}
	}

	public void demoPerson() {
		Person person = new Person();
		person.inputInfo();
		System.out.println("Thông tin person vừa nhập vào: ");
		person.showInfo();
	}

	// -------------Question3------------------
	public void Question3() {
		while (true) {
			System.out.println("\n======== MENU ========");
			System.out.println("1. Create Square");
			System.out.println("2. Tính chu vi hình vuông");
			System.out.println("3. tính diện tích hình vuông");
			System.out.println("4. Thoát");
			System.out.print("Chọn: ");

			int choose = sc.nextInt();
			switch (choose) {
			case 1: {
				System.out.print("Nhập vào cạnh hình vuông: ");
				float a = sc.nextFloat();
				square = new Square(a);
				System.out.println("Bạn vừa tạo thành công hình vuông có cạnh " + a);
				break;
			}
			case 2: {
				System.out.println("Chu vi hình vuông là: " + square.tinhchuvi());
				break;
			}
			case 3: {
				System.out.println("Diện tích của hình vuông là: " + square.dientich());
				break;
			}
			case 4: {
				System.out.println("Thoát khỏi chương trình....");
				return;
			}

			default:
				System.out.println("Mời bạn nhập lại theo menu");
				break;
			}
		}
	}

}
