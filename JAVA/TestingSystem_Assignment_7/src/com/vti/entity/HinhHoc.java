package com.vti.entity;

public abstract class HinhHoc {
	private float a;
	private float b;
	public static int count = 0;

	public abstract float tinhchuvi(float a, float b);

	public abstract float tinhdientich(float a, float b);

	public HinhHoc(float a, float b) throws Exception {
		super();
		count++;
		if (count <= Configs.SO_LUONG_HINH_TOI_DA) {
			this.a = a;
			this.b = b;
		} else {
			System.out.println("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
		}
	}

}
