import pymysql, sys

build = \
[
"""DROP SCHEMA hotel_db"""
,"""CREATE SCHEMA hotel_db"""
,"""USE hotel_db"""
,"""DROP USER PUBLIC; CREATE USER PUBLIC;"""
,"""DROP USER Manager, Director; CREATE USER Manager, Director;"""
]

queries = \
[ 
#-------------------Create Tables---------------#
"""CREATE TABLE Hotel ( 
	hotelNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    hotelName VARCHAR(255),
    city VARCHAR(255)
)
"""
, """CREATE TABLE Room (
    roomNo INT NOT NULL,
    hotelNo INT NOT NULL,
    `type` varchar(255),
    price INT,
    PRIMARY KEY (roomNo, hotelNo),
    CONSTRAINT
    FOREIGN KEY (hotelNo) 
    REFERENCES Hotel(hotelNo)
    ON DELETE CASCADE
)
"""
, """CREATE TABLE Booking (
	hotelNo INT NOT NULL, 
    guestNo INT NOT NULL, 
    dateFrom DATETIME NOT NULL,
    dateTo DATETIME,
    roomNo INT NOT NULL,
    PRIMARY KEY (hotelNo, guestNo, dateFrom),
    CONSTRAINT
    FOREIGN KEY (hotelNo)
    REFERENCES Hotel(hotelNo)
    ON DELETE CASCADE,
    CONSTRAINT
    FOREIGN KEY (roomNo)
    REFERENCES Room(roomNo)
    ON DELETE CASCADE
)
"""
, """CREATE TABLE Guest (
    guestNo INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    guestName VARCHAR(255) NOT NULL,
    guestAddress VARCHAR(255)
)
"""
#---------------------------------------#

#---------Populate Tables---------------#
, """INSERT INTO Hotel (hotelName, city)
VALUES
('New York City Grand', 'New York City'),
('London Grand', 'London'),
('Madrid Grand', 'Madrid'),
('Paris Grand', 'Paris'),
('Miami Grand', 'Miami'),
('Mandarin Oriental', 'London'),
('Beijin Grand', 'Beijin'),
('Berlin Grand', 'Berlin'),
('Los Angeles Grand', 'Los Angeles'),
('Barcelona Grand', 'Barcelona'),
('Milan Grand', 'Milan'),
('Grand Grosvenor', 'Sydney')
"""
, """INSERT INTO Room (roomNo, hotelNo, type, price)
VALUES
(101, 1, 'Suite', 100),
(518, 3, 'Suite', 185),
(210, 6, 'Double', 500),
(1214, 1, 'Single', 245),
(1105, 2, 'Suite', 1100),
(1106, 2, 'Suite', 1000),
(304, 7, 'Double', 315),
(2417, 2, 'Deluxe Suite', 1500),
(809, 8, 'Double', 435),
(903, 4, 'Single', 250),
(714, 10, 'Double', 375),
(1103, 6, 'Single', 175),
(1701, 1, 'Suite', 415),
(3016, 11, 'Suite', 750),
(1812, 11, 'Double', 300),
(1718, 11, 'Single', 240)
"""
, """INSERT INTO Booking (hotelNo, guestNo, dateFrom, dateTo, roomNo)
VALUES
(1, 1, '2018-09-17', '2018-09-19', 1701),
(1, 2, '2018-08-18', '2018-08-23', 1214),
(1, 3, '2018-08-18', '2018-08-23', 101),
(2, 4, '2018-11-18', '2018-08-23', 1105),
(2, 9, '2019-11-18', '2019-08-23', 1106),
(2, 5, '2018-08-03', '2018-08-13', 2417),
(3, 6, '2018-07-18', '2018-07-23', 518),
(4, 7, '2018-02-15', '2018-02-19', 903),
(6, 10, '2018-03-26', '2019-04-03', 210),
(6, 8, '2018-12-26', '2019-01-03', 210),
(6, 9, '2018-12-28', '2019-01-02', 1103),
(8, 10, '2018-07-03', '2018-07-05', 809),
(11, 11, '2017-10-26', '2017-10-29', 1812),
(11, 12, '2017-10-26', '2017-10-30', 3016)
"""
, """INSERT INTO Guest (guestName, guestAddress)
VALUES
('John fipher', '123 Miracle Ave'),
('Nikolai Petrov', '124 Miracle Ave'),
('Jennfied Mcafee', '125 Miracle Ave'),
('Alexander Borgova', '256 Miracle Ave'),
('Michael Brondson', '167 Miracle Ave'),
('Tiffany Cox', '314 Miracle Ave'),
('Robert Sangeski', '657 Miracle Ave'),
('Timothy Scott', '234 Miracle Ave'),
('Dwight Schrute', '884 Schrutesville'),
('Pamela Beezly', '123 Miracle Ave'),
('Lex Luther', '394 Miracle Ave'),
('Michael Fasbender', '333 Miracle Ave'),
('Max Kolher', '971 Miracle Ave')
"""
#--------------------------------------------#

#---------Question2----------#
, "SELECT * FROM Hotel"
, "SELECT * FROM Hotel WHERE city = 'London'"
, "SELECT h.hotelName, h.city, g.guestName, g.guestAddress, b.dateFrom FROM Guest g, Booking b, Hotel h WHERE b.guestNo = g.guestNo AND b.hotelno = h.hotelNo AND h.city = 'London' ORDER BY g.guestName"
#----------------------------#

#---------Question3----------#
, "SELECT AVG(price) FROM Room"
, "SELECT h.hotelName, r.roomNo, r.price, r.type FROM Room r, Hotel h WHERE r.hotelNo = 11 AND h.hotelNo = 11" 
, "SELECT SUM(price) as TotalincomeToday  FROM  Booking b, Room r WHERE r.roomNo = b.roomNo AND b.hotelNo = 11 AND b.dateFrom <= '2017-10-26' AND b.dateTo > '2017-10-27'"
, "SELECT h.hotelName, COUNT(r.roomNo) FROM Room r, Hotel h WHERE h.city = 'London' AND r.hotelNo = h.hotelNo GROUP BY h.hotelName"
, """SELECT A.hotelName, B.RoomType 
		FROM(
			SELECT hotelName, MAX(numBookings) as max
			FROM (
				SELECT hotelName, type as RoomType, COUNT(type) as numBookings
				FROM (
					SELECT h.hotelNo, h.hotelName, b.roomNo, r.type, r.price
					FROM Booking b JOIN Hotel h JOIN Room r
					WHERE b.hotelNo = h.hotelNo AND h.city = 'London'
						AND b.roomNo = r.roomNo
				) as inner1
				GROUP BY hotelName, RoomType
			) as hotel_max
			GROUP BY hotelName
		) as A JOIN (
			SELECT hotelName, RoomType, numBookings
			FROM (
				SELECT hotelName, type as RoomType, COUNT(type) as numBookings
				FROM (
					SELECT h.hotelNo, h.hotelName, b.roomNo, r.type, r.price
					FROM Booking b JOIN Hotel h JOIN Room r
					WHERE b.hotelNo = h.hotelNo AND h.city = 'London'
						AND b.roomNo = r.roomNo
				) as inner2
				GROUP BY hotelName, RoomType
			) as hotel_count
		) as B
		WHERE A.max = B.numBookings
			AND A.hotelName = B.hotelName
"""
, "UPDATE Room SET price = price + (price * 0.05)"
,"""CREATE VIEW HotelGuest_Data AS
		SELECT h.hotelName, g.*, b.roomNo, b.dateFrom, b.dateTo
		FROM Hotel h, Guest g, Booking b
		WHERE h.hotelNo = b.hotelNo 
			AND g.guestNo = b.guestNo
			AND b.dateFrom <= CURDATE()
			AND b.dateTo >= CURDATE()
"""
,"""GRANT ALL PRIVILEGES ON HotelGuest_Data TO Manager, Director WITH GRANT OPTION
"""
, """GRANT SELECT ON HotelGuest_Data TO PUBLIC"""
, """REVOKE SELECT ON HotelGuest_Data FROM PUBLIC"""
#----------------------End-------------------------#
]

conn = pymysql.connect("35.185.7.33" , port=3306, user="root" , 
				password="csc423", database="hotel_db")
cur = conn.cursor()

#----Build Database----#
for b in build:
	cur.execute(b)
#--------------------#

print("Database Created!\n")

while True:
	print("""Input Values:\n 
		100\t - Close Connection
		200\t - Run All queries
		300\t - Clear Database
		0\t - CREATE TABLE Hotel
		1\t - CREATE TABLE Room
		2\t - CREATE TABLE Booking
		3\t - CREATE TABLE Guest
		4\t - POPULATE Hotel
		5\t - POPULATE Room
		6\t - POPULATE Booking
		7\t - POPULATE Guest
		8\t - Details of all Hotels
		9\t - Details of all Hotels in London
		10\t - All Guests in London
		11\t - 6.13 Average Room Price
		12\t - 6.16 Price/Type - Rooms at Grosvenor Hotel
		13\t - 6.19 Total Income from Bookings - Grosvenor Hotel
		14\t - 6.23 Number of Rooms in London Hotels
		15\t - 6.25 Most Common Room Types in London Hotels
		16\t - 6.28 Update Room prices by 5%
		17\t - 7.13 Create View HotelGuest_Data
		18\t - 7.15 View - Grant All Privileges to (Manager, Director)
		19\t - 7.16 View - Grant SELECT to PUBLIC
		20\t - 7.16 View - Revoke SELECT from PUBLIC
		\n""")

	input = int(raw_input("Enter Input: "))

	if input == 100:
		cur.close()
		conn.close()
		sys.exit()
	elif input == 200:
		for q in queries:
			cur.execute(q)
			print("\nQuery:\n" + q)
			print("\nResult: ")
			for row in cur:
				print(row)
			print("\n")
	elif input == 300:
		for b in build:
			cur.execute(b)
		print("\nOUTPUT\n-------------------------\nDatabase Cleared!\n-------------------------\n")
	else:
		try:
			## OUTPUT PROCESSING ##
			cur.execute(queries[input])
			print("\n\n\n\nOUTPUT\n-------------------------\nQuery:\n" + queries[input])
			print("\nResult: ")
			if cur.rowcount == 0:
				print("Query Executed!\n\nNo output data!")
			else:	
				for row in cur:
					print(row)
			print("-------------------------\n")

		## ERROR HANDLING ## 
		except pymysql.err.InternalError:
			print("""-------------------------\nError: InternalError\nProbable Causes:\n\t1. Query already executed!\n\t2. Invalid Request, might need precusor query!\n-------------------------\n""")
		except pymysql.err.ProgrammingError:
			print("""-------------------------\nError: Please create all tables and views first!\n-------------------------\n""")



