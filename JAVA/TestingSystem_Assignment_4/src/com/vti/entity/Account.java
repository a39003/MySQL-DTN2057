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

	public Account(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Department getDepartemnt() {
		return departemnt;
	}

	public void setDepartemnt(Department departemnt) {
		this.departemnt = departemnt;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDate createDate) {
		CreateDate = createDate;
	}

	public Group[] getGroup() {
		return group;
	}

	public void setGroup(Group[] group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Account [id=" + ID + ", email=" + Email + ", username=" + Username + ", fullName=" + FullName
				+ ", position=" + position + ", createDate=" + CreateDate + "]";
	}

}
