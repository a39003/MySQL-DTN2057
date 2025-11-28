package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Position {
	public static int countpos = 0;
	public int ID;
	public PositionName name;

	public enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	@Override
	public String toString() {
		return "Position [ID=" + ID + ", name=" + name + "]";
	}

	public Position() {
		super();
		countpos++;
		this.ID = countpos;
		System.out.print("Chọn vị trí 1.Dev, 2.Test, 3.Scrum_Master, 4.PM :");
		while (true) {
			int chossePoss = ScannerUtils.inputInt("Nhập lại");
			switch (chossePoss) {
			case 1:
				this.name = PositionName.Dev;
				return;
			case 2:
				this.name = PositionName.PM;
				return;
			case 3:
				this.name = PositionName.Scrum_Master;
				return;
			case 4:
				this.name = PositionName.PM;
				return;
			default:
				System.err.println("Sai rồi chọn lại");
				break;
			}

		}
	}

}
