package com.vti.entity;

public class TSKhoiB extends ThiSinh {
	private final String khoi = "B (Toán - Hoá - Sinh)";

	public TSKhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Khối thi: " + khoi);
	}
}
