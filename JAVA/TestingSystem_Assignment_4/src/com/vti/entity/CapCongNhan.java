package com.vti.entity;

public class CapCongNhan extends CanBo {
	private int rank;

	public CapCongNhan(String name, int age, Gender gender, String address, int rank) {
		super(name, age, gender, address);
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Công nhân: " + super.toString() + ", bậc: " + rank;
	}

}
