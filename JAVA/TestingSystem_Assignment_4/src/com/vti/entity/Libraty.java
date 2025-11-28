package com.vti.entity;

public class Libraty {
	private int id;
	private String publisher;
	private int numRelease;

	public Libraty(int id, String publisher, int numRelease) {
		this.id = id;
		this.publisher = publisher;
		this.numRelease = numRelease;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Document: " + "ID: " + id + " ,Publisher: " + publisher + " ,NumRelease: " + numRelease;
	}

}
