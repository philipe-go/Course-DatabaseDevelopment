-- BY Philipe Gouveia - 1910072 - at 2020 December 11th


-- CREATE THE DATABASE
CREATE DATABASE IF NOT EXISTS STARFLEET;

USE STARFLEET;

-- CREATE THE SHIPS TABLE
CREATE TABLE IF NOT EXISTS SHIPS 
(vessel_name VARCHAR(50) PRIMARY KEY  NOT NULL,
 vessel_type VARCHAR(20) NOT NULL); 

-- CREATE THE CAPTAINS TABLE
CREATE TABLE IF NOT EXISTS CAPTAINS
(captain_name VARCHAR(50) NOT NULL, assigned_vessel VARCHAR(50),
PRIMARY KEY (captain_name),
FOREIGN KEY (assigned_vessel) REFERENCES SHIPS(vessel_name));

-- INSERT VALUES INTO THE SHIP'S TABLE
INSERT INTO SHIPS (vessel_name, vessel_type)
VALUES ('Air Force 1','Stellar_Base');
INSERT INTO SHIPS (vessel_name, vessel_type)
VALUES ('Death Star','Ship');
INSERT INTO SHIPS (vessel_name, vessel_type)
VALUES ('Halley Commet','Stellar_Base');

-- INSERT VALUES INTO THE CAPTAINS TABLE
INSERT INTO CAPTAINS (captain_name, assigned_vessel)
VALUES ('Ramiro Guerreiro', 'Air Force 1');
INSERT INTO CAPTAINS (captain_name)
VALUES ('Spok');
INSERT INTO CAPTAINS (captain_name, assigned_vessel)
VALUES ('Darth Vader', 'Death Star');