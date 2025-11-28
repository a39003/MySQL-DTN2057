package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			System.out.print("Mời bạn nhập số: ");
			String input = scanner.nextLine();
			try {
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println(errorMessage);
				System.out.print("Nhập lại: ");
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			System.out.print("Mời bạn nhập số: ");
			String input = scanner.nextLine();
			try {
				return Float.parseFloat(input);
			} catch (Exception e) {
				System.out.println(errorMessage);
				System.out.print("Nhập lại: ");
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			System.out.print("Mời bạn nhập số: ");
			String input = scanner.nextLine();
			try {
				return Double.parseDouble(input);
			} catch (Exception e) {
				System.out.println(errorMessage);
				System.out.print("Nhập lại: ");
			}
		}
	}

	public static String inputString() {
		while (true) {
			// System.out.print("Mời bạn nhập chuỗi: ");
			String input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
			}
			System.out.println("Chuỗi không được để trống, nhập lại:");
		}
	}
}
