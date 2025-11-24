package Backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Constructors {
	public static void main(String[] args) {
		Question1();
		Question2();
	}

	public static void Question1() {
		Department department = new Department();
		Department department2 = new Department("Dep1");
		System.out.println(department2);
	}

	public static void Question2() {
		Account acc1 = new Account();
		Account acc2 = new Account(2, "email2", "username2", "fullname2");
		Position pos3 = new Position();
		Account acc3 = new Account(3, "email3", "username3", "fullname3", pos3);
		System.out.println(acc3.CreateDate);

		Position pos4 = new Position();
		Account acc4 = new Account(3, "email3", "username3", "fullname3", pos4, LocalDate.of(2021, 03, 17));

		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println(acc4);
	}

	public static void Question3() {
		Group group1 = new Group();

	}
}
