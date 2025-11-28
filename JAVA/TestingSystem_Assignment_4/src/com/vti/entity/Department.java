package com.vti.entity;

public class Department {
	private int ID;
	private String name;

	public Department() {

	}

	public Department(String name) {
		this.ID = 0;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + ID + ", name='" + name + '\'' + '}';
	}
}
