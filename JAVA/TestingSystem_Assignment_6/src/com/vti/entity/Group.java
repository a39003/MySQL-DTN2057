package com.vti.entity;

import java.time.LocalDate;

import com.vti.utils.ScannerUtils;

public class Group {
	public static int countgro = 0;
	private int ID;
	private String name;
	private Account creator;
	private LocalDate CreateDate;
	private Account[] accounts;

	public void printGroup() {
		System.out.println("thông tin group");
		System.out.println("Group: " + " ID: " + ID + " ,Name: " + name + " ,CreteDate: " + CreateDate);
		if (accounts != null) {
			System.out.println("Số lượng account có trong gruop là: " + accounts.length);
			for (Account account : accounts) {
				System.out.println(account.toString());
			}
		}
	}

	public Group() {
		super();
		System.out.println("Nhập thông tin group ");
		countgro++;
		this.ID = countgro;
		System.out.print("Nhập tên group: ");
		this.name = ScannerUtils.inputString();
		System.out.print("Ngày tạo group: ");
		this.CreateDate = ScannerUtils.intputLocalDate();
		System.out.print("Bạn có muốn thêm account vào group không(1.có, 2.không): ");
		while (true) {
			int choose = ScannerUtils.intputIntPositve();
			switch (choose) {
			case 1:
				System.out.print("Nhập số lượng accoutn muốn thêm: ");
				int countaccont = ScannerUtils.intputIntPositve();
				Account[] accoun = new Account[countaccont];
				for (int i = 0; i < countaccont; i++) {
					System.out.println("Nhập account thứ " + (i + 1));
					Account accou = new Account();
					accoun[i] = accou;
				}
				this.accounts = accoun;
				return;
			case 2:
				return;
			default:
				System.out.println("Nhập sai rồi nhập lại: ");
				break;
			}
		}
	}

}
