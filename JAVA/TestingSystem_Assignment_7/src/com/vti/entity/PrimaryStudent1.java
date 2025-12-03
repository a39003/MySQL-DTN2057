package com.vti.entity;

public class PrimaryStudent1 extends Studentfinal {
	public static int CountPr = 0;

	public PrimaryStudent1(String name) {
		super(CountPr, name);
		CountPr++;
	}
}
