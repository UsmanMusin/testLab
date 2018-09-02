CREATE TABLE SONG (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
  name VARCHAR(50),
  artist VARCHAR(50),
  album VARCHAR(50),
  date INT,
  duration INT
);

CREATE TABLE USERS (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
  login VARCHAR(50),
  password VARCHAR(50),
  isadmin BOOLEAN
);

INSERT INTO SONG (NAME, ARTIST, ALBUM, DATE, DURATION) VALUES
 ('Sweet Emotion', 'Aerosmith', 'Toys in the Attic', 1975, 280),
  ('Kashmir','Led Zeppelin','Physical Graffiti', 1975, 546),
  ('Gimme Shelter','The Rolling Stones','Let It Bleed',1969, 277);

INSERT INTO USERS (LOGIN, PASSWORD, ISADMIN) VALUES
  ('admin','1234',TRUE ),
  ('user','1',FALSE);
