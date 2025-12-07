package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.AccountDao;
import com.vti.dao.DepartmentDao;
import com.vti.dao.PositionDao;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.ScannerUtils;

public class Exercise2_Account {

	private AccountDao accountDao;

	public Exercise2_Account() throws FileNotFoundException, IOException {
		accountDao = new AccountDao();
	}

	public void Question1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> listAcc1 = accountDao.getListAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		for (Account acc : listAcc1) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullName(),
					acc.getDepartment(), acc.getPosition(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

	}

	public void Question2() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm thông tin Account có ID =5");
		Account account = accountDao.getAccByID_5();
		if (account != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

			System.out.format(leftAlignFormat, account.getId(), account.getEmail(), account.getUsername(),
					account.getFullName(), account.getDepartment(), account.getPosition(), account.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}

	public void Question3() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Tìm thông tin Account theo ID");
		System.out.print("Nhập ID cần tìm: ");
		int id = ScannerUtils.inputIntPositive();
		Account account = accountDao.getAccByID(id);
		if (account != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Position         | Create Date      |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

			System.out.format(leftAlignFormat, account.getId(), account.getEmail(), account.getUsername(),
					account.getFullName(), account.getDepartment(), account.getPosition(), account.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}

	}

	public void Question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra xem account có trên hệ thống hay không.");
		System.out.print("Nhập tên account: ");
		String namecheck = ScannerUtils.inputString();
		Boolean checkdep = accountDao.isAccountNameExists(namecheck);
		if (checkdep) {
			System.out.println("Account có trên hệ thống");
		} else {
			System.out.println("Account không có trên hệ thống.");
		}

	}

	public void Question5() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Account acc = new Account();
		System.out.println("Nhập vào Email: ");
		acc.setEmail(ScannerUtils.inputString());
		System.out.println("Nhập vào UserName: ");
		acc.setUsername(ScannerUtils.inputString());
		System.out.println("Nhập vào FullName: ");
		acc.setFullName(ScannerUtils.inputString());
		System.out.println("Hãy chọn phòng nhân viên: ");
		int depid = getDep();
		System.out.println("Hãy chọn Position nhân viên: ");
		int posid = getPos();
//		System.out.print("Nhập ngày tháng năm: ");
//		acc.setCreateDate(ScannerUtils.inputLocalDate());
		if (accountDao.createAccount(acc, depid, posid)) {
			System.out.println("Tạo thành công: ");
			Question1();
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}

	}

	private int getPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			PositionDao posDAO = new PositionDao();

			List<Position> listpos = posDAO.getListPosition();

			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getID(), position.getPositionName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.print("Chọn Position theo ID:");
			int choosePos = ScannerUtils.inputIntPositive();
			;
			if (posDAO.getPosByID(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có Position này, hãy chọn lại: ");
			}
		}

	}

	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDao depDAO = new DepartmentDao();
			List<Department> listDep = depDAO.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.print("Chọn phòng theo ID:");
			int chooseDep = ScannerUtils.inputIntPositive();

			if (depDAO.getDepByID(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại: ");
			}
		}

	}

	public void Question6() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			switch (getMenuQuestion6()) {
			case 1:
				int id = getIdUpdate();
				System.out.println("Nhập vào New Email: ");
				String newEmail = ScannerUtils.inputString();
				if (accountDao.updateByEmai(id, newEmail)) {
					System.out.println("Update thành công.");
					Question1();
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 2:
				int id2 = getIdUpdate();
				System.out.println("Nhập vào New UserName: ");
				String newUserName = ScannerUtils.inputString();
				if (accountDao.updateByUserName(id2, newUserName)) {
					System.out.println("Update thành công.");
					Question1();
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 3:
				int id3 = getIdUpdate();
				System.out.println("Nhập vào New FullName: ");
				String newFullName = ScannerUtils.inputString();
				if (accountDao.updateByFullName(id3, newFullName)) {
					System.out.println("Update thành công.");
					Question1();
				} else {
					System.out.println("update không thành công, kiểm tra lại.");
				}
				break;
			case 4:
				int id4 = getIdUpdate();
				int idDep = getNewIDDep();
				if (accountDao.updateByDepId(id4, idDep)) {
					System.out.println("Update thành công.");
					Question1();
				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 5:
				int id5 = getIdUpdate();
				int idPos = getNewIDPos();
				if (accountDao.updateByPosId(id5, idPos)) {
					System.out.println("Update thành công.");
					Question1();
				} else {
					System.out.println("Có lỗi xảy ra, Hãy kiểm tra lại");
				}
				break;
			case 6:
				return;
			}
		}

	}

	private int getNewIDPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentDao depDAO = new DepartmentDao();
		System.out.println("Chọn Position:");
		while (true) {
			PositionDao posDAO = new PositionDao();
			List<Position> listpos = posDAO.getListPosition();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listpos) {
				System.out.format(leftAlignFormat, position.getID(), position.getPositionName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của Position cần Update:");
			int id = ScannerUtils.inputIntPositive();
			if (posDAO.getPosByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có Position này, hãy nhập lại: ");
			}
		}
	}

	private int getNewIDDep() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		DepartmentDao depDAO = new DepartmentDao();
		System.out.println("Chọn phòng");
		while (true) {
			List<Department> listDep = depDAO.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listDep) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn ID của phòng cần Update:");
			int id = ScannerUtils.inputIntPositive();
			if (depDAO.getDepByID(id) != null) {
				return id;
			} else {
				System.out.println("Không có phòng này, hãy nhập lại: ");
			}
		}

	}

	private int getIdUpdate() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			System.out.print("Nhập id cần update: ");
			int id = ScannerUtils.inputIntPositive();
			if (accountDao.getAccByID(id) != null) {
				return id;
			} else {
				System.out.println("Không thấy account này.");
			}
		}
	}

	private int getMenuQuestion6() {
		while (true) {
			System.out.println("Bạn muốn update trường nào.");
			System.out.println("1.Email, 2.UserName, 3.FullName, 4. Department, 5. Position, 6.Exit");
			int i = ScannerUtils.inputIntPositive();
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
				return i;
			} else {
				System.out.println("Chọn lại: ");
			}
		}
	}

	public void Question7() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Question1();
		int deleteID = getIdUpdate();
		if (accountDao.deleteID(deleteID)) {
			System.out.println("Xóa account thành công");
			Question1();
		} else {
			System.out.println("Lỗi");
		}

	}

}
