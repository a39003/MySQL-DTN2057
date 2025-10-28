CREATE DATABASE fresher;
USE fresher;
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
	TraineeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FullName  VARCHAR(50) NOT NULL,
    BirthDate DATE NOT NULL,
    Gender ENUM ('Male', 'Female', 'Unknown')  DEFAULT 'UNKNOWN',
    ETIQ INT NOT NULL CHECK (ETIQ BETWEEN 0 and 20),
    ETGmath INT NOT NULL CHECK (ETGmath BETWEEN 0 AND 20),
    ETEnglish INT NOT NULL CHECK (ETEnglish BETWEEN 0 AND 50),
    TrainingClass VARCHAR(50) NOT NULL,
    EvaluationNotes VARCHAR(50)
);

INSERT INTO Trainee (FullName, BirthDate, Gender, ETIQ, ETGmath, ETEnglish, TrainingClass, EvaluationNotes)
VALUE 				('Nguyễn Văn A', '2002-03-24','Male', '10', '19', '20', 'VTI001', 'DHGTVT'),
					('Nguyễn Văn B', '2002-10-02','Female', '20', '18', '30', 'VTI001', 'DHTL'),
                    ('Nguyễn Văn C', '2005-12-03','Male', '14', '17', '25', 'VTI003', 'DHKGHN'),
                    ('Nguyễn Văn D', '2001-03-24','Female', '17', '14', '34', 'VTI005', 'DHHN'),
                    ('Nguyễn Văn H', '2000-03-27','Male', '18', '20', '36', 'VTI007', 'DHKTQG'),
                    ('Nguyễn Văn F', '2002-02-05','Male', '19', '17', '40', 'VTI008', 'DHTL'),
                    ('Nguyễn Văn J', '2002-02-07','Female', '12', '9', '29', 'VTI002', 'DHTNMT'),
                    ('Nguyễn Văn K', '2003-01-03','Female', '11', '12', '28', 'VTI002', 'DHGTVT'),
                    ('Nguyễn Văn R', '2006-09-03','Male', '15', '19', '30', 'VTI009', 'DHGTVT'),
                    ('Nguyễn Văn U', '1999-11-03','Male', '18', '17', '48', 'VTI001', 'DHGTVT');
                    
                    
SELECT * FROM Trainee;

-- Question3:
-- INSERT INTO Trainee (FullName, BirthDate, Gender, ETIQ, ETGmath, ETEnglish, TrainingClass, EvaluationNotes)
-- VALUES
-- ('Nguyễn Văn L', '2002-06-15', 'MALE', 30, 15, 40, 'VTI010', 'DHQGHN');

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20
 SELECT * FROM Trainee WHERE ETIQ >=12 AND ETGmath>=12 AND ETEnglish>=20 ORDER BY BirthDate ;
 
 -- Question 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N và kết thúc bằng chữ C
  SELECT * FROM Trainee WHERE FullName LIKE 'N%C';
  
 -- Question 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
 SELECT * FROM Trainee WHERE FullName LIKE '_G%';
 
 
 -- Question 7: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có 10 ký tự và ký tự cuối cùng là C
 
 SELECT * FROM Trainee WHERE length(FullName) = '10' AND RIGHT(FullName, 1) = 'C';
 
 -- Question 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, lọc bỏ các tên trùng nhau.
  SELECT  DISTINCT(FullName ) FROM Trainee;
 
 -- Question 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, sắp xếp các tên này theo thứ tự từ A-Z..
 
 SELECT * FROM Trainee ORDER BY FullName ASC;
 
 -- Question 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất
 
 SELECT * FROM Trainee WHERE length(FullName) = ( SELECT MAX(length(FullName)) as maxfullname FROM Trainee );
 
 -- Question 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất
 
  SELECT TraineeID, FullName, BirthDate FROM Trainee WHERE length(FullName) = ( SELECT MAX(length(FullName)) as maxfullname FROM Trainee );
  
  -- Question 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất

SELECT TraineeID, FullName, BirthDate, Gender, ETIQ, ETGmath, ETEnglish  FROM Trainee WHERE length(FullName) = ( SELECT MAX(length(FullName)) as maxfullname FROM Trainee );

-- Question 13 Lấy ra 5 thực tập sinh có tuổi nhỏ nhất

SELECT * FROM Trainee ORDER BY BirthDate DESC LIMIT 5;

-- Question 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20
-- ET_IQ>=8
-- ET_Gmath>=8
-- ET_English>=18
 SELECT * FROM Trainee WHERE (ETIQ + ETGmath) >= 20 AND ETIQ>=8 AND ETGmath>=8 AND ETEnglish>=18;
 
 -- Question 15: Xóa thực tập sinh có TraineeID = 5
 
 DELETE FROM Trainee WHERE TraineeID = '5';
 
 -- Question 16: Xóa thực tập sinh có tổng điểm ET_IQ, ET_Gmath <=15
 
 DELETE FROM Trainee WHERE ETIQ <=15 AND ETGmath <=15;
 
 -- Question 17: Xóa thực tập sinh quá 30 tuổi.
DELETE
FROM Trainee
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) > 30;

-- Question 18: Thực tập sinh có TraineeID = 3 được chuyển sang lớp " VTI003". Hãy cập nhật thông tin vào database.
 UPDATE Trainee SET TrainingClass = 'VTI003' WHERE TraineeID = '3';
 
 
 -- Question 19: Do có sự nhầm lẫn khi nhập liệu nên thông tin của học sinh số 10 đang bị sai, 
 -- hãy cập nhật lại tên thành “LeVanA”, điểm ET_IQ =10, điểm ET_Gmath =15, điểm ET_English = 30. 
 
 UPDATE Trainee SET FullName = 'LeVanA', ETIQ =10, ETGmath =15, ETEnglish = 30 WHERE TraineeID = '10';
 
 -- Question 20+21: Đếm xem trong lớp VTI001  có bao nhiêu thực tập sinh.
 SELECT * FROM Trainee;
SELECT COUNT(TrainingClass) AS SoLuongSV FROM Trainee WHERE TrainingClass='VTI001';

-- Question 22: Đếm tổng số thực tập sinh trong lớp VTI001 và VTI003 có bao nhiêu thực tập sinh.
SELECT TrainingClass, COUNT(*) AS SoLuongThucTapSinh
FROM Trainee
WHERE TrainingClass IN ('VTI001', 'VTI003')
GROUP BY TrainingClass;

-- Question 23: Lấy ra số lượng các thực tập sinh theo giới tính: Male, Female, Unknown.
  SELECT Gender, COUNT(*) AS SoLuongThucTap
  FROM Trainee
  WHERE Gender IN ('Male', 'Female', 'Unknown')
  GROUP BY Gender;
  
 -- Question 24 + 25: Lấy ra lớp có lớn hơn 5 thực tập viên
 SELECT TrainingClass, COUNT(*) AS Soluongtt 
 FROM Trainee
 GROUP BY TrainingClass HAVING COUNT(*) > 5 ;
 
 -- Question 26: Lấy ra trường có ít hơn 4 thực tập viên tham gia khóa học
 
  SELECT EvaluationNotes, COUNT(*) AS Soluongtt 
 FROM Trainee
 GROUP BY EvaluationNotes HAVING COUNT(*) < 4 ;
 
 -- Question 27: Bước 1: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI001'
	SELECT TraineeID, FullName, TrainingClass FROM Trainee WHERE TrainingClass = 'VTI001';
 
-- Bước 2: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI002'
SELECT TraineeID, FullName, TrainingClass FROM Trainee WHERE TrainingClass = 'VTI002';
-- Bước 3: Sử dụng UNION để nối 2 kết quả ở bước 1 và 2
SELECT TraineeID, FullName, TrainingClass FROM Trainee WHERE TrainingClass IN (
 SELECT TrainingClass FROM Trainee WHERE TrainingClass = 'VTI001'
 UNION
 SELECT TrainingClass FROM Trainee WHERE TrainingClass = 'VTI002'
);



 