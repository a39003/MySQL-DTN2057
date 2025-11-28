package com.vti.entity;

import java.time.LocalDateTime;

public class Exam {
	public int ID;
	public String name;
	public LocalDateTime credatetime;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCredatetime() {
		return credatetime;
	}

	public void setCredatetime(LocalDateTime credatetime) {
		this.credatetime = credatetime;
	}

}
