package Backend;

import com.vti.entity.Account2;
import com.vti.entity.Circle;
import com.vti.entity.Date;
import com.vti.entity.Student;

public class Encapsulation {
	public void printSudent() {
		Student st1 = new Student("Nam1", "h2");
		st1.plusScore(1f);
		Student st2 = new Student("Nam2", "h3");
		st2.plusScore(5f);
		Student st3 = new Student("Nam3", "h4");
		st3.plusScore(9f);

		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}

	public void Question2() {
		System.out.println("---------Circle----------------");
		Circle circle = new Circle(2.0, "red");
		System.out.println(circle);
		System.out.println("Diện tích hình tròn là: " + circle.getArea());

		System.out.println("------Account2-----------");
		Account2 account2_1 = new Account2("1", "Phạm Minh Hiếu", 5000);
		Account2 account2_2 = new Account2("2", "Phạm Minh Tâm", 2000);

		System.out.println(
				"Số tiền lúc đầu: account2_1: " + account2_1.getBalance() + " accont1_2: " + account2_2.getBalance());
		account2_1.credit(50);
		System.out.println("Balace của account1_1 sau khi Credit 50: " + account2_1.getBalance());
		account2_2.debit(20);
		System.out.println("Balace của account1_2 sau khi Debit 20: " + account2_2.getBalance());
		System.out.print("account1_1 chuyển 20 cho account1_2: ");
		account2_1.tranfer(account2_2, 20);
		System.out.println("");

		System.out.println("-------Date-------------");
		Date date1 = new Date(28, 03, 2024);
		System.out.println("Năm bạn vừa nhập: " + date1);
		System.out.print("check năm nhuận: ");
		if (date1.isLeapYear()) {
			System.out.println("Đây là năm nhuận");
		} else {
			System.out.println("Đây không phải năm nhuận");
		}
	}
}
