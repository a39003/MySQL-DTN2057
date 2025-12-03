package com.vti.entity;

public class Studentfinal {
	private final int id;
	private String name;

	public Studentfinal(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void study() {
		System.out.println("Sinh viên đang học bài");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Studentfinal [id=" + id + ", name=" + name + "]";
	}

}
