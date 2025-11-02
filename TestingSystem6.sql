USE TestingSystem;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó

SELECT a.* ,d.DepartmentID, d.DepartmentName FROM department d
INNER JOIN account a ON a.DepartmentID = d.DepartmentID WHERE DepartmentName = 'Sale';

DELIMITER $$
CREATE PROCEDURE sp_getDepartmentName(IN in_DepName VARCHAR(50))
			BEGIN
				SELECT a.* ,d.DepartmentID, d.DepartmentName FROM department d
				INNER JOIN account a ON a.DepartmentID = d.DepartmentID WHERE DepartmentName = in_DepName ;
			END$$
DELIMITER ;

CALL sp_getDepartmentName('Kỹ thuật');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

SELECT * FROM GroupAccount;


DROP PROCEDURE IF EXISTS sp_getGroupName;
DELIMITER $$
CREATE PROCEDURE sp_getGroupName(IN in_GroupName VARCHAR(50))
			BEGIN
				SELECT g.GroupID,g.GroupName, COUNT(AccountID) SLThanhVien FROM groupaccount ga
				INNER JOIN `Group` g ON g.GroupID = ga.GroupID WHERE GroupName = in_GroupName
				GROUP BY GroupID;
			END$$
DELIMITER ;

CALL sp_getGroupName('Testing System');



-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DELIMITER $$
CREATE PROCEDURE sp_count_month_question()
	BEGIN
		WITH cte_month_questions 
		AS (	
			SELECT tq.TypeID, tq.TypeName, q.Questionid, q.content, q.createdate
			FROM TypeQuestion tq
			LEFT JOIN Question q
			ON tq.TypeID = q.TypeID
			WHERE MONTH(q.createdate) = MONTH(CURDATE())
				AND YEAR(q.createdate) = YEAR(CURDATE())
		)
		SELECT TypeName, COUNT(QuestionID) AS q_count
		FROM cte_month_questions
		GROUP BY TypeName;		
    END $$
DELIMITER ;

CALL sp_count_month_question;

-- Question 4 + 5: Tạo store để trả ra id và tên của type question có nhiều câu hỏi nhất
DELIMITER $$
CREATE PROCEDURE sp_count_typequestion()
	BEGIN
		WITH cte_MaxTQ as(
		SELECT Count(TypeID) AS SLCauHoi FROM Question 
		GROUP BY TypeID
		) 
		SELECT q.TypeID, tq.TypeName, count(1) COUNT  FROM Question q 
		INNER JOIN TypeQuestion tq ON tq.TypeID = q.TypeID
		GROUP BY q.TypeID
		HAVING count(1)  = (SELECT max(SLCauHoi) FROM cte_MaxTQ);
    END $$
DELIMITER ;

CALL sp_count_typequestion;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

SELECT * FROM account;

DELIMITER $$
CREATE PROCEDURE sp_GroupOrUser(IN in_keyword VARCHAR(100))
BEGIN
    IF (SELECT COUNT(*) FROM `Group` WHERE GroupName LIKE CONCAT('%', in_keyword, '%')) > 0 THEN
        SELECT GroupID, GroupName
        FROM `Group`
        WHERE GroupName LIKE CONCAT('%', in_keyword, '%');
    ELSE
        SELECT AccountID, Username, FullName
        FROM Account
        WHERE Username LIKE CONCAT('%', in_keyword, '%');
    END IF;
END $$

DELIMITER ;

CALL sp_GroupOrUser('sale');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS sp_insertAccount;
DELIMITER $$
CREATE PROCEDURE sp_insertAccount
(	IN var_Email VARCHAR(50),
	IN var_Fullname VARCHAR(50))
BEGIN
	DECLARE v_Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(var_Email, '@', 1);
	DECLARE v_DepartmentID  TINYINT UNSIGNED DEFAULT 11;
	DECLARE v_PositionID TINYINT UNSIGNED DEFAULT 1;
                  DECLARE v_CreateDate DATETIME DEFAULT now();
    
	INSERT INTO `account` (`Email`,		 `Username`, 	`FullName`, 		`DepartmentID`,			 `PositionID`, 			`CreateDate`) 
	VALUES 				  (var_Email,     v_Username,      var_Fullname,          v_DepartmentID,          v_PositionID,         v_CreateDate);

END$$
DELIMITER ;

Call sp_insertAccount('daonq@viettel.com.vn','Nguyen dao');



-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS sp_ContentQuestion;
DELIMITER $$
CREATE PROCEDURE sp_ContentQuestion(IN in_Content VARCHAR(100))
BEGIN
	SELECT  q.QuestionID, q.Content, tq.TypeName, LENGTH(q.Content) AS SLContent
			FROM Question q
			INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
			WHERE tq.TypeName = in_Content
			ORDER BY length(q.Content) DESC LIMIT 1;
END $$

DELIMITER ;

CALL sp_ContentQuestion('Essay');
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DELIMITER $$
CREATE PROCEDURE sp_Exam(IN in_Exam INT)
BEGIN
	DELETE FROM Exam WHERE ExamID = in_Exam;
END $$

DELIMITER ;

CALL sp_Exam('2');
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing

SELECT * FROM Exam WHERE CreateDate <= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban 
-- và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc

DROP PROCEDURE IF EXISTS SP_DelDepFromName;
DELIMITER $$
CREATE PROCEDURE SP_DelDepFromName(IN var_DepartmentName VARCHAR(30))
BEGIN
	DECLARE v_DepartmentID VARCHAR(30) ;
    SELECT D1.DepartmentID   INTO v_DepartmentID FROM department D1 WHERE D1.DepartmentName = var_DepartmentName;
	UPDATE `account` A SET A.DepartmentID  = '11' WHERE A.DepartmentID = v_DepartmentID;
    
	DELETE FROM department d WHERE d.DepartmentName = var_DepartmentName;
END$$
DELIMITER ;

Call SP_DelDepFromName('Marketing');



-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DELIMITER $$
CREATE PROCEDURE sp_CreateDateQuestion()
BEGIN
SELECT month(CreateDate) as thang, COUNT(*) AS SL FROM Question
    WHERE YEAR(CreateDate) = YEAR(CURDATE())  
    GROUP BY MONTH(CreateDate) ;
END $$

DELIMITER ;

CALL sp_CreateDateQuestion;

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")

DROP PROCEDURE IF EXISTS sp_CountQuesBefore6Month;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesBefore6Month()
BEGIN
	WITH CTE_Talbe_6MonthBefore AS (
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`
			UNION			
            SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`
)
		SELECT M.MONTH,M.YEAR, CASE 
				WHEN COUNT(QuestionID) = 0 THEN 'không có câu hỏi nào trong tháng'
                ELSE COUNT(QuestionID)
				END AS SL
		FROM CTE_Talbe_6MonthBefore M
		LEFT JOIN (SELECT * FROM question where CreateDate >= DATE_SUB(NOW(), INTERVAL 6 MONTH) AND CreateDate <= now()) AS Sub_Question ON M.MONTH = MONTH(CreateDate)
		GROUP BY M.MONTH
		ORDER BY M.MONTH ASC;
END$$
DELIMITER ;

-- Run: 
CALL sp_CountQuesBefore6Month;
