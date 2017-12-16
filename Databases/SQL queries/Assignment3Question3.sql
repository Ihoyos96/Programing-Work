
/* 6.13 What is the average price of a room*/
SELECT AVG(price) FROM Room;

/* 6.16 List the price and type of all rooms at the Grosvenor Hotel*/
SELECT h.hotelName, r.roomNo, r.price, r.type
FROM Room r, Hotel h
WHERE r.hotelNo = 11 AND h.hotelNo = 11;

/* 6.19 What is the total income from bookings for the Grosvenor Hotel today */
SELECT SUM(price) as TotalincomeToday  FROM  Booking b, Room r
WHERE r.roomNo = b.roomNo 
AND b.hotelNo = 11
AND b.dateFrom <= '2017-10-26'
AND b.dateTo > '2017-10-27';

/* 6.23 List the number of rooms in each hotel in London */
SELECT h.hotelName, COUNT(r.roomNo)
FROM Room r, Hotel h
WHERE h.city = 'London' AND r.hotelNo = h.hotelNo
GROUP BY h.hotelName;

/* 6.25 What is the most commonly booked room type for each hotel in London*/
SELECT A.hotelName, B.RoomType 
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
			) as A JOIN (SELECT hotelName, RoomType, numBookings
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
AND A.hotelName = B.hotelName;


/* 6.28 Update the price of all rooms by 5% */
UPDATE Room
SET price = price + (price * 0.05);


/* 7.13 Create a view containing the hotel name and the names of the guests staying at the hotel. */
CREATE VIEW HotelGuest_Data AS
SELECT h.hotelName, g.*, b.roomNo, b.dateFrom, b.dateTo
FROM Hotel h, Guest g, Booking b
WHERE h.hotelNo = b.hotelNo 
AND g.guestNo = b.guestNo
AND b.dateFrom <= CURDATE()
AND b.dateTo >= CURDATE();

/* 7.15 Give the users Manager and Director full access to these views, with the privilege to pass the access on to other users. */
GRANT ALL PRIVILEGES ON HotelGuest_Data
TO Manager, Director WITH GRANT OPTION;

/* 7.16 Give the user Accounts SELECT access to these views. Now revoke the access from this user. */
GRANT SELECT ON HotelGuest_Data TO PUBLIC;

REVOKE SELECT ON HotelGuest_Data FROM PUBLIC;


