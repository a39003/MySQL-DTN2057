package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.DepartmentDao;
import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class Exercise2_CRUD {

	private DepartmentDao departmentDao;

	public Exercise2_CRUD() throws FileNotFoundException, IOException {
		departmentDao = new DepartmentDao();
	}

	public void Question1() throws ClassNotFoundException, SQLException {
		List<Department> departments = departmentDao.getListDepartment();
		String format = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");
		for (Department d : departments) {
			System.out.format(format, d.getId(), d.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public void Question2() throws ClassNotFoundException, SQLException {
		System.out.println("thông tin Department có id = 5.");
		Department department = departmentDao.getDepByID_5();
		String format = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");
		System.out.format(format, department.getId(), department.getName());
		System.out.format("+--------+-----------------------+%n");
	}

	public void Question3() throws ClassNotFoundException, SQLException {
		System.out.println("thông tin Department theo id.");
		System.out.print("Nhập id: ");
		int n = ScannerUtils.inputIntPositive();
		Department department = departmentDao.getDepByID(n);
		String format = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");
		System.out.format(format, department.getId(), department.getName());
		System.out.format("+--------+-----------------------+%n");
	}

	public void Question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra xem phòng có trên hệ thống hay không.");
		System.out.print("Nhập tên phòng: ");
		String namecheck = ScannerUtils.inputString();
		Boolean checkdep = departmentDao.isDepartmentNameExists(namecheck);
		if (checkdep) {
			System.out.println("Phòng ban có trên hệ thống");
		} else {
			System.out.println("Phòng ban không có trên hệ thống.");
		}
	}

	public void Question5() throws ClassNotFoundException, SQLException {
		System.out.println("Tạo mới Department");
		System.out.print("Nhập tên phòng ban: ");
		String namedep = ScannerUtils.inputString();
		Boolean department = departmentDao.createDepartment(namedep);

		if (department) {
			System.out.println("Create Department Success!");
			Question1();
		} else {
			System.out.println("Thêm không thành công");
		}
	}

	public void Question6() throws ClassNotFoundException, SQLException {
		System.out.println("Update department.");
		int updateId = getIDUpdate();
		System.out.println("Nhâp tên cần Update: ");
		String nameUpdate = ScannerUtils.inputString();
		if (departmentDao.updateDepartmentName(updateId, nameUpdate)) {
			System.out.println("Update tên phòng thành công");
			Question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private int getIDUpdate() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhạp Id: ");
			int id = ScannerUtils.inputIntPositive();
			Department department = departmentDao.getDepByID(id);
			if (department == null) {
				System.out.println("Không có id này");
			} else {
				return id;
			}
		}
	}

	public void Question7() throws ClassNotFoundException, SQLException {
		Question1();
		int deleteID = getIDUpdate();
		if (departmentDao.deleteID(deleteID)) {
			System.out.println("Xóa phòng thành công");
			Question1();
		} else {
			System.out.println("Lỗi");
		}

	}

}
