package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.Student3;

public class Genericd {
	public static void Qusstion1_2() {
		Student3 student3_1 = new Student3<Integer>(1, "Hiếu");
		Student3 student3_2 = new Student3<Float>(2f, "Anh");
		Student3 student3_3 = new Student3<Double>(3d, "lâm");
		Student3[] student3s = { student3_1, student3_2, student3_3 };

		for (Student3 student3 : student3s) {
			System.out.println(student3);
		}

		print(student3_1);
		print(student3_2);
		print(student3_3);
		print(1);
		print(2f);
		print(3d);

	}

	public static void Qursstion4() {
		Integer[] arrInt = { 2, 4, 6 };
		Float[] arrFloat = { 3f, 5f, 7f };
		Double[] arrDouble = { 3.4, 5.6, 7.2 };

		printArr(arrInt);
		printArr(arrFloat);
		printArr(arrDouble);
	}

	public static void Question5() {
		Integer[] salarEmployee1 = { 1000, 1300, 1400 };
		Employee<Integer> employee1 = new Employee<Integer>(1, "Hiếu", salarEmployee1);
		System.out.println("Employee 1: " + employee1);
		System.out.println("Tháng lương cuối cùng của employye 1: " + salarEmployee1[salarEmployee1.length - 1]);

		Float[] salarEmployee2 = { 1000f, 1300f, 1400f };
		Employee<Float> employee2 = new Employee<Float>(2, "Thắng", salarEmployee2);
		System.out.println("Employee 2: " + employee2);
		System.out.println("Tháng lương cuối cùng của employye 2: " + salarEmployee2[salarEmployee2.length - 1]);

		Double[] salarEmployee3 = { 1000d, 1300d, 1400d };
		Employee<Double> employee3 = new Employee<Double>(3, "Lâm", salarEmployee3);
		System.out.println("Employee 3: " + employee3);
		System.out.println("Tháng lương cuối cùng của employye 3: " + salarEmployee3[salarEmployee3.length - 1]);
	}

	public static void Question6() {
		MyMap<Integer, String> student = new MyMap<Integer, String>(101, "Phạm đức anh");

		System.out.println("Mã sinh viên: " + student.getKey());
		System.out.println("Họ và tên: " + student.getValue());
	}

	public static void Question7() {
		Phone<String, String> phone1 = new Phone<String, String>("anh@gmail.com", "012345678");
		Phone<String, String> phone2 = new Phone<String, String>("Phạm đức anh", "012345678");
		Phone<Integer, String> phone3 = new Phone<Integer, String>(1, "012345678");

		Phone[] phones = { phone1, phone2, phone3 };

		for (Phone phone : phones) {
			System.out.println("Key: " + phone.getKey() + " Value: " + phone.getPhoneNumber());
		}
//		System.out.println("Email: "+ phone1.getKey() + " SĐT: "+ phone1.getPhoneNumber());
	}

	public static void Question8() {
		Staff<Integer, String> s1 = new Staff(101, "Nguyễn Văn A");

		Staff<Long, String> s2 = new Staff(1000001L, "Trần Thị B");

		System.out.println("ID: " + s1.getKey() + " - Name: " + s1.getValue());
		System.out.println("ID: " + s2.getKey() + " - Name: " + s2.getValue());
	}

	private static <T> void print(T a) {
		System.out.println(a);
	}

	private static <T> void printArr(T[] arr) {
		for (T t : arr) {
			System.out.println(t);
		}
	}
}
