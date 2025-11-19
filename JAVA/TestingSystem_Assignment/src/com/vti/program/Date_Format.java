package com.vti.program;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.vti.entity.Exam;

public class Date_Format {
	public static void main(String[] args) {

		Exam exam1 = new Exam();
		exam1.ID = 1;
		exam1.name = "Java";
		exam1.credatetime = LocalDateTime.now();

//		Question 1:
//			In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//			dạng vietnamese
		System.out.println("-------------Question 1 ----------------------");
		DateTimeFormatter vnFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(exam1.credatetime.format(vnFormatter));

//			Question 2:
//			In ra thông tin: Exam đã tạo ngày nào theo định dạng
//			Năm – tháng – ngày – giờ – phút – giây
		System.out.println("-------------Question 2 ----------------------");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(exam1.credatetime.format(formatter));

//			Question 3:
//			Chỉ in ra năm của create date property trong Question 2
//
		System.out.println("-------------Question 3 ----------------------");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy HH:mm:ss");
		System.out.println(exam1.credatetime.format(formatter3));
//
//			Question 4:
//			Chỉ in ra tháng và năm của create date property trong Question 2
		System.out.println("-------------Question 4 ----------------------");
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("MM/yyyy HH:mm:ss");
		System.out.println(exam1.credatetime.format(formatter4));

//			Question 5:
//			Chỉ in ra "MM-DD" của create date trong Question 2

		System.out.println("-------------Question 5 ----------------------");
		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
		System.out.println(exam1.credatetime.format(formatter5));
	}
}
