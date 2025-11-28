package Frondend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Article;
import com.vti.entity.ClassBook;
import com.vti.entity.Magazine;

import Backend.Inheritanced;

public class Exercis5_Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Inheritanced inheritanced = new Inheritanced();
		int choce;

		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Thêm tài liệu");
			System.out.println("2. Xóa theo mã");
			System.out.println("3. Hiển thị tài liệu");
			System.out.println("4. Tìm theo loại");
			System.out.println("5. Thoát");
			System.out.print("Chọn: ");
			choce = sc.nextInt();
			sc.nextLine();

			switch (choce) {
			case 1: {
				System.out.print("Chọn loại: 1-Sách, 2-Tạp chí, 3-Báo: ");
				int loai = sc.nextInt();
				sc.nextLine();
				System.out.print("Mã tài liệu: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("NXB: ");
				String publisher = sc.nextLine();

				System.out.print("Số bản PH: ");
				int numRelease = sc.nextInt();
				sc.nextLine();

				if (loai == 1) {
					System.out.print("Tên tác giả: ");
					String authorName = sc.nextLine();
					System.out.print("Số trang: ");
					int numberPage = sc.nextInt();
					inheritanced.themtailieu(new ClassBook(id, publisher, numRelease, authorName, numberPage));

				} else if (loai == 2) {
					System.out.print("Số phát hành: ");
					int idRelease = sc.nextInt();
					System.out.println("Nhập vào ngày phát hành: ");
					int day = sc.nextInt();
					System.out.println("Nhập vào tháng phát hành: ");
					int month = sc.nextInt();
					System.out.println("Nhập vào năm phát hành: ");
					int year = sc.nextInt();
					LocalDate monthRelease = LocalDate.of(year, month, day);
					inheritanced.themtailieu(new Magazine(id, publisher, numRelease, idRelease, monthRelease));
					;

				} else {
					System.out.println("Nhập vào ngày phát hành: ");
					int day1 = sc.nextInt();
					System.out.println("Nhập vào tháng phát hành: ");
					int month1 = sc.nextInt();
					System.out.println("Nhập vào năm phát hành: ");
					int year1 = sc.nextInt();
					LocalDate dayRelease = LocalDate.of(year1, month1, month1);
					inheritanced.themtailieu(new Article(id, publisher, numRelease, dayRelease));
				}
				break;

			}
			case 2: {
				System.out.print("Nhập mã cần xóa: ");
				int delMa = sc.nextInt();
				inheritanced.xoatailieutheoma(delMa);
				break;
			}
			case 3: {
				inheritanced.showdanhsachtailieu();
				break;
			}
			case 4:
				System.out.println("1-Sách, 2-Tạp chí, 3-Báo");
				int t = sc.nextInt();
				if (t == 1) {
					inheritanced.timkiem(ClassBook.class);
				}
				if (t == 2) {
					inheritanced.timkiem(Magazine.class);
				}
				if (t == 3) {
					inheritanced.timkiem(Article.class);
				}
				break;

			case 5:
				System.out.println("Thoát khỏi chương trình....");
				break;
			}

		} while (choce != 5);
	}
}
