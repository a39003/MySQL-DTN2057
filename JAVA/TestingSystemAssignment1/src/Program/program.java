package Program;

import java.time.LocalDate;

import com.vti.Account.account;
import com.vti.Departemnt.departemnt;
import com.vti.Group.group;
import com.vti.Position.PositionName;
import com.vti.Position.position;

public class program {
	public static void main(String[] args) {
		// ====== Departemnt ======
		departemnt Departemnts1 = new departemnt();
		Departemnts1.DepartemntID = 1;
		Departemnts1.DepartmentName = "sale";

		departemnt Departemnts2 = new departemnt();
		Departemnts2.DepartemntID = 2;
		Departemnts2.DepartmentName = "marketing";

		departemnt Departemnts3 = new departemnt();
		Departemnts3.DepartemntID = 3;
		Departemnts3.DepartmentName = "IT";

		departemnt[] Departemnts = { Departemnts1, Departemnts2, Departemnts3 };

		// ====== Position ======
		position Position1 = new position();
		Position1.PositionID = 1;
		Position1.name = PositionName.Dev;

		position Position2 = new position();
		Position2.PositionID = 2;
		Position2.name = PositionName.PM;

		position Position3 = new position();
		Position3.PositionID = 3;
		Position3.name = PositionName.Scrum_Master;

		position[] Positions = { Position1, Position2, Position3 };

		// ====== Account ======
		account Account1 = new account();
		Account1.AccountID = 1;
		Account1.Email = "anh@gmail.com";
		Account1.Username = "Anh";
		Account1.FullName = "Nguyễn Tuấn Anh";
		Account1.Departemnt = Departemnts[0];
		Account1.Position = Positions[0];
		Account1.CreateDate = LocalDate.now();

		account Account2 = new account();
		Account2.AccountID = 2;
		Account2.Email = "tuan@gmail.com";
		Account2.Username = "Tuan";
		Account2.FullName = "Nguyễn Đức Tuấn";
		Account2.Departemnt = Departemnts[1];
		Account2.Position = Positions[1];
		Account2.CreateDate = LocalDate.now();

		account Account3 = new account();
		Account3.AccountID = 3;
		Account3.Email = "hieu@gmail.com";
		Account3.Username = "Hiếu";
		Account3.FullName = "Phạm Minh Hiếu";
		Account3.Departemnt = Departemnts[2];
		Account3.Position = Positions[2];
		Account3.CreateDate = LocalDate.now();

		account[] Accounts = { Account1, Account2, Account3 };

		// ====== Group ======
		group Group1 = new group();
		Group1.GroupID = 1;
		Group1.GroupName = "MySQL";
		Group1.Creator = Accounts[0];
		Group1.CreateDate = LocalDate.now();

		group Group2 = new group();
		Group2.GroupID = 2;
		Group2.GroupName = "Java";
		Group2.Creator = Accounts[1];
		Group2.CreateDate = LocalDate.now();

		group Group3 = new group();
		Group3.GroupID = 3;
		Group3.GroupName = "JavCore";
		Group3.Creator = Accounts[2];
		Group3.CreateDate = LocalDate.now();

		group[] Groups = { Group1, Group2, Group3 };

		System.out.println("1 Department: " + Departemnts[1].DepartmentName);
		System.out.println("2 Position: " + Positions[0].name);
		System.out.println("3 Account: " + Accounts[2].Email + " " + Accounts[2].FullName + " - Department: "
				+ Accounts[2].Departemnt.DepartmentName + " - Position: " + Accounts[2].Position.name + " "
				+ Accounts[2].CreateDate);
		System.out.println("4 Group: " + Groups[0].GroupName + " - Creator: " + Groups[0].Creator.FullName + " "
				+ Groups[0].CreateDate);
	}
}
