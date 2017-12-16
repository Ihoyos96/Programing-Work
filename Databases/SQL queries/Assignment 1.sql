CREATE TABLE Hotel ( 
	hotelNo INT PRIMARY KEY, 
    hotelName VARCHAR(255),
    City VARCHAR(255)
);

CREATE TABLE Room (
    RoomNo INT NOT NULL,
    HotelNo INT NOT NULL,
    Type varchar(255),
    Price INT,
    PRIMARY KEY (RoomNo, HotelNo),
    CONSTRAINT
    FOREIGN KEY (HotelNo) 
    REFERENCES Hotel(HotelNo)
    ON DELETE CASCADE
);

CREATE TABLE Booking (
	HotelNo INT NOT NULL, 
    GuestNo INT NOT NULL, 
    DateFrom DATETIME NOT NULL,
    DateTo DATETIME,
    RoomNo INT NOT NULL,
    PRIMARY KEY (HotelNo, GuestNo, DateFrom),
    CONSTRAINT
    FOREIGN KEY (HotelNo)
    REFERENCES Hotel(HotelNo)
    ON DELETE CASCADE,
    CONSTRAINT
    FOREIGN KEY (RoomNo)
    REFERENCES Room(RoomNo)
    ON DELETE CASCADE
);