package com.vti.program;

public class Boxing_Unboxing {
	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
	}

	public static void Question1() {
		/*
		 * Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó convert
		 * lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu
		 * thập phân)
		 */

		Integer datatype = 5000;
		System.out.printf("%2.2f %n", (float) datatype);
	}

	public static void Question2() {
//		Khai báo 1 String có value = "1234567"
//				Hãy convert String đó ra số int

		String aString = "1234567";
		int i = Integer.parseInt(aString);
		System.out.println(i);
	}

	public static void Question3() {
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int

		Integer a = 1234567;
		int a1 = a.intValue();
		System.out.println(a1);
	}

}
