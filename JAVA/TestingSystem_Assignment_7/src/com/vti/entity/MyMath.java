package com.vti.entity;

public class MyMath {

	public static final float pi = 3.14f;

	public static float sumfloat(int a) {
		return a * pi;
	}

	public static int max(int a, int b) {
		if (a <= b) {
			return b;
		} else {
			return a;
		}
	}

	public static int min(int a, int b) {
		if (a <= b) {
			return a;
		} else {
			return b;
		}
	}

	public static int sum(int a, int b) {
		return a + b;
	}
}
