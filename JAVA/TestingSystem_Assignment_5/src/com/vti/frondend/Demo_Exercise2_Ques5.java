package com.vti.frondend;

import com.vti.entity.DienThoaiCoDien;
import com.vti.entity.DienThoaiThongMinh;

public class Demo_Exercise2_Ques5 {
	public static void main(String[] args) {
		DienThoaiThongMinh dienThoaiThongMinh = new DienThoaiThongMinh();

		dienThoaiThongMinh.nghe();
		dienThoaiThongMinh.sudung3g();
		dienThoaiThongMinh.chuphinh();
		dienThoaiThongMinh.tancongkexau();

		System.out.println("------------------------");
		DienThoaiCoDien dienThoaiCoDien = new DienThoaiCoDien();
		dienThoaiCoDien.goi();
		dienThoaiCoDien.ngheradio();
		dienThoaiCoDien.tancongkexau();
	}
}
