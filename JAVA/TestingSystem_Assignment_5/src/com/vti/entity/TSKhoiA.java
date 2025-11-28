package com.vti.entity;

public class TSKhoiA extends ThiSinh {
	private final String khoi = "A(Toán-Lý-Hóa)";

	public TSKhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		super(soBaoDanh, hoTen, diaChi, mucUuTien);
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Khối thi: " + khoi);
	}
}
