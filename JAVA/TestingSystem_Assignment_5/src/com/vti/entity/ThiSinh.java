package com.vti.entity;

public class ThiSinh {
	private String soBaoDanh;
	private String hoTen;
	private String diaChi;
	private int mucUuTien;

	public ThiSinh(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
		this.soBaoDanh = soBaoDanh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
	}

	public String getSoBaoDanh() {
		return soBaoDanh;
	}

	public void showInfo() {
		System.out.println("-------------------------");
		System.out.println("Số báo danh: " + soBaoDanh);
		System.out.println("Họ tên: " + hoTen);
		System.out.println("Địa chỉ: " + diaChi);
		System.out.println("Mức ưu tiên: " + mucUuTien);
	}

}
