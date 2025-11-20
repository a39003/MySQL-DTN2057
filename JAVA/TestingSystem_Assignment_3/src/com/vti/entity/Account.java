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
}
