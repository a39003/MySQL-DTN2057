CREATE DATABASE TestingSystem1;
USE TestingSystem1;

CREATE TABLE `Department` (
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL
);


CREATE TABLE `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

SELECT * FROM Position;


CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE
);


CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				TINYINT UNSIGNED,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);


CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE
);


CREATE TABLE TypeQuestion (
    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
);


CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);


CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId) ON DELETE CASCADE 
);


CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);


CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`					CHAR(10) NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId) ON DELETE CASCADE
);


CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE,
    PRIMARY KEY (ExamID,QuestionID)
);

-- insert data

INSERT INTO Department(DepartmentName) 
VALUES
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
 	
    
INSERT INTO Position	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			);



INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID,  CreateDate)
VALUES 				('Email1@gmail.com'				, 'DUsername1O'		,'Fullname1'				,   '5'			,   '1'		,'2020-03-05'),
					('Email2@gmail.com'				, 'Username2'		,'Fullname2'				,   '1'			,   '2'		,'2020-03-05'),
                    ('Email3@gmail.com'				, 'Username3'		,'Fullname3'				,   '2'			,   '2'		,'2020-03-07'),
                    ('Email4@gmail.com'				, 'Username4'		,'Fullname4'				,   '3'			,   '4'		,'2020-03-08'),
                    ('Email5@gmail.com'				, 'Username5'		,'Fullname5'				,   '4'			,   '4'		,'2020-03-10'),
                    ('Email6@gmail.com'				, 'Username6'		,'Fullname6'				,   '6'			,   '3'		,'2020-04-05'),
                    ('Email7@gmail.com'				, 'Username7'		,'Fullname7'				,   '2'			,   '2'		, NULL		),
                    ('Email8@gmail.com'				, 'Username8'		,'Fullname8'				,   '8'			,   '1'		,'2020-04-07'),
                    ('Email9@gmail.com'				, 'Username9'		,'Fullname9'				,   '2'			,   '2'		,'2020-04-07'),
                    ('Email10@gmail.com'			, 'Username10'		,'Fullname10'				,   '10'		,   '1'		,'2020-04-09');


INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				(N'Testing System'		,   15			,'2019-03-05'),
					(N'Development'			,   11			,'2020-03-07'),
                    (N'VTI Sale 01'			,   12			,'2020-03-09'),
                    (N'VTI Sale 02'			,   13			,'2020-03-10'),
                    (N'VTI Sale 03'			,   14			,'2020-03-28'),
                    (N'VTI Creator'			,   16			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   17			,'2020-04-07'),
                    (N'Management'			,   18			,'2020-04-08'),
                    (N'Chat with love'		,   19			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   20			,'2020-04-10');


INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	41		,    11		,'2019-03-05'),
							(	41		,    12		,'2020-03-07'),
							(	43		,    13		,'2020-03-09'),
							(	43		,    14		,'2020-03-10'),
							(	45		,    15		,'2020-03-28'),
							(	41		,    13		,'2020-04-06'),
							(	41		,    17		,'2020-04-07'),
							(	48		,    13		,'2020-04-08'),
							(	41		,    19		,'2020-04-09'),
							(	50		,    20		,'2020-04-10');



INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 
 SELECT * FROM TypeQuestion;


INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
				
 SELECT * FROM CategoryQuestion;                

INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về Java'	,	1		,   '1'			,   '12'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'			,   '12'		,'2020-04-05'),
						(N'Hỏi về C#'		,	9		,   '2'			,   '13'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'			,   '14'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	5		,   '1'			,   '15'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'			,   '16'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'			,   '17'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'			,   '18'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'			,   '19'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'			,   '20'	,'2020-04-07');
 SELECT * FROM Question;  

INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   21			,	0		),
					(N'Trả lời 02'	,   21			,	1		),
                    (N'Trả lời 03'	,   21			,	0		),
                    (N'Trả lời 04'	,   21			,	1		),
                    (N'Trả lời 05'	,   22			,	1		),
                    (N'Trả lời 06'	,   23			,	1		),
                    (N'Trả lời 07'	,   24			,	0		),
                    (N'Trả lời 08'	,   28			,	0		),
                    (N'Trả lời 09'	,   29			,	1		),
                    (N'Trả lời 10'	,   30			,	1		);
	
    
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '15'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '12'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '12'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '13'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '14'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '16'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '17'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '18'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '19'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '20'		,'2020-04-08');
 SELECT * FROM Exam;                      
                    
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	11	,		25		),
						(	12	,		30		), 
						(	13	,		34		), 
						(	14	,		33		), 
						(	15	,		27		), 
						(	16	,		40		), 
						(	17	,		22		), 
						(	18	,		30		), 
						(	19	,		29		), 
						(	20	,		38		);


-- testingSystem3
-- question2: lấy ra tất cả các phòng ban
SELECT * FROM Department;
SELECT * FROM Account;
SELECT * FROM `Group`;

-- question3: lấy ra id của phòng ban "Sale"
SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale';

-- question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM `Account` ORDER BY LENGTH(FullName) DESC LIMIT 1;

-- question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM `Account` WHERE DepartmentID = 3 ORDER BY LENGTH(FullName) DESC LIMIT 1;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT DISTINCT `Group`.GroupName
FROM `Group` 
JOIN GroupAccount  ON `Group`.GroupID = GroupAccount.GroupID
WHERE GroupAccount.JoinDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID FROM Answer GROUP BY QuestionID HAVING COUNT(*) >=4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT `Code` FROM Exam WHERE Duration >= 60 AND CreateDate < '2019-12-20';


-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group` ORDER BY CreateDate DESC LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(*)  FROM `Account` WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `Account` WHERE Username LIKE 'D%O';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
SELECT * FROM Exam WHERE CreateDate < '2019-12-20';
DELETE FROM `Exam` WHERE  CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
SELECT * FROM Question;
DELETE FROM Question WHERE Content LIKE 'câu hỏi%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account` SET  FullName = 'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn' WHERE AccountID = 15;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `Account` SET  GroupID = 44 WHERE AccountID = 14;