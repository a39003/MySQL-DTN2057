package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int ID;
	public String name;
	public Account creator;
	public LocalDate CreateDate;
	public Account[] account;

	public Group() {
	}

	public Group(int ID, String name, Account creator, LocalDate CreateDate, Account[] accounts) {
		this.ID = ID;
		this.name = name;
		this.creator = creator;
		this.CreateDate = CreateDate;
		this.account = accounts;
	}

	public Group(int ID, String name, Account creator, String[] usernames, LocalDate CreateDate) {
		this.ID = ID;
		this.name = name;
		this.creator = creator;
		// accounts
		Account[] accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			accounts[i] = new Account(usernames[i]);
		}
		this.CreateDate = CreateDate;

	}

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

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(LocalDate createDate) {
		CreateDate = createDate;
	}

	public Account[] getAccount() {
		return account;
	}

	public void setAccount(Account[] account) {
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GroupName: ").append(name).append(", Creator: ").append(creator).append(", Accounts: [");
		for (int i = 0; i < account.length; i++) {
			sb.append(account[i]);
			if (i < account.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("], CreateDate: ").append(CreateDate);
		return sb.toString();
	}

}
