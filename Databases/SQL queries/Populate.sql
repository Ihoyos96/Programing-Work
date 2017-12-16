INSERT INTO Hotel (hotelName, city)
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
;

INSERT INTO Room (roomNo, hotelNo, type, price)
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
;

INSERT INTO Guest (guestName, guestAddress)
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
('Max Kölher', '971 Miracle Ave')
;

INSERT INTO Booking (hotelNo, guestNo, dateFrom, dateTo, roomNo, roomId)
VALUES
(1, 1, '2018-09-17', '2018-09-19', 1701, 13),
(1, 2, '2018-08-18', '2018-08-23', 1214, 4),
(1, 3, '2018-08-18', '2018-08-23', 101, 1),
(2, 4, '2018-11-18', '2018-08-23', 1105, 5),
(2, 9, '2019-11-18', '2019-08-23', 1106, 6),
(2, 5, '2018-08-03', '2018-08-13', 2417, 8),
(3, 6, '2018-07-18', '2018-07-23', 518, 2),
(4, 7, '2018-02-15', '2018-02-19', 903, 10),
(6, 10, '2018-03-26', '2019-04-03', 210, 3),
(6, 8, '2018-12-26', '2019-01-03', 210, 3),
(6, 9, '2018-12-28', '2019-01-02', 1103, 12),
(8, 10, '2018-07-03', '2018-07-05', 809, 9),
(11, 11, '2017-10-26', '2017-10-29', 1812, 15),
(11, 12, '2017-10-26', '2017-10-30', 3016, 14)
;
