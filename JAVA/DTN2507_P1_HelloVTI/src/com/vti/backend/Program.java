package com.vti.backend;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello VTI");
		int a = 10;
		int b = 20;
		Gender gender = Gender.MALE;
		int restls = a + b;
		System.out.println("Tổng hai số: " + restls + gender);

		String[] DTN_name = { "Đức Anh", "Minh", "linh", "Huyền" };

		System.out.println("Tên: " + DTN_name[0]);

		student Student1 = new student();

	}

	public enum Gender {
		MALE, FEMALE
	}
}
