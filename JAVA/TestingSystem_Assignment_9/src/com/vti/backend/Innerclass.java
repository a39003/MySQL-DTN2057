package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.CPU.Processor;
import com.vti.entity.CPU.Ram;
import com.vti.entity.Car;
import com.vti.entity.NgayThangNam;
import com.vti.entity.NgayThangNam.GioPhutGiay;
import com.vti.entity.OuterClass;
import com.vti.entity.OuterClass.InnerClass;

public class Innerclass {
	public static void Question1() {
		CPU cpu = new CPU(10);

		Processor processor = cpu.new Processor(4, "Iter");
		Ram ram = cpu.new Ram(5, "Kingston");
		System.out.println("Khởi tạo CPU  thành công!");

		System.out.println("In thông tin Processor");
		System.out.println("Cache Processor: " + processor.getCache());
		System.out.println("Clock Speed Ram: " + ram.getClockSpeed());

	}

	public static void Question2() {
		Car car = new Car("Mazda", "8WD");
		Car.Engine engine = car.new Engine("Crysler");

		System.out.println("Khơi tạo Car thành công");
		System.out.println("thông tin car: " + car);
		System.out.println("Loại động cơ: " + engine);
	}

	public static void Question3() {
		OuterClass outerClass = new OuterClass();
		outerClass.show();
		InnerClass innerClass = outerClass.new InnerClass();
		innerClass.show();
	}

	public static void Question4() {
		NgayThangNam date = new NgayThangNam();
		date.ngay = 31;
		date.thang = 10;
		date.nam = 2017;

		GioPhutGiay time = date.new GioPhutGiay();
		time.gio = 10;
		time.phut = 15;
		time.giay = 30;

		time.xuatthongtin();
	}
}
