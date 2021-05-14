
CREATE TABLE Flights.Ticket (
	bookingRef VARCHAR(500) NOT NULL,
	flightId INT NOT NULL,
    seatClass VARCHAR(500) NOT NULL,
    meal VARCHAR(500) NOT NULL,
    priceBought VARCHAR(500) NOT NULL,
    insurance VARCHAR(500),
    luggage INT,
    ageGroup VARCHAR(500),
    PRIMARY KEY (bookingRef));



CREATE TABLE Flights.Customer (
	fullName VARCHAR(500) NOT NULL,
    customerEmail VARCHAR(500) NOT NULL,
    address1 VARCHAR(500) NOT NULL,
    address2 VARCHAR(500) NOT NULL,
    city VARCHAR(500) NOT NULL,
    county VARCHAR(500) NOT NULL,
    postalCode VARCHAR(500) NOT NULL,
    PRIMARY KEY (customerEmail));


CREATE TABLE Flights.Booking (
    customerEmail VARCHAR(500) NOT NULL,
	bookingRef VARCHAR(500) NOT NULL,
	id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id));