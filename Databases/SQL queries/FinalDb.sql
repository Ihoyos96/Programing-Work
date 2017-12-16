
CREATE SCHEMA FinalDB;

CREATE TABLE `User` (
	userId int not null auto_increment primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	address varchar(255) null,
	DOB date not null,
	availableBalance int not null default 0,
	currency varchar(20)
);

CREATE TABLE Verifications(
	userId int not null primary key,
	passport int null,
	ssn int null,
	license int null,
	constraint
	foreign key (userId)
	references User(userId)
);

CREATE TABLE Linked_Account(
	account_Id int not null, #Users Account Number: Use logic to determine correct format
    userId int not null,
	routing int null,
	swift int null,
	primary key (userId, account_Id),
	constraint
	foreign key (userId) 
	references User(userId)
);

CREATE TABLE Wallet (
	userId int not null,
	walletId varchar(5) not null,
	coinAmount int not null default 0,
	netWorth int not null default 0,
    primary key(userId, walletId),
	constraint
	foreign key (userId)
	references `User`(userId)
);

CREATE TABLE Transactions (
            transactionId int not null primary key auto_increment, 
            userId int not null,
            type varchar(30) not null,
            walletId varchar(5) not null,
            payment_method int null, #optional
            total int null, #optional
            quantity int not null,
            fee int null, #optional
            `date` date not null,
            sender varchar(50) null, #optional
            reciever varchar(50) null, #optional
            status varchar(20) not null,
            notes varchar(200) null, #optional
            constraint 
            foreign key (userId)
            references `User`(userId) 
            ON DELETE CASCADE ON UPDATE CASCADE,
            constraint
            foreign key (userId, walletId)
            references Wallet(userId, walletId)
            ON DELETE CASCADE ON UPDATE CASCADE,
            constraint
            foreign key (userId, payment_method)
            references Linked_Account(userId, account_id)

        );

CREATE TABLE TransactionsExchange(
	transactionId int not null auto_increment primary key,
	userId int not null,
	currencyFrom varchar(5) not null,
	currencyFromAmount int not null,
	currencyInto varchar(5)  not null,
	currencyIntoEquivalent int not null,
	notes varchar(200) null,
	`date` date not null,
	constraint
	foreign key (userId)
	references `User`(userId),
	constraint
	foreign key (userId, currencyFrom)
	references Wallet(userId, walletId)
	ON DELETE CASCADE ON UPDATE CASCADE,
	constraint
	foreign key (userId, currencyInto)
	references Wallet(userId, walletId)
	ON DELETE CASCADE ON UPDATE CASCADE
);