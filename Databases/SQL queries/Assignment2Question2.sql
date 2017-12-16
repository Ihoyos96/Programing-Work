/*Full details of all hotels*/
SELECT * FROM Hotel;

/*Full details of all hotels in London*/
SELECT * FROM Hotel
WHERE city = 'London';

/*Name and Address of all guests in the London hotel, London Hotel Number is 2*/
SELECT h.hotelName, h.city, g.guestName, g.guestAddress
FROM Guest g, Booking b, Hotel h
WHERE b.guestNo = g.guestNo AND b.hotelNo = 2 AND h.hotelNo = 2
ORDER BY g.guestName;