package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Department {
	public static int countdep = 0;
	private int ID;
	private String name;

	public Department(int iD, String name) {
		super();
		this.countdep++;
		this.ID = countdep;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + ID + ", name='" + name + '\'' + '}';
	}

	public Department() {
		super();
		countdep++;
		this.ID = countdep;
		System.out.print("Nhập tên phòng: ");
		this.name = ScannerUtils.inputString();
	}

}
