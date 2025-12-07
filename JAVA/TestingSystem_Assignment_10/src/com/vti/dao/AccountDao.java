package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.JDBCUltis;

public class AccountDao {
	private JDBCUltis jdbcUltis;

	public AccountDao() throws FileNotFoundException, IOException {
		jdbcUltis = new JDBCUltis();
	}

	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM account ORDER BY AccountID";
		ResultSet resultSet = jdbcUltis.executeQuery(sql);
		List<Account> listAcc = new ArrayList<Account>();
		while (resultSet.next()) {
			Account account = new Account();
			account.setID(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentDao deparDao = new DepartmentDao();
			Department department = deparDao.getDepByID(resultSet.getInt(5));
			account.setDepartment(department);

			PositionDao positionDao = new PositionDao();
			Position position = positionDao.getPosByID(resultSet.getInt(6));
			account.setPosition(position);

			Date localDate = resultSet.getDate(7);

			if (localDate != null) {
				account.setCreateDate(localDate.toLocalDate());
			} else {
				account.setCreateDate(null);
			}

			listAcc.add(account);
		}
		jdbcUltis.disConnection();
		return listAcc;

	}

	public Account getAccByID_5() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = 5";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setID(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentDao deparDao = new DepartmentDao();
			Department department = deparDao.getDepByID(resultSet.getInt(5));
			account.setDepartment(department);

			PositionDao positionDao = new PositionDao();
			Position position = positionDao.getPosByID(resultSet.getInt(6));
			account.setPosition(position);

			Date localDate = resultSet.getDate(7);

			if (localDate != null) {
				account.setCreateDate(localDate.toLocalDate());
			} else {
				account.setCreateDate(null);
			}

			return account;
		}
		return null;

	}

	public Account getAccByID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setID(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentDao deparDao = new DepartmentDao();
			Department department = deparDao.getDepByID(resultSet.getInt(5));
			account.setDepartment(department);

			PositionDao positionDao = new PositionDao();
			Position position = positionDao.getPosByID(resultSet.getInt(6));
			account.setPosition(position);

			Date localDate = resultSet.getDate(7);

			if (localDate != null) {
				account.setCreateDate(localDate.toLocalDate());
			} else {
				account.setCreateDate(null);
			}

			return account;
		}
		jdbcUltis.disConnection();
		return null;
	}

	public Boolean isAccountNameExists(String namecheck) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Username = ?";
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

	public boolean createAccount(Account acc, int depid, int posid) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setNString(1, acc.getEmail());
		preparedStatement.setNString(2, acc.getUsername());
		preparedStatement.setNString(3, acc.getFullName());
		preparedStatement.setInt(4, depid);
		preparedStatement.setInt(5, posid);
//		preparedStatement.setDate(6, java.sql.Date.valueOf(acc.getCreateDate()));
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET Email = ? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setString(1, newEmail);
		preparedStatement.setInt(2, id);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateByUserName(int id2, String newUserName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET Username = ? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setString(1, newUserName);
		preparedStatement.setInt(2, id2);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateByFullName(int id3, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET FullName = ? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setString(1, newFullName);
		preparedStatement.setInt(2, id3);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateByDepId(int id4, int idDep) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET DepartmentID = ? WHERE (AccountID = ?);";
		PreparedStatement preparedStatement = jdbcUltis.createPrepareStatement(sql);
		preparedStatement.setInt(1, idDep);
		preparedStatement.setInt(2, id4);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean updateByPosId(int id5, int idPos) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET PositionID = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUltis.createPrepareStatement(sql);
		preStatement.setInt(1, idPos);
		preStatement.setInt(2, id5);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUltis.disConnection();
			return true;
		} else {
			jdbcUltis.disConnection();
			return false;
		}

	}

	public boolean deleteID(int deleteID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Account account = getAccByID(deleteID);
		if (account == null) {
			return false;
		} else {
			String sql = "DELETE FROM account WHERE (AccountID = ?);";
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
