CREATE DATABASE IF NOT EXISTS LOGINSDB;

USE LOGINSDB;

CREATE TABLE LOGINS_OPEN  -- mot de passe ouvert
(
    USER      VARCHAR(30) NOT NULL,
    PW        TEXT NOT NULL   
);

CREATE TABLE LOGINS_ENCRYPT  -- AES_ENCRIPT DIAGONAL
(
    USER      VARCHAR(30) NOT NULL,
    PW        VARBINARY(255) NOT NULL   
);

CREATE TABLE LOGINS_HASH  -- SHA2
(
    USER      VARCHAR(30) NOT NULL,
    PW        TEXT NOT NULL   
);

