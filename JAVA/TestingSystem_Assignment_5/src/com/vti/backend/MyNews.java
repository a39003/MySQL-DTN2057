package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class MyNews {
	static ArrayList<News> newList = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public void Question1() {
		showMenu();
	}

	public static void showMenu() {
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			System.out.print("Mời bạn chọn: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1: {
				System.out.print("Nhập vào Title: ");
				String title = scanner.nextLine();
				System.out.print("Nhập vào PublishDate: ");
				String publishDate = scanner.nextLine();
				System.out.print("Nhập vào Author: ");
				String author = scanner.nextLine();
				System.out.print("Nhập vào Content: ");
				String content = scanner.next();

				System.out.print("Nhập vào đánh giá 1: ");
				int rate1 = scanner.nextInt();
				System.out.print("Nhập vào đánh giá 2: ");
				int rate2 = scanner.nextInt();
				System.out.print("Nhập vào đánh giá 3: ");
				int rate3 = scanner.nextInt();
				int[] rates = { rate1, rate2, rate3 };
				News news = new News(title, publishDate, author, content, rates);
				newList.add(news);
				break;
			}
			case 2: {
				for (News news1 : newList) {
					news1.display();
				}

			}
			case 3: {
				System.out.println("Đánh giá trung bình rate");
				for (News news1 : newList) {
					System.out.println("Title: " + news1.getTitle() + " Rate: " + news1.calculate());
				}
			}
			case 4: {
				return;
			}
			default:
				System.out.println("Lựa chọn đúng ở menu");
				break;
			}

		}

	}

}
