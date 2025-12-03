package utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	public static final String ERROR_FILE_EXIST = "Error! File Exist.";
	public static final String ERROR_FILE_NOT_EXIST = "Error! File Not Exist.";
	public static final String ERROR_FOLDER_EXIST = "Error! Folder Exist.";
	public static final String ERROR_PATH_NOT_FOLDER = "Error! Path is not folder.";
	public static final String ERROR_SOURCE_NOT_EXIST = "Error! Source File Not Exist.";
	public static final String ERROR_NEWPATH_EXIST = "Error! newPath has File same name.";
	public static final String ERROR_NAME_EXIST = "Error! Name is Exist.";

	// Check File exists
	public static boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
		return file.exists();
	}

	public static boolean isFolderExists(String pathFoder) {
		File file = new File(pathFoder);
		return file.exists();
	}

	// Create new file
	public static void createnewfile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if (file.exists()) {
			throw new Exception(ERROR_FILE_EXIST);
		}
		file.createNewFile();
	}

	public static void createnewfile(String path, String fileName) throws Exception {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}

		File file = new File(path + "/" + fileName);
		if (file.exists()) {
			throw new Exception(ERROR_FILE_EXIST);
		}

		file.createNewFile();
	}

	// Delte file

	public static void deleteFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if (!file.exists()) {
			throw new Exception(ERROR_FILE_NOT_EXIST);
		}

		file.delete();
	}

	// Check path is File or Folder
	public static boolean isFolder(String path) {
		File file = new File(path);
		return file.isDirectory();
	}

	// Get all File name of Folder
	public static List<String> getAllFileName(String path) throws Exception {
		File folder = new File(path);

		if (!folder.isDirectory()) {
			throw new Exception(ERROR_PATH_NOT_FOLDER);
		}

		File[] files = folder.listFiles();

		List<String> list = new ArrayList<>();
		if (files != null) {
			for (File f : files) {
				list.add(f.getName());
			}
		}
		return list;
	}

	// Copy File
	public static void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
		File srcFile = new File(sourceFile);
		if (!srcFile.exists()) {
			throw new Exception(ERROR_SOURCE_NOT_EXIST);
		}

		File destFile = new File(distinationPath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}

		File newFile = new File(distinationPath + "/" + newName);
		if (newFile.exists()) {
			throw new Exception(ERROR_NEWPATH_EXIST);
		}

		Files.copy(srcFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	public static void copyFile(String sourceFile, String newPath) throws Exception {
		File srcFile = new File(sourceFile);
		if (!srcFile.exists()) {
			throw new Exception(ERROR_SOURCE_NOT_EXIST);
		}

		File deFile = new File(newPath);
		if (!deFile.exists()) {
			deFile.mkdirs();
		}

		File newFile = new File(newPath + "/" + srcFile.getName());
		if (newFile.exists()) {
			throw new Exception(ERROR_NEWPATH_EXIST);
		}

		Files.copy(srcFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	// Moving file
	public static void moveFile(String sourceFile, String destinationPath) throws Exception {
		File file = new File(sourceFile);
		if (!file.exists()) {
			throw new Exception(ERROR_FILE_NOT_EXIST);
		}

		File destinationFolder = new File(destinationPath);
		if (!destinationFolder.exists()) {
			destinationFolder.mkdirs();
		}

		File newfFile = new File(destinationFolder + "/" + file.getName());
		Files.move(file.toPath(), newfFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		file.delete();
	}

	// Rename File
	public static void renameFile(String pathFile, String newName) throws Exception {
		File file = new File(pathFile);
		if (!file.exists()) {
			throw new Exception(ERROR_FILE_NOT_EXIST);
		}
		File newFile = new File(file.getParent() + "/" + newName);
		if (newFile.exists()) {
			throw new Exception(ERROR_NAME_EXIST);
		}
		file.renameTo(newFile);
	}

	// Create new folder
	public static void createNewFolder(String newPathFolder) throws Exception {
		File folder = new File(newPathFolder);
		if (folder.exists()) {
			throw new Exception(ERROR_FOLDER_EXIST);
		}
		folder.mkdirs();
	}

	// Download file

	public static void downloadFile(String fileLink, String folder) throws Exception {
		File dir = new File(folder);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String fileName = fileLink.substring(fileLink.lastIndexOf("/") + 1);
		File file = new File(folder + "/" + fileName);

		// Nếu file trùng tên → thêm (1), (2), ...
		int index = 1;
		String baseName = fileName;
		String extension = "";

		if (fileName.contains(".")) {
			baseName = fileName.substring(0, fileName.lastIndexOf("."));
			extension = fileName.substring(fileName.lastIndexOf("."));
		}

		while (file.exists()) {
			file = new File(folder + "/" + baseName + "(" + index + ")" + extension);
			index++;
		}

		try (InputStream in = new URL(fileLink).openStream()) {
			Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}

}
