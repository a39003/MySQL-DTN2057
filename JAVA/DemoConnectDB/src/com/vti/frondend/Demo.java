package com.vti.frondend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// load dữ liệu từ file database.properties

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(
					"D:\\BTMySQL\\MySQL-DTN2057\\JAVA\\DemoConnectDB\\src\\com\\vti\\resources\\database.properties"));
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Connection connection = DriverManager.getConnection(url, username, password);
			// thêm department
			// addNewDepratemnt(connection);
			// Sửa
			// updateDepartment(connection);
			// xóa
//			deleteDepartment(connection);
			getDepartemntlist(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteDepartment(Connection connection) throws SQLException {
		System.out.print("Nhập id muốn xóa: ");
		int deleteID = ScannerUtils.inputIntPositive();

		String sqlDeleteDepartment = "DELETE FROM Department WHERE DepartmentID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteDepartment);
		preparedStatement.setInt(1, deleteID);

		int rowDelte = preparedStatement.executeUpdate();
		if (rowDelte > 0) {
			System.out.println("Xóa thành công ");
		} else {
			System.out.println("không tìm thấy id");
		}

	}

	private static void updateDepartment(Connection connection) throws SQLException {
		System.out.print("Nhập ID muốn sửa: ");
		int id = ScannerUtils.inputIntPositive();
		System.out.print("Nhập tên mới: ");
		String nameUpdate = ScannerUtils.inputString();

		String sqlupdateDepartment = "UPDATE Department SET DepartmentName=? WHERE DepartmentID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlupdateDepartment);
		preparedStatement.setString(1, nameUpdate);
		preparedStatement.setInt(2, id);

		int rowUpdate = preparedStatement.executeUpdate();
		if (rowUpdate > 0) {
			System.out.println("Cập nhập thành công");
		} else {
			System.out.println("không thấy id");
		}

	}

	private static void addNewDepratemnt(Connection connection) throws SQLException {
		// thực thi các câu lệnh không tham số
		System.out.println("Nhập tên phòng ban: ");
		String data_Departmetn = ScannerUtils.inputString();

		String sqlInsertDepartmnet = "INSERT INTO department(DepartmentName) VALUES (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertDepartmnet);
		preparedStatement.setString(1, data_Departmetn);

		int resultInsert = preparedStatement.executeUpdate();
		System.out.println("resultInsert: " + resultInsert);
	}

	private static void getDepartemntlist(Connection connection) throws SQLException {
		Statement sleStatement = connection.createStatement();
		String selecSQL = "SELECT * from Department ORDER BY DepartmentID;";
		ResultSet rsResultSet = sleStatement.executeQuery(selecSQL);// lấy được dữ liệu từ department
		// chuyển đổi Resutl set sang list<Department>
		List<Department> departmentList = new ArrayList<>();

		while (rsResultSet.next()) {
			Department department = new Department();
			department.setId(rsResultSet.getInt("DepartmentID"));
			department.setName(rsResultSet.getString("DepartmentName"));
			departmentList.add(department);
		}

		// In danh sách phòng ban
		System.out.println("\n=== Department List ===");
		for (Department dept : departmentList) {
			System.out.println(dept);
		}
		rsResultSet.close();
	}
}
