package com.vti.entity;

public abstract class DienThoaiDiDong implements VuKhi {
	public void nghe() {
		System.out.println("Đang nghe máy....");
	}

	public void goi() {
		System.out.println("Đang gọi điện.....");
	}

	public void guitinnhan() {
		System.out.println("Đang gửi tin nhắn......");
	}

	public void nhantinnhan() {
		System.out.println("Nhận tin nhắn........");
	}

	@Override
	public abstract void tancongkexau();
}
