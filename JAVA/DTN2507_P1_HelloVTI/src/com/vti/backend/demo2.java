package com.vti.backend;

public class demo2 {
	public static void main(String[] args) {
		float a = 5240.5f;
		float b = 10970.055f;

		int c = Math.round(a);
		int d = Math.round(b);
		System.out.println(c);
		System.out.println(d);

		String name = "Nguyen Quang Đạo";

		String[] name1 = name.trim().split(" ");
		int conut = name1.length;

		System.out.println(conut);
	}

}
