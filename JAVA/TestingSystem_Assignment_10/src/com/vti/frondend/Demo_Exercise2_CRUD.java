package com.vti.frondend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise2_CRUD;
import com.vti.utils.ScannerUtils;

public class Demo_Exercise2_CRUD {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

		Exercise2_CRUD exercise2_CRUD = new Exercise2_CRUD();

		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                          DEPARTMENT MANAGEMENT SYSTEM                    |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                            Please choose an option:                      |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. View all departments");
			System.out.format(leftAlignFormat, "2. View department with ID = 5");
			System.out.format(leftAlignFormat, "3. Find department by ID");
			System.out.format(leftAlignFormat, "4. Check if department name exists");
			System.out.format(leftAlignFormat, "5. Create new department");
			System.out.format(leftAlignFormat, "6. Update existing department");
			System.out.format(leftAlignFormat, "7. Delete department by ID");
			System.out.format(leftAlignFormat, "8. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.print("Enter your choice (1-8): ");
			int choice = ScannerUtils.inputIntPositive();

			switch (choice) {
			case 1:
				exercise2_CRUD.Question1();
				break;
			case 2:
				exercise2_CRUD.Question2();
				break;
			case 3:
				exercise2_CRUD.Question3();
				break;
			case 4:
				exercise2_CRUD.Question4();
				break;
			case 5:
				exercise2_CRUD.Question5();
				break;
			case 6:
				exercise2_CRUD.Question6();
				break;
			case 7:
				exercise2_CRUD.Question7();
				break;
			case 8:
				System.out.println("thoát chương trình.....");
				return;
			default:
				break;
			}
		}
	}
}
