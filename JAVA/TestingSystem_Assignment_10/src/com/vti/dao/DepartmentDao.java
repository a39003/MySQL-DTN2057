package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JDBCUltis;

public class DepartmentDao {

	private JDBCUltis jdbcUltis;

	public DepartmentDao() throws FileNotFoundException, IOException {
		jdbcUltis = new JDBCUltis();
	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		String selecSQL = "SELECT * from Department ORDER BY DepartmentID;";
		ResultSet resultSet = jdbcUltis.executeQuery(selecSQL);
		List<Department> listDepar = new ArrayList<Department>();
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentID"));
			department.setName(resultSet.getString("DepartmentName"));
			listDepar.add(department);
		}
		return listDepar;

	}

	public Department getDepByID_5() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = 5";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			Department dep = new Department(result.getInt("DepartmentID"), result.getNString("DepartmentName"));
			return dep;
		}
		jdbcUltis.disConnection();
		return null;
	}

	public Department getDepByID(int n) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setInt(1, n);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			Department dep = new Department(result.getInt("DepartmentID"), result.getNString("DepartmentName"));
			return dep;
		}
		jdbcUltis.disConnection();
		return null;
	}

	public Boolean isDepartmentNameExists(String namecheck) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setString(1, namecheck);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public Boolean createDepartment(String namedep) throws ClassNotFoundException, SQLException {

		if (isDepartmentNameExists(namedep)) {
			System.out.println("Department name already exists! ");
			return false;
		}

		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setString(1, namedep);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateDepartmentName(int updateId, String nameUpdate) throws SQLException, ClassNotFoundException {
		Department departmentId = getDepByID(updateId);
		if (departmentId == null) {
			return false;
		} else {
			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?)";
			PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
			preparedStatement.setNString(1, nameUpdate);
			preparedStatement.setInt(2, updateId);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				jdbcUltis.disConnection();
				return true;
			} else {
				jdbcUltis.disConnection();
				return false;
			}
		}
	}

	public boolean deleteID(int deleteID) throws ClassNotFoundException, SQLException {
		Department departmentDe = getDepByID(deleteID);
		if (departmentDe == null) {
			return false;
		} else {
			String sql = "DELETE FROM department WHERE (DepartmentID = ?);";
			PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
			preparedStatement.setInt(1, deleteID);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				jdbcUltis.disConnection();
				return true;
			} else {
				jdbcUltis.disConnection();
				return false;
			}
		}

	}

}
