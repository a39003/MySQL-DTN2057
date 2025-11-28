package com.vti.entity;

public class Rectange {
	private float a;
	private float b;

	public float tinhchuvi() {
		return 2 * (a + b);
	}

	public float dientich() {
		return a * b;
	}

	public Rectange(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}
}
