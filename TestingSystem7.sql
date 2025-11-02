USE TestingSystem;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

SELECT * FROM `Group` WHERE CreateDate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

DROP TRIGGER IF EXISTS Trg_BfInsertIntoGroupCheckDate;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertIntoGroupCheckDate
	BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF(NEW.CreateDate <= CURDATE()- INTERVAL 1 YEAR) THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant insert this Record !!!';
		END IF;
    END$$
DELIMITER ;

INSERT INTO `group` (groupName, creatorID, createDate)
VALUE ('Test', 10, '2019-03-05 00:00:00');


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, 
-- khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"

DROP TRIGGER IF EXISTS Trg_BfInsertCheckDepartment;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertCheckDepartment
	BEFORE INSERT ON account 
    FOR EACH ROW
    BEGIN
		DECLARE v_DepartmentID INT;
		SELECT DepartmentID INTO v_DepartmentID FROM department WHERE DepartmentName = 'Sale';
		IF NEW.departmentID = v_DepartmentID THEN
        SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
    END$$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS Trg_BfInsertGroupAccount;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertGroupAccount
	BEFORE INSERT ON GroupAccount
    FOR EACH ROW
    BEGIN		
		DECLARE countGroupAccount TINYINT DEFAULT 0;
        SELECT count(AccountID) INTO countGroupAccount FROM GroupAccount WHERE GroupID = NEW.GroupID;
		IF (countGroupAccount>=5) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant add more account!!!';
        END IF;
    END$$
DELIMITER ;

INSERT INTO GroupAccount(GroupID	, AccountID	, JoinDate) 
VALUE 					(1, 3, '2019-03-05'),
						(1, 4, '2019-03-05'),
						(1, 5, '2019-03-05'),
                        (1, 6, '2019-03-05'),
                        (1, 7, '2019-03-05'),
                        (1, 8, '2019-03-05');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS Trg_BfInsertExamQuestion;
DELIMITER $$
	CREATE TRIGGER Trg_BfInsertExamQuestion
	BEFORE INSERT ON ExamQuestion
    FOR EACH ROW
    BEGIN		
		DECLARE countExamQuesion TINYINT DEFAULT 0;
        SELECT count(QuestionID) INTO countExamQuesion FROM ExamQuestion WHERE ExamID = NEW.ExamID;
		IF (countExamQuesion>=10) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant add Question!!!';
        END IF;
    END$$
DELIMITER ;

INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	3	,		3		),
						(	3	,		11		), 
						(	3	,		5		), 
						(	3	,		6		), 
						(	3	,		7		), 
						(	3	,		8		),
						(	3	,		9		),
						(	3	,		10		), 
						(	3	,		12		), 
						(	3	,		13		);


-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com 
-- (đây là tài khoản admin, không cho phép user xóa), 
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó

DROP TRIGGER IF EXISTS Trg_BfDeleteAccountCheckEmailAdmim;
DELIMITER $$
	CREATE TRIGGER Trg_BfDeleteAccountCheckEmailAdmim
	BEFORE DELETE ON account
    FOR EACH ROW
    BEGIN		
		DECLARE v_Email VARCHAR(50);
        SELECT Email INTO v_Email FROM account WHERE AccountID = OLD.AccountID; 
        
		IF (v_Email = 'admin@gmail.com') THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cant Delete email=admin@gmail.com!!!';
        END IF;
    END$$
DELIMITER ;

DELETE FROM account WHERE Email = 'admin@gmail.com';


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account,
-- hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_BfDepartmentAccount;
DELIMITER $$
	CREATE TRIGGER Trg_BfDepartmentAccount
	BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN		
		DECLARE v_DepartmentID INT;
        SELECT DepartmentID INTO v_DepartmentID FROM Department WHERE DepartmentName= 'waiting Department' LIMIT 1;  
		IF (NEW.DepartmentID IS NULL) THEN
		    SET NEW.DepartmentID = v_DepartmentID;
        END IF;
    END$$
DELIMITER ;

INSERT INTO `Account`(Email								, Username			, FullName		, PositionID,  CreateDate)
VALUES 				('Email1@gmail.com'				, 'Sau Rom'		,		'Nho Nhoi'		,   	'1'	,'2020-03-05');

SELECT * FROM account;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.

DROP TRIGGER IF EXISTS Trg_BfQuestionAnswer;
DELIMITER $$
	CREATE TRIGGER Trg_BfQuestionAnswer
	BEFORE INSERT ON Answer
    FOR EACH ROW
    BEGIN		
		DECLARE v_CountQuestion TINYINT;
        DECLARE v_CountAnswer TINYINT;
        SELECT count(A.QuestionID) INTO v_CountQuestion FROM answer A WHERE A.QuestionID = NEW.QuestionID;
        SELECT count(1) INTO v_CountAnswer FROM answer A WHERE A.QuestionID = NEW.QuestionID AND A.isCorrect = NEW.isCorrect;
       	IF (v_CountAnsInQUes > 4 ) OR (v_CountAnsIsCorrects >2) THEN			
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant insert more data check again!!';
        END IF;
    END$$
DELIMITER ;


-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP TRIGGER IF EXISTS Trg_Gender;
DELIMITER $$
CREATE TRIGGER Trg_Gender
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
      IF NEW.Gender = 'Nam' THEN
         SET NEW.Gender = 'M';
	  ELSEIF NEW.Gender = 'Nu' THEN
         SET NEW.Gender = 'F';
	  ELSEIF NEW.Gender = 'Chưa xác định' THEN
         SET NEW.Gender = 'U';
	  END IF ;
END $$
DELIMITER ;


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DROP TRIGGER IF EXISTS Trg_CheckDeleteExam;
DELIMITER $$
CREATE TRIGGER Trg_CheckDeleteExam
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN
     DECLARE v_CreateDate DATETIME;
     SET v_CreateDate =  DATE_SUB(NOW(),INTERVAL 2 DAY);
     IF (OLD.CreateDate > v_CreateDate) THEN
		SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Cant Delete This Exam!!';
	  END IF ;     
END $$
DELIMITER ;

DELETE FROM Exam E WHERE E.ExamID =1;


-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Trg_CheckUpdateQuestion;
DELIMITER $$
CREATE TRIGGER Trg_CheckUpdateQuestion
BEFORE UPDATE ON `Question`
FOR EACH ROW
BEGIN
     DECLARE v_CountQuestionByID TINYINT;
     SET v_CountQuestionByID =  -1;
     SELECT count(1) INTO v_CountQuestionByID FROM examquestion ex  WHERE ex.QuestionID = NEW.QuestionID;
     IF (v_CountQuestionByID != -1) THEN
		 SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Cant Update This Question';
	  END IF ;     
END $$
DELIMITER ;

UPDATE `testingsystem`.`question` SET `Content` = 'Question VTI 2599 lL6 1' WHERE (`QuestionID` = '253');


DROP TRIGGER IF EXISTS Trg_CheckDeleteQuestion;
DELIMITER $$
CREATE TRIGGER Trg_CheckDeleteQuestion
BEFORE DELETE ON `Question`
FOR EACH ROW
BEGIN
     DECLARE v_CountQuestionByID TINYINT;
     SET v_CountQuestionByID =  -1;
     SELECT count(1) INTO v_CountQuestionByID FROM examquestion ex  WHERE ex.QuestionID = OLD.QuestionID;
     IF (v_CountQuestionByID != -1) THEN
		 SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Cant Delete This Question';
	  END IF ;     
END $$
DELIMITER ;

DELETE FROM `testingsystem`.`question` WHERE (`QuestionID` = '253');



-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"


SELECT * FROM exam;
SELECT e.ExamID, e.Code, e.Title , CASE 
				WHEN Duration <= 30 THEN 'Short time'
                WHEN Duration <= 60 THEN 'Medium time'
				ELSE 'Longtime'
				END AS Duration, e.CreateDate, e.Duration
FROM Exam e;
	

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và 
-- mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher


SELECT ga.GroupID, COUNT(ga.GroupID), CASE 
	WHEN COUNT(ga.GroupID) <= 5 THEN 'few'
	WHEN COUNT(ga.GroupID) <= 20  THEN 'normal'
	ELSE 'higher'
END AS thenumberuseramount
 FROM GroupAccount ga
GROUP BY ga.GroupID;



-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"


SELECT d.DepartmentName, CASE 
				WHEN COUNT(a.DepartmentID) = 0 THEN 'Không có User'
                ELSE COUNT(a.DepartmentID)
				END AS SL
FROM Department d 
LEFT JOIN  account a  ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID;

