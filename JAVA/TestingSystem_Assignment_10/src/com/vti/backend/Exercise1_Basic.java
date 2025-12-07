package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.JDBCUltis;
import com.vti.utils.ScannerUtils;

public class Exercise1_Basic {
	private JDBCUltis jdbc;

	public Exercise1_Basic() throws FileNotFoundException, IOException {
		jdbc = new JDBCUltis();
	}

	public void Question1() throws ClassNotFoundException, SQLException {
		System.out.println("Kết nối.");
		jdbc.connectionTestting();
	}

	public void Question2() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position;";
		ResultSet posResultSet = jdbc.executeQuery(sql);
		System.out.println("Thông tin của Position");
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | PositionName          |%n");
		System.out.format("+--------+-----------------------+%n");
		while (posResultSet.next()) {
			System.out.format(leftAlignFormat, posResultSet.getInt(1), posResultSet.getString(2));
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public void Question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tạo position mới");
		String sql = "INSERT INTO Position (PositionName) VALUES (?)";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		System.out.println("chọn Position cần tạo (1.Dev, 2.Test, 3.Scrum-Master, 4.PM: )");
		String name = getName();
		preparedStatement.setString(1, name);
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Tạo thành công");
			Question2();
		} else {
			System.out.println("Lỗi");
		}

	}

	private String getName() {
		while (true) {
			switch (ScannerUtils.inputIntPositive()) {
			case 1:
				return "Dev";
			case 2:
				return "Test";
			case 3:
				return "Scrum Master";
			case 4:
				return "PM";

			default:
				System.out.print("Nhập lại: ");
				break;
			}
		}
	}

	public void Question4() throws ClassNotFoundException, SQLException {
		System.out.println("Update tên của Position: ");
		System.out.println("Danh sách Position: ");
		Question2();
		System.out.println("Chọn ID cần update");
		int id = ScannerUtils.inputIntPositive();
		System.out.println("Chọn tên Positon cần update: 1.Dev, 2.Test, 3.Scrum Master, 4.PM: ");
		String newName = getName();
		String sql = "UPDATE position SET PositionName = ? WHERE (PositionID = ?);";
		PreparedStatement pre4 = jdbc.createPrepareStatement(sql);
		pre4.setString(1, newName);
		pre4.setInt(2, id);
		if (pre4.executeUpdate() == 1) {
			System.out.println("Update thành công");
			Question2();
		} else {
			System.out.println("Có lỗi xảy ra");
		}

	}

	public void Question5() throws ClassNotFoundException, SQLException {
		System.out.println("Xóa postion theo ID");
		Question2();
		System.out.println("Chọn ID cần xóa:");
		int id = ScannerUtils.inputIntPositive();
		String sql = "DELETE FROM position WHERE (PositionID = ?);";
		PreparedStatement pre5 = jdbc.createPrepareStatement(sql);
		pre5.setInt(1, id);
		if (pre5.executeUpdate() == 1) {
			System.out.println("Xóa thành công");
			Question2();
		} else {
			System.out.println("Xóa không thành công");
			Question2();
		}
	}

	public void Question6() throws ClassNotFoundException, SQLException {
		System.out.print("Nhập ID: ");
		int positionID = ScannerUtils.inputIntPositive();

		String sql = "SELECT * FROM Position WHERE PositionID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, positionID);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String format = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(format, resultSet.getInt("PositionID"), resultSet.getString("PositionName"));
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tìm thấy Position với ID = " + positionID);
		}

	}

}
