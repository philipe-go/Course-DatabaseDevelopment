-- MariaDB / MySQL

CREATE DATABASE IF NOT EXISTS exempleInj;

USE exempleInj ;

CREATE TABLE sal(Id_Emp VARCHAR(10) NOT NULL, 
 Salaire DOUBLE(10,2) NOT NULL, 
 PRIMARY KEY (Id_Emp ));

INSERT INTO sal (Id_Emp, Salaire) 
VALUES ('E001', 75000.00),
	   ('E002', 65000.00),
	   ('E003', 6000.00);




