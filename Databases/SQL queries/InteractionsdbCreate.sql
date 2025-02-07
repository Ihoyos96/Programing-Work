##ORDER MATTERS##

CREATE TABLE Department (
	DID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Department_Name VARCHAR(255)
	);

CREATE TABLE Employee (
	EID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DID INT NOT NULL,
	First_Name VARCHAR(50) NOT NULL,
	Last_Name VARCHAR(50) NOT NULL,
	Sex ENUM ('M','F')  NOT NULL,
	DOB DATE NOT NULL,
	Job_Title VARCHAR(50),
	Manager INT NULL,
	Email_Address VARCHAR(255),
	Address VARCHAR(255),
	Salary INT NOT NULL,
	CONSTRAINT
    FOREIGN KEY (DID)
    REFERENCES Department(DID)
    ON DELETE CASCADE ON UPDATE CASCADE
	);

CREATE TABLE Contact (
	CID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Salutation VARCHAR (15),
	First_Name VARCHAR(50) NOT NULL,
	Last_Name VARCHAR(50) NOT NULL,
	Employer VARCHAR(50) NOT NULL,
	Job_Title VARCHAR(50),
	Manager INT NULL,
	Secretary INT NULL,
	Comments VARCHAR(255) DEFAULT 'None'
	);

CREATE TABLE Contact_Address (
	CID INT NOT NULL,
	Home VARCHAR (255) 'None',
	Home_City VARCHAR(50) 'None',
	Office VARCHAR (255) 'None',
	Office_City VARCHAR(50) 'None',
	Mail VARCHAR (255) 'None',
	CONSTRAINT
	FOREIGN KEY (CID)
	REFERENCES Contact(CID)
	ON DELETE CASCADE ON UPDATE CASCADE
	);

CREATE TABLE Phone_Info (
	CID INT NOT NULL,
	Home CHAR(15) DEFAULT 'None',
	Office CHAR(15) DEFAULT 'None',
	Cellular CHAR(15) DEFAULT 'None',
	Fax CHAR(15) DEFAULT 'None', 
	Secretary Char(15) DEFAULT 'None',
	CONSTRAINT
	FOREIGN KEY (CID)
	REFERENCES Contact(CID)
	ON DELETE CASCADE ON UPDATE CASCADE
	);

CREATE TABLE Interactions (
	IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	CID INT NOT NULL,
	EID INT NOT NULL,
	Business_Name VARCHAR(50) NOT NULL,
	Medium VARCHAR(50),
	`Date` DATETIME NOT NULL,
	Comments VARCHAR(255),
	CONSTRAINT
	FOREIGN KEY (CID)
	REFERENCES Contact(CID)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT 
	FOREIGN KEY (EID)
	REFERENCES Employee(EID)
	ON DELETE CASCADE ON UPDATE CASCADE
	);