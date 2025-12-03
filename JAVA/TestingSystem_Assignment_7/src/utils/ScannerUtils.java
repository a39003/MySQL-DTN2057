package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

	public static int intputIntPositve() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(scanner.next());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.err.println("Nhập lại: ");
				}
			} catch (Exception e) {
				System.err.println("Nhập lại: ");
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
			String input = scanner.next().trim();
			if (!input.isEmpty()) {
				return input;
			}
			System.out.println("Chuỗi không được để trống, nhập lại:");
		}
	}

	public static LocalDate intputLocalDate() {
		System.out.println("Nhaph theo định dạng yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdateString = scanner.next().trim();
			try {
				if (format.parse(localdateString) != null) {
					LocalDate lDate = LocalDate.parse(localdateString);
					return lDate;
				}
			} catch (Exception e) {
				System.err.println("Mời bạn nhập lại: ");
			}
		}
	}

}
