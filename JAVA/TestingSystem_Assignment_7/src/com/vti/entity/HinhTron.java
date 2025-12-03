package com.vti.entity;

public class HinhTron extends HinhHoc {

	public HinhTron(float a, float b) throws Exception {
		super(a, b);
	}

	@Override
	public float tinhdientich(float a, float b) {
		return (float) (3.14 * (Math.pow(a, b)));
	}

	@Override
	public float tinhchuvi(float a, float b) {
		return (float) (2 * a * (3.14));
	}

}
