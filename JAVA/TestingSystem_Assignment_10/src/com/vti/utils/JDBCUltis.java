package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUltis {
	private Properties properties;
	private Connection connection;

	public JDBCUltis() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(
				"D:\\BTMySQL\\MySQL-DTN2057\\JAVA\\TestingSystem_Assignment_10\\src\\com\\vti\\resources\\database.properties"));
	}

//in thông báo kết nối thành công
	public void connectionTestting() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String dirver = properties.getProperty("driver");

		Class.forName(dirver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect Success");

	}

//Kết nối đến database
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String Username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String dirver = properties.getProperty("driver");
		Class.forName(dirver);
		connection = DriverManager.getConnection(url, Username, password);
		return connection;
	}

//đóng sql
	public void disConnection() throws SQLException {
		connection.close();
	}

//Thực thi câu lệnh SELECT (executeQuery)
	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		Statement statement = connnection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		return result;
	}

//Tạo PreparedStatement (dùng cho INSERT, UPDATE, DELETE có tham số)
	public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
		Connection connnection = getConnection();
		PreparedStatement preStatement = connnection.prepareStatement(sql);
		return preStatement;
	}

}
