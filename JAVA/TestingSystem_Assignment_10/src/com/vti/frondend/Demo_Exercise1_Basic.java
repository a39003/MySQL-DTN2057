package com.vti.frondend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1_Basic;
import com.vti.utils.ScannerUtils;

public class Demo_Exercise1_Basic {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise1_Basic exercise1_Basic = new Exercise1_Basic();
		exercise1_Basic.Question1();
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                          DEPARTMENT MANAGEMENT SYSTEM                    |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                            Please choose an option:                      |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. View all position");
			System.out.format(leftAlignFormat, "2. Create new position");
			System.out.format(leftAlignFormat, "3. Update postion");
			System.out.format(leftAlignFormat, "4. Delete position by ID");
			System.out.format(leftAlignFormat, "5. Find department by ID");
			System.out.format(leftAlignFormat, "6. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.print("Enter your choice (1-6): ");
			int choice = ScannerUtils.inputIntPositive();

			switch (choice) {
			case 1:
				exercise1_Basic.Question2();
				break;
			case 2:
				exercise1_Basic.Question3();
				break;
			case 3:
				exercise1_Basic.Question4();
				break;
			case 4:
				exercise1_Basic.Question5();
				break;
			case 5:
				exercise1_Basic.Question6();
				break;
			case 6:
				System.out.println("thoát chương trình.....");
				return;
			default:
				break;
			}

		}
	}
}
