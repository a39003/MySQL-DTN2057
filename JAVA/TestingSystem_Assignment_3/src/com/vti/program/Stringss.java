package com.vti.program;

import java.util.Scanner;

public class Stringss {
	public static void main(String[] args) {
		// Question1();
		// uestion2();
		// Question3();
		// Question4();
		// Question5();
		// Question6();
		// Question7();
		// Question8();
		// Question9();
		// Question10();
		// Question11();
		// Question12();
		// Question13();
		// Question14();
		// Question15();
		Quesrion16();
	}

	public static void Question1() {
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//			thể cách nhau bằng nhiều khoảng trắng );
		String a;
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn một xâu ký tự: ");
		a = sc.nextLine();
		a = a.trim();

		if (a.isEmpty()) {
			System.out.println("Số lượng từ: 0");
		} else {
			String[] a1 = a.split(" ");
			System.out.println("Số lượng từ bằng:" + a1.length);
		}
	}

	public static void Question2() {
		// Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời nhập chuỗi 1: ");
		String a = sc.nextLine();
		System.out.print("Mời nhập chuỗi 2: ");
		String a1 = sc.nextLine();

		String a3 = a.concat(" ").concat(a1);
		System.out.println("Chuỗi được nối: " + a3);
	}

	public static void Question3() {
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chưa
//		viết hoa chữ cái đầu thì viết hoa lên
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập chuỗi: ");
		String a = sc.nextLine();

		String a1 = a.substring(0, 1).toUpperCase();
		String a2 = a.substring(1);
		a = a1 + a2;
		System.out.println("Chuỗi sau khia sửa: " + a);

	}

	public static void Question4() {
		/*
		 * Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của
		 * người dùng ra VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra
		 * "Ký tự thứ 1 là: N" "Ký tự thứ 1 là: A" "Ký tự thứ 1 là: M"
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ký tự đầu tiên: ");
		String a = sc.nextLine();
		a = a.toUpperCase();

		for (int i = 0; i < a.length(); i++) {
			System.out.println("Ký tự thứ " + (i + 1) + " là: " + a.charAt(i));
		}
	}

	public static void Question5() {
		// Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
		// dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ

		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập họ và tên đệm: ");
		String name1 = sc.nextLine();
		System.out.print("Mời bạn nhập tên: ");
		String name2 = sc.nextLine();

		String name3 = name1.concat(" ").concat(name2);
		System.out.println("Họ và tên: " + name3);

	}

	public static void Question6() {
		/*
		 * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ
		 * thống sẽ tách ra họ, tên , tên đệm VD: Người dùng nhập vào "Nguyễn Văn Nam"
		 * Hệ thống sẽ in ra "Họ là: Nguyễn" "Tên đệm là: Văn" "Tên là: Nam"
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập họ và tên: ");
		String fullname = sc.nextLine().trim();
		String[] name = fullname.split(" ");

		String ho = name[0];
		String ten = name[name.length - 1];
		String tendem = "";

		for (int i = 1; i < name.length - 1; i++) {
			tendem += name[i] + " ";
		}
		tendem = tendem.trim();

		System.out.println("Họ là:  " + ho);
		System.out.println("Tên đệm: " + tendem);
		System.out.println("Tên là: " + ten);

	}

	public static void Question7() {
		/*
		 * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa
		 * họ và tên của họ như sau: a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi
		 * người dùng nhập vào VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
		 * chuẩn hóa thành "nguyễn văn nam" b) Viết hoa chữ cái mỗi từ của người dùng
		 * VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành
		 * "Nguyễn Văn Nam"
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập Họ và Tên: ");
		String fullname = sc.nextLine();
		fullname = fullname.trim();
		fullname = fullname.replaceAll("\\s=", " ");

		String[] name = fullname.split(" ");
		String result = "";

		for (String word : name) {
			String firschar = word.substring(0, 1).toUpperCase();
			String rest = word.substring(1).toLowerCase();
			result += firschar + rest + " ";
		}

		result = result.trim();
		System.out.println("Tên sau khi chuẩn hóa: " + result);

	}

	public static void Question8() {
		// In ra tất cả các group có chứa chữ "Java"
		String[] groupname = { "JavaCore", "C#", "JavaSping", "Java Fresher" };
		for (String group : groupname) {
			if (group.contains("Java")) {
				System.out.println("Các group có chữ Java: " + group);
			}

		}
	}

	public static void Question9() {
		// In ra tất cả các group "Java"
		String[] groupname = { "JavaCore", "C#", "JavaSping", "Java Fresher" };
		for (String group : groupname) {
			if (group.startsWith("Java")) {
				System.out.println("Các group có Java: " + group);
			}

		}
	}

	public static void Question10() {
		/*
		 * Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. Nếu có xuất ra “OK”
		 * ngược lại “KO”. Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập chuỗi 1: ");
		String name = sc.nextLine();
		System.out.print("Mời bạn nhập chuỗi 2: ");
		String name2 = sc.nextLine();

		String reversed = new StringBuilder(name).reverse().toString();

		if (reversed.equals(name2)) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
	}

	public static void Question11() {
		// Count special Character Tìm số lần xuất hiện ký tự "a" trong chuỗi
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập chuỗi: ");
		String name = sc.nextLine();

		int count = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == 'a') {
				count++;
			}
		}

		System.out.println("Số lần a xuất hiện là: " + count);
	}

	public static void Question12() {
		// Reverse String Đảo ngược chuỗi sử dụng vòng lặp
		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhâp chuỗi: ");
		String name = sc.nextLine();
		String reversed = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			reversed += name.charAt(i);
		}
		System.out.println("Chuỗi đảo ngược: " + reversed);

	}

	public static void Question13() {
		/*
		 * String not contains digit Kiểm tra một chuỗi có chứa chữ số hay không, nếu có
		 * in ra false ngược lại true. Ví dụ: "abc" => true "1abc", "abc1", "123",
		 * "a1bc", null => false
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("Mời bạn nhập chuỗi: ");
		String name = sc.nextLine();

		boolean result = checkstring(name);

		System.out.println("Kết quả: " + result);
	}

	public static boolean checkstring(String nameString) {

		if (nameString == null) {
			return false;
		}

		for (int i = 0; i < nameString.length(); i++) {
			if (Character.isDigit(nameString.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public static void Question14() {
		/*
		 * Replace character Cho một chuỗi str, chuyển các ký tự được chỉ định sang một
		 * ký tự khác cho trước. Ví dụ: "VTI Academy" chuyển ký tự 'e' sang '*' kết quả
		 * " VTI Acad*my"
		 */

		Scanner sc = new Scanner(System.in);
		String name;
		char ch1, ch2;

		System.out.print("Nhập chuỗi: ");
		name = sc.nextLine();
		System.out.print("Nhập ký tự muốn chuyển: ");
		ch1 = sc.next().toCharArray()[0];

		System.out.print("Nhập ký tự sẽ chuyển: ");
		ch2 = sc.next().toCharArray()[0];

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ch1) {
				name = name.replace(ch1, ch2);
			}
		}

		System.out.println("Chuỗi sau khi chuyển: " + name);

	}

	public static void Question15() {
		/*
		 * Revert string by word Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà
		 * không dùng thư viện. Ví dụ: " I am developer " => "developer am I". Các ký tự
		 * bên trong chỉ cách nhau đúng một dấu khoảng cách. Gợi ý: Các bạn cần loại bỏ
		 * dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chuỗi: ");
		String chuoi = sc.nextLine();

		sc.close();

		chuoi = chuoi.trim();
		chuoi = chuoi.replaceAll("\\s+", " ");

		String[] result = chuoi.split(" ");

		for (int i = result.length - 1; i >= 0; i--) {
			System.out.print(result[i] + " ");
		}
	}

	public static void Quesrion16() {
//		Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//				bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//				hình “KO”.

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập chuỗi: ");
		String chuoi = sc.nextLine();
		System.out.print("Nhập số n: ");
		int a = sc.nextInt();

		if (a <= 0) {
			System.out.println("KO");
			return;
		}

		if (chuoi.length() % a != 0) {
			System.out.println("KO");
		} else {

			int count = chuoi.length() / a;
			for (int i = 0; i < count; i++) {
				String subString = chuoi.substring(i * a, (i + 1) * a);
				System.out.println(subString);
			}
		}

	}
}
