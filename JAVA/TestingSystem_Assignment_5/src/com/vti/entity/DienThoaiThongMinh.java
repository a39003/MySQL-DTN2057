package com.vti.entity;

public class DienThoaiThongMinh extends DienThoaiDiDong {
	public void sudung3g() {
		System.out.println("Đang sử dụng 3G......");
	}

	public void chuphinh() {
		System.out.println("Chụp hình......");
	}

	@Override
	public void tancongkexau() {
		System.out.println("Ném vỡ điện thoại ngay..........");
	}
}
