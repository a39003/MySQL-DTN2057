package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
	public HinhChuNhat(float a, float b) throws Exception {
		super(a, b);
	}

	@Override
	public float tinhchuvi(float a, float b) {
		return 2 * (a + b);
	}

	@Override
	public float tinhdientich(float a, float b) {
		return (a * b);
	}

}
