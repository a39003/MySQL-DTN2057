package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.ITuyenSinh;
import com.vti.entity.TSKhoiA;
import com.vti.entity.TSKhoiB;
import com.vti.entity.TSKhoiC;
import com.vti.entity.ThiSinh;

public class TuyenSinh implements ITuyenSinh {
	private ArrayList<ThiSinh> danhsachList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void addThiSinh() {
		System.out.println("Chọn khối thi:");
		System.out.println("1. Khối A");
		System.out.println("2. Khối B");
		System.out.println("3. Khối C");
		System.out.print("Lựa chọn: ");
		int choice = Integer.parseInt(scanner.nextLine());

		System.out.print("Nhập số báo danh: ");
		String sdb = scanner.nextLine();

		System.out.print("Nhập họ và tên: ");
		String name = scanner.nextLine();

		System.out.print("Nhập địa chỉ: ");
		String addres = scanner.nextLine();

		System.out.print("Nhapah mức ưu tiên: ");
		int priority = Integer.parseInt(scanner.nextLine());

		ThiSinh ts = null;

		switch (choice) {
		case 1 -> ts = new TSKhoiA(sdb, name, addres, priority);
		case 2 -> ts = new TSKhoiB(sdb, name, addres, priority);
		case 3 -> ts = new TSKhoiC(sdb, name, addres, priority);
		default -> {
			System.out.println("Lựa chọn không hợp lệ");
			return;
		}
		}
		danhsachList.add(ts);
		System.out.println("Thêm thí sinh thành công");
	}

	@Override
	public void displayThiSinh() {
		if (danhsachList.isEmpty()) {
			System.out.println("Không có thí sinh nào");
			return;
		}

		System.out.println("--------Danh sách thí sinh------------");
		for (ThiSinh thiSinh : danhsachList) {
			thiSinh.showInfo();
		}
	}

	@Override
	public void searchBySBD() {
		System.out.print("Nhập số báo dánh cần tìm: ");
		String sdbString = scanner.nextLine();

		for (ThiSinh thiSinh : danhsachList) {
			if (thiSinh.getSoBaoDanh().equalsIgnoreCase(sdbString)) {
				System.out.println("Tìm thấy thí sinh");
				thiSinh.showInfo();
				return;
			}
		}
		System.out.println("Khong tìm thấy thí sinh");
	}

}
