package com.vti.entity;

import java.time.LocalDate;

public class student1 implements Comparable<student1> {
	public static int count = 0;
	private int id;
	private String name;
	private LocalDate birthDate;
	private double point;

	public student1() {

	}

	public student1(String name, LocalDate birthDate, Double point) {
		super();
		count++;
		this.id = count;
		this.name = name;
		this.birthDate = birthDate;
		this.point = point;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		student1.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "student1 [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", point=" + point + "]";
	}

	@Override
	public int compareTo(student1 o) {
		return this.name.compareTo(o.name);
	}

}
