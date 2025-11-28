package com.vti.entity;

public class ClassBook extends Libraty {
	private String authorName;
	private int numberPage;

	public ClassBook(int id, String publisher, int numRelease, String authorName, int numberPage) {
		super(id, publisher, numRelease);
		this.authorName = authorName;
		this.numberPage = numberPage;
	}

	@Override
	public String toString() {
		return super.toString() + ",AuthorName: " + authorName + " ,NumberPage: " + numberPage;
	}

}
