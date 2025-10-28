USE TestingSystem;
SELECT * FROM account;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale


CREATE OR REPLACE VIEW vs_DSNVSALE AS (
SELECT a.FullName AS NhanVien, d.DepartmentName AS PhongBan FROM account a 
INNER JOIN Department d ON a.DepartmentID = d.DepartmentID 
WHERE DepartmentName = 'Sale' 
);

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vs_TTNTnhieuGroup AS (
WITH cte_maxCount as(
SELECT  COUNT(*) as SL FROM GroupAccount ga 
GROUP BY ga.AccountID
) 
SELECT a.AccountID, a.FullName, count(1) COUNT  FROM account a INNER JOIN GroupAccount ga ON a.AccountID = ga.AccountID
GROUP BY a.AccountID
 HAVING count(1)  = (SELECT max(SL) FROM cte_maxCount)
 );

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
SELECT * FROM Question;
CREATE OR REPLACE VIEW vs_TTQuestion AS (
SELECT *, length(Content) AS SL FROM Question WHERE length(Content) > 300 );
DELETE FROM Question WHERE length(Content) > 300;




-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên
CREATE OR REPLACE VIEW vs_TTGroupNV AS (
SELECT a.DepartmentID, d.DepartmentName, COUNT(a.DepartmentID) AS sl FROM account a 
INNER JOIN department d ON a.DepartmentID=d.DepartmentID
GROUP BY a.DepartmentID HAVING MAX(a.DepartmentID)
);


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vs_QuestionNguyen AS (
SELECT q.QuestionID, q.Content, a.FullName
FROM Question q
JOIN Account a ON q.CreatorID = a.AccountID
WHERE a.FullName LIKE 'Nguyễn%'
);


