package com.vti.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.vti.entity.Student;
import com.vti.utils.ScannerUtils;

public class Exercise1_Collectiond {

	public static List<Student> students = new ArrayList<>();
	public static Set<Student> students1 = new LinkedHashSet<>();
	private static int count;

	public static void Question1() {

		int choice;

		do {
			System.out.println("\n------MENU STUDENT-----");
			System.out.println("1. Tạo danh sách student theo số lượng nhập");
			System.out.println("2. In tổng số phần tử");
			System.out.println("3. Lấy phần tử thứ 4");
			System.out.println("4. In phần tử đầu và cuối");
			System.out.println("5. Thêm phần tử vào đầu");
			System.out.println("6. Thêm phần tử vào cuối");
			System.out.println("7. Đảo ngược list");
			System.out.println("8. Tìm theo ID");
			System.out.println("9. Tìm theo Name");
			System.out.println("10. In student có tên trùng");
			System.out.println("11. Xóa name student id=2");
			System.out.println("12. Xóa student id=5");
			System.out.println("13. Copy sang studentCopies");
			System.out.println("0. Thoát");
			System.out.print("Lựa chọn: ");
			choice = ScannerUtils.intputIntPositve();

			switch (choice) {
			case 1:
				System.out.print("Nhập số lượng sinh viên: ");
				int n = ScannerUtils.intputIntPositve();

				for (int i = 0; i < n; i++) {
					System.out.println("Nhập name " + (i + 1) + " : ");
					String name = ScannerUtils.inputString();
					students.add(new Student(name));
				}
				break;
			case 2:// a) In ra tổng số phần tử của students
				System.out.println("Tổng số phần tử: " + students.size());
				break;
			case 3:// b) Lấy phần tử thứ 4 của students
				if (students.size() >= 4) {
					System.out.println("Phần tử thứ 4: " + students.get(3));
				} else {
					System.out.println("List không đủ 4 phần tử!");
				}
				break;
			case 4:// c) In ra phần tử đầu và phần tử cuối của students
				if (students.size() >= 0) {
					System.out.println("Phần tử đầu tiên: " + students.get(0));
					System.out.println("Phần tử cuối cùng: " + students.get(students.size() - 1));
				} else {
					System.out.println("List rỗng");
				}
				break;
			case 5:// d) Thêm 1 phần tử vào vị trí đầu của students
				System.out.println("Nhập tên thêm vào: ");
				students.add(0, new Student(ScannerUtils.inputString()));
				System.out.println("Đã thêm thành công");
				break;
			case 6:// e) Thêm 1 phần tử vào vị trí cuối của students
				System.out.println("Nhập tên muốn thêm: ");
				students.add(new Student(ScannerUtils.inputString()));
				System.out.println("Đã thêm thành công");
				break;
			case 7:// f) Đảo ngược vị trí của students
				Collections.reverse(students);
				System.out.println("Đã đảo ngược thành công");
				break;
			case 8:// g) Tạo 1 method tìm kiếm student theo id
				System.out.print("Nhập id muốn tìm kiếm: ");
				int id = ScannerUtils.intputIntPositve();

				for (Student stu : students) {
					if (stu.getId() == id) {
						System.out.println("Tìm thấy: " + stu);
						return;
					}
				}
				System.out.println("Không tìm thấy");
				break;
			case 9:// h) Tạo 1 method tìm kiếm student theo name
				System.out.print("Nhập tên muốn tìm: ");
				String name = ScannerUtils.inputString();

				for (Student stu : students) {
					if (name.equals(stu.getName())) {
						System.out.println(stu);
					}
				}

				System.out.println("Không thấy");
				break;
			case 10:// i) Tạo 1 method để in ra các student có trùng tên
				System.out.println("Các stundent trùng tên của nhau");
				for (int i = 0; i < students.size(); i++) {
					for (int j = 0; j < students.size(); j++) {
						if (students.get(i).getName() != null
								&& students.get(i).getName().equals(students.get(j).getName())) {
							System.out.println(students.get(i));
							System.out.println(students.get(j));
						}
					}
				}
				break;
			case 11:// j) Xóa name của student có id = 2;
				for (Student student : students) {
					if (student.getId() == 2) {
						student.setName(null);
						System.out.println("Đã xóa thành công id = 2");
						return;
					}
				}
				System.out.println("không tìm thấy id = 2");
				break;
			case 12:// k) Delete student có id = 5;
				students.removeIf(s -> s.getId() == 5);
				System.out.println("Xos thành công id = 5");
				break;
			case 13:// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
					// studentCopies
				List<Student> studentCopies = new ArrayList<>();
				System.out.println("Danh sách studentCopies");
				System.out.println(studentCopies);
			default:
				break;
			}
		} while (choice != 0);

	}

	public static void Question2() {
		List<String> studenttus = Arrays.asList("Nguyễn Văn Nam", "Nguyễn Văn Huyên", "Trần Văn Nam", "Nguyễn Văn A");

		while (true) {
			System.out.println("===== MENU PHỎNG VẤN =====");
			System.out.println("1. In thứ tự tới (sớm -> muộn) - dùng Stack");
			System.out.println("2. In thứ tự tới (muộn -> sớm) - dùng Queue");
			System.out.println("3. Thoát");
			System.out.print("Mời chọn: ");
			int choice = ScannerUtils.intputIntPositve();
			switch (choice) {
			case 1:
				Stack<String> stack = new Stack<>();

				for (int i = studenttus.size() - 1; i >= 0; i--) {
					stack.push(studenttus.get(i));
				}

				System.out.println("-----thứ tự (sớm -> muộn)-------");
				while (!stack.isEmpty()) {
					System.out.println(stack.pop());
				}
				break;

			case 2:
				Queue<String> queue = new LinkedList<>();

				for (String s : studenttus) {
					queue.add(s);
				}

				System.out.println("-----thứ tự (muộn -> sớm)-------");
				List<String> temp = new ArrayList<>(queue);
				for (int i = temp.size() - 1; i >= 0; i--) {
					System.out.println(temp.get(i));
				}
				System.out.println();
				break;

			case 3:
				System.out.println("Tạm biệt!");
				return;

			default:
				System.out.println("Sai lựa chọn, nhập lại!");
			}

		}

	}

	public static void Question3() {
		int choice;

		do {
			System.out.println("\n------MENU STUDENT (SET VERSION)-----");
			System.out.println("1. Tạo danh sách student theo số lượng nhập");
			System.out.println("2. In tổng số phần tử");
			System.out.println("3. Lấy phần tử thứ 4");
			System.out.println("4. In phần tử đầu và cuối");
			System.out.println("5. Thêm phần tử vào đầu");
			System.out.println("6. Thêm phần tử vào cuối");
			System.out.println("7. Đảo ngược set");
			System.out.println("8. Tìm theo ID");
			System.out.println("9. Tìm theo Name");
			System.out.println("10. In student trùng tên");
			System.out.println("11. Xóa name student id = 2");
			System.out.println("12. Xóa student id = 5");
			System.out.println("13. Copy sang studentCopies");
			System.out.println("0. Thoát");
			System.out.print("Lựa chọn: ");
			choice = ScannerUtils.intputIntPositve();

			switch (choice) {

			case 1:
				System.out.print("Nhập số lượng sinh viên: ");
				int n = ScannerUtils.intputIntPositve();

				for (int i = 0; i < n; i++) {
					System.out.print("Nhập name " + (i + 1) + ": ");
					String name = ScannerUtils.inputString();
					students.add(new Student(name));
				}
				break;

			case 2:
				System.out.println("Tổng số phần tử: " + students.size());
				break;

			case 3:
				System.out.println("Phần tử thứ 4 trong Set: ");
				Iterator<Student> iteratorSet3 = students1.iterator();
				for (int i = 0; i <= 2; i++) {
					iteratorSet3.next();
				}
				System.out.println(iteratorSet3.next());
				break;

			case 4:
				Iterator<Student> iteratorSet4 = students1.iterator();
				System.out.println("Phần tử đầu của Set: " + iteratorSet4.next());
				for (int i = 0; i < students1.size() - 2; i++) {
					iteratorSet4.next();
				}
				System.out.println("Phần tử cuối của Set: " + iteratorSet4.next());
				break;

			case 5:
				System.out.println("chưa nghĩ ra thêm vào đầu");
				break;

			case 6:
				System.out.print("Nhập tên muốn thêm vào cuối: ");
				students.add(new Student(ScannerUtils.inputString()));
				System.out.println("Đã thêm thành công");
				break;

			case 7:
				System.out.println("không biết đảo");
				break;

			case 8:
				System.out.print("Nhập id muốn tìm: ");
				int id = ScannerUtils.intputIntPositve();
				for (Student s : students) {
					if (s.getId() == id) {
						System.out.println("Tìm thấy: " + s);
					}
				}
				break;

			case 9:
				System.out.print("Nhập name muốn tìm: ");
				String nameSearch = ScannerUtils.inputString();
				boolean found = false;
				for (Student s : students) {
					if (s.getName() != null && s.getName().equals(nameSearch)) {
						System.out.println(s);
						found = true;
					}
				}
				if (!found) {
					System.out.println("Không thấy");
				}
				break;

			case 10:
				System.out.println("Không có ính viên trung tên");
				break;

			case 11:
				students.forEach(s -> {
					if (s.getId() == 2) {
						s.setName(null);
					}
				});
				System.out.println("Đã xóa name student id=2");
				break;

			case 12:
				students.removeIf(s -> s.getId() == 5);
				System.out.println("Đã xóa student id=5");
				break;

			case 13:
				Set<Student> studentCopies = new LinkedHashSet<>(students);
				System.out.println("Danh sách studentCopies:");
				System.out.println(studentCopies);
				break;

			}

		} while (choice != 0);
	}

	public static void Question4_5() {
		Set<String> students = new LinkedHashSet<>();
		System.out.print("Nhập số lượng sinh viên: ");
		int n = ScannerUtils.intputIntPositve();
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập tên học sinh: " + (i + 1) + " : ");
			String nameAdd = ScannerUtils.inputString();

			if (!students.add(nameAdd)) {
				System.out.println("Học sinh này đã có trong danh sách!");
				i--;
			} else {
				System.out.println("Đã thêm: " + nameAdd);
			}
		}

		System.out.println("Danh sách học sinh:");
		for (String s : students) {
			System.out.println(s);
		}

		List<String> sortedStudents = new ArrayList<>(students);
		Collections.sort(sortedStudents);

		Set<String> sortedSet = new LinkedHashSet<>(sortedStudents);

		System.out.println("\nDanh sách học sinh (không trùng, đã sắp xếp):");
		for (String s : sortedSet) {
			System.out.println(s);
		}
	}

	public static void Question6_7() {
		Map<Integer, String> studentMap = new HashMap<Integer, String>();
		int choice;
		while (true) {
			System.out.println("\n------MENU STUDENT (MAP)-----");
			System.out.println("1. Tạo danh sách student theo số lượng nhập");
			System.out.println("2. In các key của student");
			System.out.println("3. In các vale của student");
			System.out.println("4. In danh sách các student sắp xếp theo tên");
			System.out.println("5. chuyển đổi map sang set");
			System.out.println("6. thoát");
			System.out.print("Chọn: ");
			choice = ScannerUtils.intputIntPositve();

			switch (choice) {
			case 1:
				System.out.print("Nhập số lượng sinh viên:");
				int n = ScannerUtils.intputIntPositve();
				for (int i = 0; i < n; i++) {
					System.out.print("Nhập tên học sinh " + (i + 1) + " : ");
					String name = ScannerUtils.inputString();
					studentMap.put(count++, name);
				}
				System.out.println("-----Danh sách----");
				for (Map.Entry<Integer, String> mapstudent : studentMap.entrySet()) {
					System.out.println("ID: " + mapstudent.getKey() + " Name: " + mapstudent.getValue());
				}

				break;
			case 2:
				System.out.println("Các key trong map: ");
				for (Map.Entry<Integer, String> student : studentMap.entrySet()) {
					System.out.println(student.getKey());
				}
				break;
			case 3:
				System.out.println("Các value trong map: ");
				for (Map.Entry<Integer, String> student : studentMap.entrySet()) {
					System.out.println(student.getValue());
				}
				break;
			case 4:
				System.out.println("---Danh sách sắp xếp theo tên----");
				studentMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
						.forEach(entry -> System.out.println("ID: " + entry.getKey() + " Name: " + entry.getValue()));
				break;
			case 5:
				System.out.println("Chuyển map sang set");
				Set<Map.Entry<Integer, String>> setStundent = studentMap.entrySet();
				for (Map.Entry<Integer, String> entry : setStundent) {
					System.out.println(entry);
				}

				break;
			case 6:
				System.out.println("Thoát chương trình.........");
				return;
			default:
				System.out.println("chọn sai !");
				break;
			}
		}

	}

}
