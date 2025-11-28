package Frondend;

import java.util.Scanner;

import com.vti.entity.CacNhanVien;
import com.vti.entity.CanBo.Gender;
import com.vti.entity.CapCongNhan;
import com.vti.entity.CapKySu;

import Backend.Inheritanced;

public class Exercise_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Inheritanced inheritanced = new Inheritanced();

		int choce;
		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Thêm cán bộ");
			System.out.println("2. Tìm theo tên");
			System.out.println("3. Hiển thị danh sách");
			System.out.println("4. Xóa theo tên");
			System.out.println("5. Thoát");
			System.out.print("Chọn: ");
			choce = scanner.nextInt();
			scanner.nextLine();

			switch (choce) {
			case 1: {
				System.out.print("Chọn Loại cán bộ (1-Công Nhân, 2-Kỹ sư, 3-Nhân Viên): ");
				int type = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Họ tên: ");
				String name = scanner.nextLine();
				System.out.print("Tuổi: ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Chọn giới tính 1.Male, 2.Female, 3.Unknown: ");
				int gender = scanner.nextInt();
				scanner.nextLine();
				Gender gender2 = null;
				switch (gender) {
				case 1: {
					gender2 = Gender.MALE;
					break;
				}
				case 2: {
					gender2 = Gender.FEMALE;
				}
				case 3: {
					gender2 = Gender.UNKNOWN;
				}

				}
				System.out.print("Địa chỉ: ");
				String adress = scanner.nextLine();

				if (type == 1) {
					System.out.print("Bậc: ");
					int rank = scanner.nextInt();
					inheritanced.themcanbo(new CapCongNhan(name, age, gender2, adress, rank));
				} else if (type == 2) {
					System.out.print("Ngành đào tạo: ");
					String specialized = scanner.nextLine();
					inheritanced.themcanbo(new CapKySu(name, age, gender2, adress, specialized));
				} else if (type == 3) {
					System.out.print("Công việc: ");
					String task = scanner.nextLine();
					inheritanced.themcanbo(new CacNhanVien(name, age, gender2, adress, task));
				}
				break;
			}
			case 2: {
				System.out.print("Nhập tên cần tìm: ");
				inheritanced.timtheoten(scanner.nextLine());
				break;
			}

			case 3: {
				inheritanced.hienthiDS();
				break;
			}
			case 4: {
				System.out.print("Nhập tên cần xóa: ");
				inheritanced.xoatheoten(scanner.nextLine());
				break;
			}
			case 5: {
				System.out.println("Thoát chương trình.....");
				break;
			}
			}

		} while (choce != 5);
	}
}
