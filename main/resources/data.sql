INSERT IGNORE INTO user (username, password) VALUES ('admin', 'admin');
INSERT IGNORE INTO user (username, password) VALUES ('user', 'user');
INSERT IGNORE INTO user (username, password) VALUES ('rep', 'rep');

INSERT IGNORE INTO role (username, role) VALUES ('admin', 'admin');
INSERT IGNORE INTO role (username, role) VALUES ('rep', 'customer_representative');
INSERT IGNORE INTO role (username, role) VALUES ('user', 'customer');

INSERT IGNORE INTO airline (airline_id, airline_name) VALUES ('UA', 'United Airlines');
INSERT IGNORE INTO airline (airline_id, airline_name) VALUES ('DL', 'Delta Airlines');

INSERT IGNORE INTO aircraft (aircraft_id, airline_id, aircraft_model) 
VALUES ('N14001', 'UA', 'Boeing 787-100 Dreamliner');
INSERT IGNORE INTO aircraft (aircraft_id, airline_id, aircraft_model) 
VALUES ('N501DN', 'DL', 'Airbus350-900');

INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N14001', 'economy', 3);
INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N14001', 'business', 2);
INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N14001', 'first', 1);

INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N501DN', 'economy', 3);
INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N501DN', 'business', 2);
INSERT IGNORE INTO aircraft_capacity (aircraft_id, seat_class, capacity) 
VALUES ('N501DN', 'first', 1);

INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('EWR', 'Newark Liberty International Airport', 'ny, new york, nyc, philadephia, philly, newark, new jersey');
INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('JFK', 'John F. Kennedy International Airport', 'ny, new york, nyc, philadephia, philly, long island, new jersey');
INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('MUC', 'Munich International Airport', 'munich');
INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('BCN', 'Josep Tarradellas Barcelona-El Prat Airport', 'barcelona');
INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('MAD', 'Madrid-Barajas Adolfo Suárez Airport', 'madrid');
INSERT IGNORE INTO airport (airport_id, airport_name, airport_tags) 
VALUES ('DUB', 'Dublin Airport', 'dublin, ireland');

INSERT IGNORE INTO flight (airline_id, flight_id, departure_airport_id, arrival_airport_id, departure_weekday, arrival_weekday, departure_time, arrival_time, aircraft_id, price) 
VALUES ('UA', '100', 'EWR', 'BCN', 6, 0, '22:50', '08:20', 'N14001', 420.00);
INSERT IGNORE INTO flight (airline_id, flight_id, departure_airport_id, arrival_airport_id, departure_weekday, arrival_weekday, departure_time, arrival_time, aircraft_id, price) 
VALUES ('DL', '100', 'EWR', 'BCN', 3, 3, '00:10', '07:50', 'N501DN', 450.00);
INSERT IGNORE INTO flight (airline_id, flight_id, departure_airport_id, arrival_airport_id, departure_weekday, arrival_weekday, departure_time, arrival_time, aircraft_id, price) 
VALUES ('DL', '100', 'EWR', 'BCN', 5, 5, '00:10', '07:50', 'N501DN', 450.00);

INSERT IGNORE INTO flight (airline_id, flight_id, departure_airport_id, arrival_airport_id, departure_weekday, arrival_weekday, departure_time, arrival_time, aircraft_id, price) 
VALUES ('UA', '101', 'BCN', 'EWR', 1, 1, '16:50', '20:20', 'N14001', 420.00);
INSERT IGNORE INTO flight (airline_id, flight_id, departure_airport_id, arrival_airport_id, departure_weekday, arrival_weekday, departure_time, arrival_time, aircraft_id, price) 
VALUES ('UA', '101', 'BCN', 'EWR', 3, 3, '16:50', '20:20', 'N14001', 420.00);