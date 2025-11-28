package com.vti.entity;

public class HighSchoolStudent extends Student2 {
	private String clazz;
	private String desiredUniversity;

	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return "Thông tin sinh viên: " + "ID: " + super.getId() + " ,Name: " + super.getName() + " ,Clazz: " + clazz
				+ " ,DesiredUniversity: " + desiredUniversity;
	}

}
