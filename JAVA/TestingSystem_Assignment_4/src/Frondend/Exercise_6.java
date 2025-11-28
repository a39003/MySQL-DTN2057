package Frondend;

import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Waiter;

public class Exercise_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===== MENU =====");
			System.out.println("1. Nhập Employee");
			System.out.println("2. Nhập Manager");
			System.out.println("3. Nhập Waiter");
			System.out.println("4. Thoát");
			System.out.print("Chọn chức năng: ");

			int choose = Integer.parseInt(sc.nextLine());

			switch (choose) {

			case 1: {
				System.out.print("Nhập tên Employee: ");
				String nameE = sc.nextLine();
				System.out.print("Nhập hệ số lương: ");
				double srE = Double.parseDouble(sc.nextLine());
				Employee employee = new Employee(nameE, srE);
				employee.displayInfor();

				break;
			}
			case 2: {
				System.out.print("Nhập tên Manager: ");
				String nameM = sc.nextLine();
				System.out.print("Nhập hệ số lương: ");
				double srM = Double.parseDouble(sc.nextLine());
				Manager manager = new Manager(nameM, srM);
				manager.displayInfor();
				break;
			}
			case 3: {
				System.out.print("Nhập tên Waiter: ");
				String nameW = sc.nextLine();
				System.out.print("Nhập hệ số lương: ");
				double srW = Double.parseDouble(sc.nextLine());
				Waiter waiter = new Waiter(nameW, srW);
				waiter.displayInfor();
				break;
			}

			case 4: {
				System.out.println("Thoát chương trình...");
				return;

			}
			default:
				System.out.println(" Lựa chọn không hợp lệ!");
			}
		}

	}
}
