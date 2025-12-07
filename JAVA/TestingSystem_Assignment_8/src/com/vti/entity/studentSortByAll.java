package com.vti.entity;

import java.util.Comparator;

public class studentSortByAll implements Comparator<student1> {

	@Override
	public int compare(student1 s1, student1 s2) {

		int nameCompare = s1.getName().compareTo(s2.getName());
		if (nameCompare != 0) {
			return nameCompare;
		}

		int birthCompare = s1.getBirthDate().compareTo(s2.getBirthDate());
		if (birthCompare != 0) {
			return birthCompare;
		}

		return Double.compare(s1.getPoint(), s2.getPoint());
	}

}
