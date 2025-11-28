package com.vti.entity;

import java.util.ArrayList;

public class VietnamesePhone extends Phone {

	private ArrayList<Contact> contacts;

	public VietnamesePhone() {
		contacts = new ArrayList<Contact>();
	}

	@Override
	public void insertContact(String name, String phone) {
		Contact contact = new Contact(name, phone);
		contacts.add(contact);
		System.out.println(" Đã thêm: " + name);
	}

	@Override
	public void removeContact(String name) {
		contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
		System.out.println("Đã xóa (nếu tồn tại): " + name);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name)) {
				c.setPhone(newPhone);
				System.out.println(" Đã cập nhật số mới cho " + name);
				return;
			}
		}
		System.out.println(" Không tìm thấy liên hệ để cập nhật!");
	}

	@Override
	public void searchContact(String name) {
		System.out.println("\n Kết quả tìm kiếm:");
		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name)) {
				System.out.println(c);
				return;
			}
		}
		System.out.println("❌ Không tìm thấy!");
	}

	public void printAll() {
		if (contacts.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}

		System.out.println("\n--- DANH SÁCH CONTACT ---");
		for (Contact c : contacts) {
			System.out.println(c.getName() + " - " + c.getPhone());
		}
		System.out.println("-------------------------\n");
	}
}
