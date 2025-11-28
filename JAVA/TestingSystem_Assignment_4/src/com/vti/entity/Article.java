package com.vti.entity;

import java.time.LocalDate;

public class Article extends Libraty {
	private LocalDate dayRelease;

	public Article(int id, String publisher, int numRelease, LocalDate dayRelease) {
		super(id, publisher, numRelease);
		this.dayRelease = dayRelease;
	}

	@Override
	public String toString() {
		return super.toString() + " ,dayRelease: " + dayRelease;
	}

}
