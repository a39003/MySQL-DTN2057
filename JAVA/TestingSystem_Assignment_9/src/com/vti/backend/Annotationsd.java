package com.vti.backend;

import java.sql.Date;

import com.vti.entity.Student;

public class Annotationsd {

	public static void Question1() {
		Date date = new Date(18 / 05 / 2020);

		System.out.println(date);

	}

	public static void Question2() {
		Student student = new Student("Nguyễn Văn A");
		System.out.println("Thông tin sinh viên ở getId: ID: " + student.getId() + " Name: " + student.getName());
		System.out.println("Thông tin sinh viên ở getIdMSV: ID: " + student.getIdMSV() + " Name: " + student.getName());
	}

}
