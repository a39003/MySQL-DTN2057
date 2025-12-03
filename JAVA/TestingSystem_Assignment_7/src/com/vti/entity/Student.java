package com.vti.entity;

import utils.ScannerUtils;

public class Student {
	public static int count = 0;
	private int id;
	private String name;
	public static String collect = "Đại học bách khoa";
	public static int moneyGroup = 0;

	public Student(String name) {
		super();
		this.id = count++;
		this.name = name;
		count++;
	}

	public Student() {
		super();
		if (count > 7) {
			System.out.println("Tối đa là 7 sinh viên");
		} else {
			this.id = count++;
			System.out.print("Mời bạn nhập tên: ");
			this.name = ScannerUtils.inputString();
		}

	}

	public static int getCount() {
		return count;
	}

	public static String getCollect() {
		return collect;
	}

	public static void setCollect(String collect) {
		Student.collect = collect;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Collect=" + collect + ", moneyGroup:" + moneyGroup + "]";
	}

}
