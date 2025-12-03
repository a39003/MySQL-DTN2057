package com.vti.backend;

import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent1;
import com.vti.entity.SecondaryStudent1;
import com.vti.entity.Studentfinal;

import utils.ScannerUtils;

public class finals {
	public static void Question1() {
		System.out.println("Demo tính pi");
		int a = ScannerUtils.inputInt(null);
		System.out.println("Kết quả: " + MyMath.sumfloat(a));

//		System.out.println("thử thay đổi pi = 3.14 sang 3.15");
//		MyMath.pi = 3.15f;
//		System.out.println(MyMath.pi);
	}

	public static void Question2() {
		System.out.println("Tạo thông tin studnet");
		Studentfinal studentfinal = new Studentfinal(1, "Lâm");
		System.out.println(studentfinal);
	}

	public static void Question3() {
		PrimaryStudent1 priStudent = new PrimaryStudent1("lâm");
		SecondaryStudent1 secondStudent = new SecondaryStudent1("hiếu");

//		System.out.println("priStudent: "+ PrimaryStudent.s);
		// tại sao không dùng cách này được vì do void không cộng được chuỗi nên java nó
		// đang kg hiểu và khi goin một method kg cộng đc chuỗi

		System.out.println("priStudent: ");
		priStudent.study();
		System.out.println("secondSudent: ");
		secondStudent.study();
	}
}
