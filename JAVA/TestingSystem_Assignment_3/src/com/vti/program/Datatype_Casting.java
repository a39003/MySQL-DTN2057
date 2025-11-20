package com.vti.program;

import java.util.Random;
import java.util.Scanner;

public class Datatype_Casting {
	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
		Question4();
	}

	public static void Question1() {
		float a = 5240.5f;
		float a1 = 10970.055f;

		int a3 = (int) a;
		int a4 = (int) a1;
		System.out.println("Làm tròn lương: " + a3 + ", " + a4);
	}

	public static void Question2() {
		// Question 2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ
		// thêm có số 0 ở đầu cho đủ 5 chữ số)
		Random random = new Random();

		int number = random.nextInt(100000);

		String result = String.valueOf(number);

		while (result.length() < 5) {
			result = "0" + result;
		}

		System.out.println("Số ngẫu nhiên có 5 chữ số: " + result);

	}

	public static void Question3() {
		/*
		 * Question 3: Lấy 2 số cuối của số ở Question 2 và in ra. Gợi ý: Cách 1:
		 * convert số có 5 chữ số ra String, sau đó lấy 2 số cuối Cách 2: chia lấy dư số
		 * đó cho 100
		 */
		Random random = new Random();

		int number = random.nextInt(100000);

		String result = String.valueOf(number);

		while (result.length() < 5) {
			result = "0" + result;
		}
		System.out.println("----Cách 1 -------");
		System.out.println("2 số cuối của 5 chữ sô ngẫu nhiên: " + result.substring(3));
		System.out.println("----Cách 2--------");
		System.out.println("2 số cuối của 5 chữ sô ngẫu nhiên: " + Integer.parseInt(result) % 100);
	}

	public static void Question4() {
		// Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của
		// chúng

		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhâp số a: ");
		float a = sc.nextInt();
		System.out.print("Mời bạn nhập số b: ");
		float b = sc.nextInt();
		if (b == 0) {
			System.out.println("Vui lòng nhập số khác 0!");
		}

		sc.close();
		System.out.println("Thương:" + a / b);
	}
}
