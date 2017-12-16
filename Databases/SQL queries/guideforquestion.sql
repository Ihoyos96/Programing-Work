Guide for 6.25

////////////////////////
///* First SubQuery *///
////////////////////////
//********************************************************//

Select hotelNo, MAX(Bookings)
From (
		Select hotelNo, hotelName, type, Count(type) as Bookings
		From (
			/*Internal Query*/
			) as layer1
		Group By hotelName, RoomType
	) as max
Group By hotelNo

//********************************************************//

/////////////////////////
///* Second SubQuery *///
/////////////////////////
//********************************************************//

Select hotelNo, type, Bookings
From (
		Select hotelNo, hotelName, type, Count(type) as Bookings
		From (
			/*Internal Query*/
			) as layer1
		Group By hotelName, RoomType
	) as max
Group By hotelNo

//********************************************************//

////////////////////////
///* INTERNAL QUERY *///
////////////////////////
//********************************************************//

Select hotelNo, hotelName, type, Count(type) as Bookings
		From (
			Select * From Booking b
			Join Hotel h On (b.hotelNo = h.hotelNo)
			Join Room r On (b.roomNo = r.roomNo)
			Where h.city = 'London'
			) as layer1
		Group By hotelName, RoomType

/*Variation of internal query*/
Select h.hotelNo as hotel, r.roomType as type, COUNT(*) as cnt
    From Booking b
        JOIN Hotel h ON (h.hotelNo = b.hotelNo)
        JOIN Room r ON (b.roomNo = r.roomNo)
    WHERE h.city = 'London'
    GROUP BY h.hotelNo, r.roomType

//********************************************************//


/////////////////////////////////////////////
////* HOW THE FINAL PRODUCT SHOULD LOOK *////
/////////////////////////////////////////////
//********************************************************//

OUTER QUERY extracts hotelNo, roomType
	first subquery JOIN second subquery
Where firstSubQuery.Bookings = secondSubQuery.Bookings
And fsq.hotelNo = ssq.hotelNo

//********************************************************//
/*Join First and Second SubQueries
and extract hotel and room type comparing their respective 
max bookings*/

/*Make Ssure to change it up, there are various ways to rewrite this query. 
Sayed uses diff check on code so if you don't change the general structure
 and names he'll figure it out*/

/*MAX can be extracted in Select and Having clauses*/

