package Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.HighSchoolStudent;
import com.vti.entity.Libraty;

public class Inheritanced {
//--------------Question1,2---------------------
	private List<Libraty> danhsachLibraties = new ArrayList<>();
	private List<CanBo> danhsachCanBo = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public void themcanbo(CanBo canBo) {
		danhsachCanBo.add(canBo);
		System.out.println("Thêm cán bộ thành công");
	}

	public void timtheoten(String ten) {
		boolean found = false;
		for (CanBo canBo : danhsachCanBo) {
			if (canBo.getName().equalsIgnoreCase(ten)) {
				System.out.println("Tên tìm kiếm: " + canBo);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Không tìm thấy");
		}
	}

	public void hienthiDS() {
		System.out.println("------Danh sách cán bộ------------");
		for (CanBo canBo : danhsachCanBo) {
			System.out.println(canBo);
		}
	}

	public void xoatheoten(String ten) {
		danhsachCanBo.removeIf(CanBo -> CanBo.getName().equalsIgnoreCase(ten));
		System.out.println("Đã xóa nếu có!");
	}

	// ---------------Question3------------------
	public void Question3() {
		HighSchoolStudent highSchoolStudent = new HighSchoolStudent("Hiếu", 1, "Chuyên văn", "Đại học Thăng Long");
		System.out.println(highSchoolStudent);
	}

	// ---------------Question4-------------------------------------
	public void themtailieu(Libraty libraty) {
		danhsachLibraties.add(libraty);
		System.out.println("Thêm tài liệu thành công");
	}

	public void xoatailieutheoma(int ma) {
		danhsachLibraties.removeIf(libraty -> libraty.getId() == ma);
		System.out.println("Xóa thành xông nếu có");
	}

	public void showdanhsachtailieu() {
		System.out.println("------Danh sách tài liệu------------");
		for (Libraty libraty : danhsachLibraties) {
			System.out.println(libraty);
		}
	}

	public void timkiem(Class<?> type) {
		System.out.println("---------Kết quả tìm kiếm----------");
		for (Libraty libraty : danhsachLibraties) {
			if (libraty.getClass() == type) {
				System.out.println(libraty);
			}
		}
	}
}
