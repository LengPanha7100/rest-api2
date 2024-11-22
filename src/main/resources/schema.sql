
CREATE TABLE venues_db(
                          id SERIAL PRIMARY KEY ,
                          venues_name varchar(100) not null ,
                          location varchar(200) not null
);

SELECT * FROM venues_db
LIMIT 1
    OFFSET 10
;
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
WHERE attendees_id = 1;


CREATE TABLE events_db(
                          event_id SERIAL primary key ,
                          event_name varchar(100) not null ,
                          event_date timestamp not null ,
                          venues_id INT,
                          CONSTRAINT fk_venues FOREIGN KEY (venues_id) REFERENCES venues_db(id) ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT *FROM events_db;
SELECT * FROM venues_db;
-- INSERT INTO events_db(event_name, event_date, venues_id)
-- VALUES ('123',,1)

CREATE TABLE event_attendees_db(
                                   id SERIAL PRIMARY KEY ,
                                   event_id INT,
                                   attendees_id INT,
                                   CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events_db(event_id) ON DELETE CASCADE ON UPDATE CASCADE ,
                                   CONSTRAINT fk_attendees FOREIGN KEY (attendees_id) REFERENCES attendees_db(attendees_id) ON DELETE CASCADE ON UPDATE CASCADE
);
SELECT a.attendees_id , a.attendees_name , a.email FROM attendees_db a
                                                            JOIN event_attendees_db ead on a.attendees_id = ead.attendees_id
where event_id = 1;
SELECT *FROM events_db ;

INSERT INTO events_db (event_name, event_date, venues_id)
VALUES ('homecoming','2024-06-17 23:00:57.000000',1);

INSERT INTO event_attendees_db(event_id, attendees_id)
VALUES (1,1);

UPDATE events_db
SET event_name = 'home' , event_date ='2024-06-18 23:00:57.000000' ,venues_id=1
where event_id = 2
returning *;

DELETE FROM event_attendees_db where event_id = 2;


DELETE FROM events_db where event_id=4


