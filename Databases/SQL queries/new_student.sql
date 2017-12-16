CREATE PROCEDURE `new_student` ()

BEGIN

	INSERT INTO Students (SID, FirstName, LastName, Age, Email, Major, Class)

	VALUES (@SID, @FirstName, @LastName, @Age, @Email, @Major, @Class);
    
END
