package com.vti.frondend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise2_Account;
import com.vti.utils.ScannerUtils;

public class Demo_Exercise2_Account {
	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Exercise2_Account exercise2_Account = new Exercise2_Account();

		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                         ACCOUNT MANAGEMENT SYSTEM                        |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                            Please choose an option:                      |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. View all account");
			System.out.format(leftAlignFormat, "2. View account with ID = 5");
			System.out.format(leftAlignFormat, "3. Find account by ID");
			System.out.format(leftAlignFormat, "4. Check if account name exists");
			System.out.format(leftAlignFormat, "5. Create new account");
			System.out.format(leftAlignFormat, "6. Update existing account");
			System.out.format(leftAlignFormat, "7. Delete account by ID");
			System.out.format(leftAlignFormat, "8. Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			System.out.print("Enter your choice (1-8): ");
			int choice = ScannerUtils.inputIntPositive();

			switch (choice) {
			case 1:
				exercise2_Account.Question1();
				break;
			case 2:
				exercise2_Account.Question2();
				break;
			case 3:
				exercise2_Account.Question3();
				break;
			case 4:
				exercise2_Account.Question4();
				break;
			case 5:
				exercise2_Account.Question5();
				break;
			case 6:
				exercise2_Account.Question6();
				break;
			case 7:
				exercise2_Account.Question7();
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
