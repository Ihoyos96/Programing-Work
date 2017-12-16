INSERT INTO Department (Department_Name)
VALUES 
	('Sales'),
	('Marketing'),
	('Accounting'),
	('Business Development')
;

#1 - Sales
#2 - Marketing
#3 - Accounting
#4 - Busniess Development

INSERT INTO Employee (DID, First_Name, Last_Name, Sex, DOB, Job_Title, Email_Address, Address, Salary)
VALUES 
	('1','Georgi','Facello','M','1986-06-26', 'Sales Associate', 'Gfacello@gmail.com', '221 SW 7th Ave', 23000),
	('2','Bazalel','Simmel','F','1983-09-15', 'Marketing Associate', 'Bsimmel@gmail.com', '298 NW 9th Ave', 24600),
	('3','John','Krasinscki','M','1987-10-22', 'Accountant', 'JKrazy@gmail.com', '38 S 3rd St', 31000),
	('4','Timothy','Havord','M','1985-11-03', 'Business Specialist', 'TimHavord@gmail.com', '34 Northwood Rd', 50600),
	('4','Elizabeth','Foxton','F','1984-05-17', 'Manager', 'Efoxton@gmail.com', '2412 S 9th Ave', 62600),
	('2','Ernesto','Acosta','M','1990-07-16', 'Marketing Associate', 'Acosta90@gmail.com', '452 Bricklove Rd', 27300),
	('1','Sofia','Droz','F','1991-12-23', 'Manager', 'DrizzleDroz@gmail.com', '91 Pinacle Rd', 72600),
	('3','Angela','Schrute','F','1981-08-30', 'Accountant', 'Aschrute@gmail.com', '776 Mid 24th Ave', 49000),
	('3','Ricardo','Arriaga','M','1992-03-11', 'Manager', 'ricardoArriaga@gmail.com', '91 Pinacle Rd', 72500),
	('2','Joshua','Levene','M','1992-07-25', 'Manager', 'MeanLevene@gmail.com', '110 Backroads Ave', 71500),
	('1','Meredith','Palmer','F','1978-12-19', 'Sales Associate', 'Mpalmer@gmail.com', '12 N Berry Rd', 23600)
;

INSERT INTO Contact (CID, Salutation, First_Name, Last_Name, Employer, Job_Title, Manager, Secretary)
VALUES
	('Mr.', 'Alex', 'Gilinger', 'AT&T', 'Marketing Director', NULL, 2),
	('Mrs.', 'Jackie', 'Banes', 'AT&T', 'Secretary', 1, NULL),
	('Mr.', 'Jack', 'Bower', 'Facebook', 'Business Relations Manager', NULL, 6),
	('Ms.', 'Amanda', 'Disdier', 'Intel Corporation', 'Chief Executive Officer', NULL, 5),
	('Mrs.', 'Mary', 'Lahkman', 'Intel Corporation', 'Secretary', 4, NULL),
	('Mr.', 'Justin', 'Tredeau', 'Facebook', 'Secretary', 3, NULL),
	('Mr.', 'Dogson', 'Wulfson', 'Facebook', 'Accountant', 3, null, 'Good at math'),
	('Mr.', 'Foxson', 'Screechson', 'Facebook', 'Developer', 3, null, 'Good at coding'),
	('Mr.', 'Cowson', 'Moofson', 'Facebook', 'Analyst', 3, null, 'Good at graphs'),
	('Mr.', 'Sheepton', 'Bahfson', 'AT&T', 'Business Specialist', 1, null, 'He is Ba-aa-ahd'),
	('Mr.', 'Snakeston', 'Sleethson', 'AT&T', 'Account Handler', 1, null, 'Cold Blooded'),
	('Mr.', 'Sharkton', 'Munchson', 'AT&T', 'Analyst', 1, null, 'He is a hammer head'),
	('Mr.', 'Badgerson', 'Hendrix', 'Intel Corporation', 'Business Specialist', 4, null, 'What a great team player'),
	('Mrs.', 'Catty', 'Meowy', 'inter Corporation', 'Business Relations', 4, null, 'She goes fur the gold, always.')
;

INSERT INTO Contact_Address (CID, Home, Office)
VALUES
	(1, '456 Desperado Heights Lot 53', '92 NE 54th St')
	(4, '256 Secuestor 67th Ave', 'North Hollywood 1264 5th St')
;

INSERT INTO Interactions (CID, EID, Date, Business_Name, Medium, Comments)
VALUES
	('6', '1', '2014-02-04 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
	('5', '3', '2013-06-08 00:00:00', 'Intel Corporation', 'Email', 'Following up on our last conversation.'),
	('10', '8', '2012-12-05 00:00:00', 'AT&T', 'Phone', 'We had a nice chat!'),
	('6', '6', '2007-04-07 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
	('8', '11', '2017-11-04 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
	('14', '3', '2014-06-07 00:00:00', 'Intel Corporation', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
	('3', '4', '2016-11-04 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
	('6', '1', '2015-03-04 00:00:00', 'Facebook', 'Phone', 'We had a nice chat!'),
	('14', '1', '2016-11-22 00:00:00', 'Intel Corporation', 'Email', 'We seem to be on the same page.'),
	('8', '6', '2013-12-18 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
	('8', '7', '2013-04-11 00:00:00', 'Facebook', 'Email', 'We seem to be on the same page.'),
	('4', '3', '2017-09-05 00:00:00', 'Intel Corporation', 'Email', 'We seem to be on the same page.'),
	('4', '5', '2016-05-01 00:00:00', 'Intel Corporation', 'Phone', 'We had a nice chat!'),
	('6', '4', '2011-06-16 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
	('9', '10', '2009-02-09 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
	('2', '10', '2009-04-19 00:00:00', 'AT&T', 'Phone', 'Great call, Alot of progress made!'),
	('9', '3', '2008-10-28 00:00:00', 'Facebook', 'Phone', 'Great call, Alot of progress made!'),
	('9', '1', '2006-09-26 00:00:00', 'Facebook', 'Postal', 'The documents I was waiting for have arrived'),
	('9', '3', '2015-04-24 00:00:00', 'Facebook', 'Postal', 'Old fashion correspondance, this guy knows how to business.'),
	('2', '5', '2014-10-12 00:00:00', 'AT&T', 'Email', 'We seem to be on the same page.')
;



