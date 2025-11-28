package com.vti.entity;

public abstract class Student2 extends Person {
	private int id;

	public Student2(String name, int id) {
		super(name);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
