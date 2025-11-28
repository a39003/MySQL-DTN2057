package com.vti.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Student_Person extends Person {
	private int id;
	private Float gradeAvg;
	private String email;

	public Student_Person() {
		super();
	}

	public Student_Person(String name, Gender gender, LocalDate birthDate, String address, int id, float gradeAvg,
			String email) {
		super(name, gender, birthDate, address);
		this.id = id;
		this.gradeAvg = gradeAvg;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getGradeAvg() {
		return gradeAvg;
	}

	public void setGradeAvg(Float gradeAvg) {
		this.gradeAvg = gradeAvg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void inputInfo() {
		super.inputInfo(); // Nhập thông tin Person trước
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã sinh viên: ");
		id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập điểm trung bình: ");
		gradeAvg = sc.nextFloat();
		sc.nextLine();
		System.out.print("Nhập email: ");
		email = sc.nextLine();
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Mã sinh viên: " + id);
		System.out.println("Điểm trung bình: " + gradeAvg);
		System.out.println("Email: " + email);
		System.out.println("Học bổng: " + (isScholarship() ? "Được" : "Không"));
	}

	public boolean isScholarship() {
		return gradeAvg >= 8.0;
	}

}
