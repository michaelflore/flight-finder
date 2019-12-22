DROP TABLE IF EXISTS `ticket`;
DROP TABLE IF EXISTS `reservation`;
DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `aircraft_capacity`;
DROP TABLE IF EXISTS `aircraft`;
DROP TABLE IF EXISTS `airline`;
DROP TABLE IF EXISTS `airport`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS `role` (
  `username` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (username, role),
  FOREIGN KEY (username) REFERENCES user(username) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `airline` (
  `airline_id` char(2) NOT NULL,
  `airline_name` varchar(255) NOT NULL,
  PRIMARY KEY (airline_id)
);

CREATE TABLE IF NOT EXISTS `aircraft` (
  `aircraft_id` varchar(32) NOT NULL,
  `aircraft_model` varchar(32) NOT NULL,
  `airline_id` char(2) NOT NULL,
  PRIMARY KEY (aircraft_id),
  FOREIGN KEY (airline_id) REFERENCES airline(airline_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `aircraft_capacity` (
  `aircraft_id` varchar(32) NOT NULL,
  `seat_class` varchar(32) NOT NULL,
  `capacity` int NOT NULL ,
  PRIMARY KEY (aircraft_id, seat_class),
  FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `airport` (
  `airport_id` char(3) NOT NULL,
  `airport_name` varchar(255) NOT NULL,
  `airport_tags` varchar(512) NOT NULL,
  PRIMARY KEY (airport_id)
);

CREATE TABLE IF NOT EXISTS `flight` (
  `flight_id` int NOT NULL,
  `airline_id` char(2) NOT NULL,
  `departure_airport_id` char(3) NOT NULL,
  `arrival_airport_id` char(3) NOT NULL,
  `departure_weekday` int NOT NULL,
  `arrival_weekday` int NOT NULL,
  `aircraft_id` varchar(32) NOT NULL,
  `departure_time` time,
  `arrival_time` time,
  `price` DECIMAL(9, 2) NOT NULL,
  PRIMARY KEY (airline_id, flight_id, departure_weekday),
  FOREIGN KEY (departure_airport_id) REFERENCES airport(airport_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (arrival_airport_id) REFERENCES airport(airport_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (airline_id) REFERENCES airline(airline_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (aircraft_id) REFERENCES aircraft(aircraft_id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `origin_airport_id` char(3) NOT NULL,
  `purchase_date` date NOT NULL,
  `purchase_time` time NOT NULL,
  `departure_date` date NOT NULL,
  `departure_time` time NOT NULL,
  `total_fare` DECIMAL(11, 2) NOT NULL,
  `fee` DECIMAL(9, 2) NOT NULL,
  `special_meal` varchar(32),
  `seat_class` varchar(32) NOT NULL,
  `booking_status` varchar(32) NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (origin_airport_id) REFERENCES airport(airport_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (username) REFERENCES user(username) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` varchar(255) NOT NULL,
  `reservation_id` varchar(255) NOT NULL,
  `leg_id` int NOT NULL,
  `airline_id` char(3) NOT NULL,
  `flight_id` int NOT NULL,
  `departure_weekday` int NOT NULL,
  `departure_date` date NOT NULL,
  `price` DECIMAL(11, 2) NOT NULL,
  `waitlist_status` varchar(32) NOT NULL,
  PRIMARY KEY (reservation_id, ticket_id, leg_id),
  FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (airline_id, flight_id, departure_weekday) REFERENCES flight(airline_id, flight_id, departure_weekday) ON UPDATE CASCADE ON DELETE RESTRICT
);