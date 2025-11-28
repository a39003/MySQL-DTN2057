package com.vti.entity;

public class Student implements IStudent {
	public static int COUNT;
	private int id;
	private String name;
	private int group;

	public Student(String name, int group) {
		COUNT++;
		this.id = COUNT;
		this.name = name;
		this.group = group;
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh.");

	}

	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài.");

	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " đi dọn vệ sinh.");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}

}
