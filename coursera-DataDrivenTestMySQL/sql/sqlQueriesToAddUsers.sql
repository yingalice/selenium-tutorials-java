CREATE DATABASE Guru99TestData;

USE Guru99TestData;

CREATE TABLE users (
  username varchar(255), 
  password varchar(255)
);

INSERT INTO users (username, password) VALUES ('mngr546003', 'bEhYrAs');
INSERT INTO users (username, password) VALUES ('mngr546829', 'turAduz');
INSERT INTO users (username, password) VALUES ('mngr546830', 'AsabEbY');

DELETE FROM users WHERE username = 'mngr546829';

SELECT * FROM users;