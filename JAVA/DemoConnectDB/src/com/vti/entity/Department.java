package com.vti.entity;

public class Department<K> {
	private K id;
	private String name;

	public Department() {
	}

	public Department(K id, String name) {
		this.id = id;
		this.name = name;
	}

	public Department(String name) {
		this.name = name;
	}

	// Getters & Setters
	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" + "ID=" + id + ", Name='" + name + '\'' + '}';
	}

}
