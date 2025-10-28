USE TestingSystem;

SELECT * FROM account;
SELECT * from Department;
SELECT * FROM Position;
SELECT * FROM Question;


-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT AccountID, FullName, 
		(SELECT DepartmentName FROM Department WHERE Department.DepartmentID= account.DepartmentID) AS TenPhongBan 
        FROM account;



-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM account WHERE CreateDate > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT * FROM account WHERE PositionID = (SELECT PositionID FROM Position WHERE PositionName = 'Dev');

SELECT a.AccountID, a.Email, a.FullName, p.PositionName, d.DepartmentName FROM account a 
INNER JOIN position p on a.PositionID = p.PositionID
INNER JOIN Department d ON a.DepartmentID = d.DepartmentID
WHERE PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
 SELECT DepartmentName FROM Department WHERE DepartmentID 
        IN (SELECT DepartmentID FROM account GROUP BY DepartmentID HAVING COUNT(AccountID) > 3 );

SELECT a.DepartmentID, d.DepartmentName, COUNT(a.DepartmentID) AS sl FROM account a 
INNER JOIN department d ON a.DepartmentID=d.DepartmentID
GROUP BY a.DepartmentID HAVING COUNT(a.DepartmentID) >= 1;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT QuestionID, Content FROM Question WHERE QuestionID IN (
    SELECT QuestionID
    FROM ExamQuestion
    GROUP BY QuestionID
    HAVING COUNT(ExamID) = (
        SELECT MAX(CountExam)
        FROM (
            SELECT COUNT(ExamID) AS CountExam
            FROM ExamQuestion
            GROUP BY QuestionID
        ) AS Temp
    )
);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 
    CategoryID,
    (SELECT CategoryName 
     FROM CategoryQuestion 
     WHERE CategoryQuestion.CategoryID = Question.CategoryID) AS CategoryName,
    COUNT(QuestionID) AS SoLuongQuestion
FROM Question
GROUP BY CategoryID;



-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 
    QuestionID,
    (SELECT Content FROM Question q WHERE q.QuestionID = eq.QuestionID) AS NoiDung,
    COUNT(ExamID) AS SoLuongExam
FROM ExamQuestion eq
GROUP BY QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT QuestionID, Content
FROM Question
WHERE QuestionID IN (
    SELECT QuestionID
    FROM Answer
    GROUP BY QuestionID
    HAVING COUNT(AnswerID) = (
        SELECT MAX(CountAns)
        FROM (
            SELECT COUNT(AnswerID) AS CountAns
            FROM Answer
            GROUP BY QuestionID
        ) AS Temp
    )
);


-- Question 9: Thống kê số lượng account trong mỗi group
SELECT GroupID, COUNT(AccountID) AS SoLuong
FROM GroupAccount
GROUP BY GroupID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT PositionName
FROM Position
WHERE PositionID = (
    SELECT PositionID
    FROM Account
    GROUP BY PositionID
    ORDER BY COUNT(AccountID)
    LIMIT 1
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT DepartmentID, SUM(PositionID='1') as soluongdev, SUM(PositionID='2') as soluongtest, SUM(PositionID='3') as soluongmaster, SUM(PositionID='4') as soluongpm FROM account GROUP BY DepartmentID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT 
    q.QuestionID,
    q.Content AS NoiDungCauHoi,
    tq.TypeName AS LoaiCauHoi,
    a.FullName AS NguoiTao,
    ans.Content AS CauTraLoi
FROM Question q
LEFT JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
LEFT JOIN Account a ON q.CreatorID = a.AccountID
LEFT JOIN Answer ans ON q.QuestionID = ans.QuestionID;


-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT  TypeID,
    (SELECT TypeName FROM TypeQuestion WHERE TypeQuestion.TypeID = Question.TypeID) AS Loai,
    COUNT(QuestionID) AS SoLuong
FROM Question
GROUP BY TypeID;

-- Question 14:Lấy ra group không có account nào
SELECT GroupID, GroupName
FROM `Group`
WHERE GroupID NOT IN (
    SELECT DISTINCT GroupID FROM GroupAccount
);

-- Question 15: Lấy ra group không có account nào
-- Question 16: Lấy ra question không có answer nào
SELECT QuestionID, Content
FROM Question
WHERE QuestionID NOT IN (
    SELECT DISTINCT QuestionID FROM Answer
);

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT * 
FROM Account
WHERE AccountID IN (
    SELECT AccountID FROM GroupAccount WHERE GroupID = 1
);

-- b) Lấy các account thuộc nhóm thứ 2
SELECT * 
FROM Account
WHERE AccountID IN (
    SELECT AccountID FROM GroupAccount WHERE GroupID = 2
);

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT * 
FROM Account
WHERE AccountID IN (
    SELECT AccountID FROM GroupAccount WHERE GroupID = 1
    UNION
    SELECT AccountID FROM GroupAccount WHERE GroupID = 2
);

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT GroupID
FROM GroupAccount
GROUP BY GroupID
HAVING COUNT(AccountID) > 5;
-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT GroupID
FROM GroupAccount
GROUP BY GroupID
HAVING COUNT(AccountID) < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
<<<<<<< HEAD

=======
>>>>>>> df77966 (Nopthem)
SELECT GroupID
FROM GroupAccount
GROUP BY GroupID
HAVING COUNT(AccountID) > 5

UNION

SELECT GroupID
FROM GroupAccount
GROUP BY GroupID
<<<<<<< HEAD
HAVING COUNT(AccountID) < 7;
=======
HAVING COUNT(AccountID) < 7;
>>>>>>> df77966 (Nopthem)
