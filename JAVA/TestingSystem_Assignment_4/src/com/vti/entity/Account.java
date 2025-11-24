package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public int ID;
	public String Email;
	public String Username;
	public String FullName;
	public Department departemnt;
	public Position position;
	public LocalDate CreateDate;
	public Group[] group;

	public Account() {
	}

	public Account(int ID, String Email, String Username, String Fullname) {
		this.ID = ID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = Fullname;
	}

	public Account(int ID, String Email, String Username, String Fullname, Position position) {
		this.ID = ID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = Fullname;
		this.position = position;
		this.CreateDate = LocalDate.now();
	}

	public Account(int ID, String Email, String Username, String Fullname, Position position, LocalDate CreateDate) {
		super();
		this.ID = ID;
		this.Email = Email;
		this.Username = Username;
		this.FullName = Fullname;
		this.position = position;
		this.CreateDate = CreateDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + ID + ", email=" + Email + ", username=" + Username + ", fullName=" + FullName
				+ ", position=" + position + ", createDate=" + CreateDate + "]";
	}

}
