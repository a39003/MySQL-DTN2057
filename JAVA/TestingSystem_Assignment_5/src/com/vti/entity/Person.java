package com.vti.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person {
	private String name;
	private Gender gender;
	private LocalDate birthDate;
	private String address;

	enum Gender {
		MALE, FEMALE, UNKNOWN;
	}

	public Person() {

	}

	public Person(String name, Gender gender, LocalDate birthDate, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên: ");
		name = sc.nextLine();
		System.out.println("Gender 1.Male, 2.Female, 3.Unknown: ");
		int flagGender = sc.nextInt();
		sc.nextLine();
		switch (flagGender) {
		case 1:
			this.gender = Gender.MALE;
			break;
		case 2:
			this.gender = Gender.FEMALE;
			break;
		case 3:
			this.gender = Gender.UNKNOWN;
			break;

		}
		System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
		String dateStr = sc.nextLine();
		birthDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.print("Nhập địa chỉ: ");
		address = sc.nextLine();
	}

	public void showInfo() {
		System.out.println("Tên: " + name);
		System.out.println("Giới tính: " + gender);
		System.out.println("Ngày sinh: " + birthDate);
		System.out.println("Địa chỉ: " + address);
	}

}
