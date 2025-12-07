package com.vti.entity;

public class Position {
	public static int countpos = 0;
	public int ID;
	public String PositionName;

	public Position(int iD, String positionName) {
		super();
		ID = iD;
		PositionName = positionName;
	}

	public static int getCountpos() {
		return countpos;
	}

	public static void setCountpos(int countpos) {
		Position.countpos = countpos;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPositionName() {
		return PositionName;
	}

	public void setPositionName(String positionName) {
		PositionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [ID=" + ID + ", PositionName=" + PositionName + "]";
	}

//	public enum PositionName {
//		Dev, Test, Scrum_Master, PM
//	}

}
