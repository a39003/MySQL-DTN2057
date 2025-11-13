package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int ID;
	public String name;
	public Account creator;
	public LocalDate CreateDate;
	public Account[] account;
}
