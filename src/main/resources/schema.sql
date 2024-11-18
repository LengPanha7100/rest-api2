CREATE DATABASE rest_api2;

CREATE TABLE venues_db(
    id SERIAL PRIMARY KEY ,
    venues_name varchar(100),
    location varchar(200)
);
SELECT * FROM venues_db;
SELECT * FROM venues_db WHERE id=1;
INSERT INTO venues_db(venues_name, location)
values ('rmol','kpc');

UPDATE venues_db
SET venues_name='koh', location = 'kompong cham'
WHERE id=1;

DELETE FROM venues_db WHERE id = 4;

CREATE TABLE attendees_db(
    attendees_id SERIAL PRIMARY KEY,
    attendees_name varchar(100) not null ,
    email varchar(100) not null
);

SELECT *FROM attendees_db;
SELECT *FROM attendees_db where attendees_id = 1;
INSERT INTO attendees_db(attendees_name, email)
VALUES ('panha','lengpanha789@gmail.com');
DELETE FROM attendees_db where attendees_id = 2;

UPDATE attendees_db
SET attendees_name = 'cher nak' , email ='nak@gmail.com'
WHERE attendees_id = 1












