package com.vti.backend;

import java.util.List;

import utils.FileManager;
import utils.ScannerUtils;

public class Filed {

	public void question1() throws Exception {
		loadMenu();
	}

	public void loadMenu() throws Exception {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng===================");
			System.out.println("===              1. Check File is exists.                           ===");
			System.out.println("===              2. Check Folder                                    ===");
			System.out.println("===              3. Tạo file mới                                    ===");
			System.out.println("===              4. Tạo mới file từ đường dẫn và tên file riêng     ===");
			System.out.println("===              5. Xóa file                                        ===");
			System.out.println("===              6. Check path is File or Folder                    ===");
			System.out.println("===              7. Get all file in Folder                          ===");
			System.out.println("===              8. Copy File                                       ===");
			System.out.println("===              9. Move File                                       ===");
			System.out.println("===             10. Rename File                                     ===");
			System.out.println("===             11. Tạo Folder                                      ===");
			System.out.println("===             12. Download File                                   ===");
			System.out.println("===             13. End Program                                     ===");
			System.out.println("=======================================================================");
			System.out.print("Lựa chọn: ");
			int menuChoose = ScannerUtils.intputIntPositve();
			switch (menuChoose) {
			case 1:
				System.out.print("Nhập path file: ");
				String path1 = ScannerUtils.inputString();
				boolean exists = FileManager.isFileExists(path1);
				System.out.println("File tồn tại? " + exists);
				break;

			case 2:
				System.out.print("Nhập path folder: ");
				String path2 = ScannerUtils.inputString();
				boolean isFolder = FileManager.isFolder(path2);
				System.out.println("Có phải folder? " + isFolder);
				break;

			case 3:
				System.out.print("Nhập path file tạo mới: ");
				String path3 = ScannerUtils.inputString();
				FileManager.createnewfile(path3);
				System.out.println("Tạo file thành công!");
				break;

			case 4:
				System.out.print("Nhập path thư mục: ");
				String folder4 = ScannerUtils.inputString();
				System.out.print("Nhập tên file: ");
				String name4 = ScannerUtils.inputString();
				FileManager.createnewfile(folder4, name4);
				System.out.println("Tạo file thành công!");
				break;

			case 5:
				System.out.print("Nhập path file cần xóa: ");
				String path5 = ScannerUtils.inputString();
				FileManager.deleteFile(path5);
				System.out.println("Xóa file thành công!");
				break;

			case 6:
				System.out.print("Nhập path cần kiểm tra: ");
				String path6 = ScannerUtils.inputString();
				System.out.println(FileManager.isFolder(path6) ? "Là folder" : "Là file");
				break;

			case 7:
				System.out.print("Nhập folder cần lấy danh sách file: ");
				String path7 = ScannerUtils.inputString();
				List<String> files = FileManager.getAllFileName(path7);
				System.out.println("--- Danh sách file ---");
				for (String f : files) {
					System.out.println(f);
				}
				break;

			case 8:
				System.out.print("Nhập source file: ");
				String source8 = ScannerUtils.inputString();
				System.out.print("Nhập destination folder: ");
				String dest8 = ScannerUtils.inputString();
				System.out.print("Nhập tên file mới: ");
				String newName8 = ScannerUtils.inputString();
				FileManager.copyFile(source8, dest8, newName8);
				System.out.println("Copy file thành công!");
				break;

			case 9:
				System.out.print("Nhập source file: ");
				String source9 = ScannerUtils.inputString();
				System.out.print("Nhập destination folder: ");
				String dest9 = ScannerUtils.inputString();
				FileManager.moveFile(source9, dest9);
				System.out.println("Move file thành công!");
				break;

			case 10:
				System.out.print("Nhập path file cần rename: ");
				String file10 = ScannerUtils.inputString();
				System.out.print("Nhập tên mới: ");
				String newName10 = ScannerUtils.inputString();
				FileManager.renameFile(file10, newName10);
				System.out.println("Đổi tên file thành công!");
				break;

			case 11:
				System.out.print("Nhập path folder muốn tạo mới: ");
				String folder11 = ScannerUtils.inputString();
				FileManager.createNewFolder(folder11);
				System.out.println("Tạo folder thành công!");
				break;

			case 12:
				System.out.print("Nhập link file cần download: ");
				String link12 = ScannerUtils.inputString();
				System.out.print("Nhập folder lưu file: ");
				String folder12 = ScannerUtils.inputString();
				FileManager.downloadFile(link12, folder12);
				System.out.println("Download file thành công!");
				break;

			case 13:
				System.out.println("Chương trình kết thúc!");
				return;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
				break;
			}
		}
	}
}
