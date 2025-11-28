package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float academicscore;

	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.academicscore = 0;
	}

	public void setScore(Float academicscore) {
		this.academicscore = academicscore;
	}

	public void plusScore(Float academicscore) {
		this.academicscore = this.academicscore + academicscore;
	}

	@Override
	public String toString() {
		String rank = null;
		if (this.academicscore < 4.0) {
			rank = "yếu";
		} else if (this.academicscore < 6.0) {
			rank = "Trung bình";
		} else if (this.academicscore < 8.0) {
			rank = "khá";
		} else {
			rank = "Giỏi";
		}

		return "Student [id=" + id + ", name=" + name + ", hometown=" + hometown + ", academicscore=" + academicscore
				+ ", Xếp Loai: " + rank + "]";
	}

}
