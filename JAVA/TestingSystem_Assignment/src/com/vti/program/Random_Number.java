package com.vti.program;

import java.time.LocalDate;
import java.util.Random;

public class Random_Number {
	public static void main(String[] args) {
//		Question 1:
//			In ngẫu nhiên ra 1 số nguyên
		System.out.println("-------------Question 1 ----------------------");
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số ngẫu nhiên: " + n);

//			Question 2:
//			In ngẫu nhiên ra 1 số thực
		System.out.println("-------------Question 2 ----------------------");
		Random random2 = new Random();
		float a = random2.nextFloat();
		System.out.println("Số thực ngẫu nhiên: " + a);

//			Question 3:
//			Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		System.out.println("-------------Question 3 ----------------------");
		String[] name = { "Ngân", "Thủy", "Anh", "Hiếu" };
		int i = random.nextInt(name.length);
		System.out.println("Tên một bạn ngẫu nhiên trong lớp: " + name[i]);

//			Question 4:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
//			1995
		System.out.println("-------------Question 4 ----------------------");
		int minday = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxday = (int) LocalDate.of(1995, 12, 20).toEpochDay();

		long ramdomInt = minday + random.nextInt(maxday - minday);

		LocalDate ramdoDay = LocalDate.ofEpochDay(ramdomInt);
		System.out.println("Một ngày ngẫu nhiên từ 24-07-1995 tới ngày 20-12-1995: " + ramdoDay);

//			Question 5:
//			Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		System.out.println("-------------Question 5 ----------------------");
		int nowday = (int) LocalDate.now().toEpochDay();
		int ramdomnowday = nowday - random.nextInt(365);
		LocalDate reusultDate = LocalDate.ofEpochDay(ramdomnowday);
		System.out.println("Một ngày ngẫu nhiên trong khoảng 1 năm trở lại đây: " + reusultDate);

//			Question 6:
//			Lấy ngẫu nhiên 1 ngày trong quá khứ
		System.out.println("-------------Question 6 ----------------------");
		int maxDay = (int) LocalDate.now().toEpochDay();
		int ramdommaxday = random.nextInt(maxDay);
		LocalDate reusultMaxDay = LocalDate.ofEpochDay(ramdommaxday);
		System.out.println("Một ngày ngẫu nhiên trong quá khứ: " + reusultMaxDay);

//			Question 7:
//			Lấy ngẫu nhiên 1 số có 3 chữ số
		System.out.println("-------------Question 7 ----------------------");
		int c = random.nextInt(100, 1000);
		System.out.println("Một số ngẫu nhiên có ba chữ số: " + c);
	}
}
