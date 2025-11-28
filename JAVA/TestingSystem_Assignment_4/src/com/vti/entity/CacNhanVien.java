package com.vti.entity;

public class CacNhanVien extends CanBo {
	private String task;

	public CacNhanVien(String name, int age, Gender gender, String address, String task) {
		super(name, age, gender, address);
		this.task = task;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Công nhân: " + super.toString() + ", Công việc: " + task;

	}
}
