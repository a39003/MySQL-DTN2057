package com.vti.entity;

public class CanBo {
	private String name;
	private int age;
	private Gender gender;
	private String adress;

	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	public CanBo() {

	}

	public CanBo(String name, int age, Gender gender, String adress) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Họ tên: " + name + ", tuổi: " + age + ", giới tính: " + gender + ", địa chỉ: " + adress;
	}

}
