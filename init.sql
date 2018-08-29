CREATE TABLE SONG (
  id INT PRIMARY KEY GENERATED ALWAYS ,
  name VARCHAR(50),
  artist VARCHAR(50),
  album VARCHAR(50),
  date INT,
  duration INT
);

INSERT INTO SONG (NAME, ARTIST, ALBUM, DATE, DURATION) VALUES
 ('Sweet Emotion', 'Aerosmith', 'Toys in the Attic', 1975, 280),
  ('Kashmir','Led Zeppelin','Physical Graffiti', 1975, 546),
  ('Gimme Shelter','The Rolling Stones','Let It Bleed',1969, 277);
