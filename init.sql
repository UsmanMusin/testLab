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
  ('Gimme Shelter','The Rolling Stones','Let It Bleed',1969, 277),
  ('Back in Black','AC/DC','Back in Black',1980, 255),
  ('A Day in the Life','The Beatles','Sgt. Pepper’s Lonely Hearts Club Band',1967, 333),
  ('All Along the Watchtower','The Jimi Hendrix Experience','Electric Ladyland',1968, 151),
  ('Bohemian Rhapsody','Queen','A Night at the Opera',1975, 355),
  ('Everybody Wants Some!!','Van Halen','Women and Children First',1980, 308),
  ('Comfortably Numb','Pink Floyd','The Wall',1979, 239),
  ('Paranoid','Black Sabbath','Paranoid',1970, 168),
  ('Baba O’Riley','The Who','Who’s Next',1971, 308),
  ('Sweet Child O Mine','Guns N Roses','Appetite for Destruction',1987, 252);

INSERT INTO USERS (LOGIN, PASSWORD, ISADMIN) VALUES
  ('admin','1234',TRUE ),
  ('user','1',FALSE),
  ('user2','2',FALSE);
