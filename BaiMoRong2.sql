CREATE DATABASE VTI_Mark_Management;
USE VTI_Mark_Management;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
	TraineeID TINYINT UNIQUE AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL, 
    Age INT NOT NULL, 
    Gender ENUM ('Male', 'Female', 'Unknown')  DEFAULT 'UNKNOWN'
);


DROP TABLE IF EXISTS Subject;
CREATE TABLE `Subject`(
	SubjectID TINYINT UNIQUE AUTO_INCREMENT PRIMARY KEY, 
	SubjectName VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS TraineeSubject;
CREATE TABLE TraineeSubject(
	TraineeID TINYINT UNIQUE NOT NULL, 
	SubjectID TINYINT UNIQUE NOT NULL, 
	Mark DECIMAL(4,2) , 	
	ExamDay DATE ,
	FOREIGN KEY(TraineeID) REFERENCES Trainee(TraineeID) ON DELETE CASCADE,
    FOREIGN KEY(SubjectID) REFERENCES Subject(SubjectID) ON DELETE CASCADE,
    PRIMARY KEY (TraineeID,SubjectID)
);

INSERT INTO Trainee(FirstName, LastName, Age, Gender)
VALUE ('Anh', 'Phạm Đức', '22', 'Male' ),
	  ('Dũng', 'Nguyễn Đình', '20', 'Male'),
      ('Hiếu', 'Phạm Minh', '22', 'Male'),
      ('Lan', 'Trần Thị', '21', 'Female');
      
INSERT INTO  `Subject` (SubjectName)  
VALUE ('MySQL'), 
	  ('JavaCore'), 
      ('FrontEnd Basic'), 
      ('Spring Framwork'), 
      ('FrontEnd Advance'), 
      ('Mock Project'); 


INSERT INTO TraineeSubject(TraineeID, SubjectID, Mark, ExamDay)
VALUE('1', '2', '8.9', '2025-04-25'),
	  ('2', '1', '7.0', '2025-05-03'),
      ('3', '5', '7.8','2025-06-23'),
      ('4', '3', '6.7', '2025-04-12');

SELECT * FROM Trainee;
SELECT * FROM `subject`;
SELECT * FROM TraineeSubject;



