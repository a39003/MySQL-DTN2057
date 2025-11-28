package com.vti.entity;

public class CapKySu extends CanBo {
	private String specialized;

	public CapKySu(String name, int age, Gender gender, String address, String specialized) {
		super(name, age, gender, address);
		this.specialized = specialized;
	}

	public String getSpecialized() {
		return specialized;
	}

	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}

	@Override
	public String toString() {
		return "Kỹ sư: " + super.toString() + ", ngành đào tạo: " + specialized;
	}

}
