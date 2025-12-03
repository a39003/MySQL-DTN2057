package com.vti.entity;

public class SecondaryStudent1 extends Studentfinal {
	public static int CountSen = 0;

	public SecondaryStudent1(String name) {
		super(CountSen, name);
		CountSen++;
	}
}
