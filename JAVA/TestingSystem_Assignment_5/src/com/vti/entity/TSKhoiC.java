package com.vti.entity;

public class TSKhoiC extends ThiSinh {
	private final String khoi = "C (Văn - Sử - Địa)";

	public TSKhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Khối thi: " + khoi);
	}
}
