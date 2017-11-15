CREATE TABLE IF NOT EXISTS numbers (
	id INT NOT NULL
	, name VARCHAR( 60 ) NOT NULL);

GRANT ALL ON numbers TO inAuth;
	
CREATE TABLE IF NOT EXISTS locations (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
	, name VARCHAR( 60 ) NOT NULL
	, lat FLOAT( 10, 6 ) NOT NULL
	, lng FLOAT( 10, 6 ) NOT NULL); 

GRANT ALL ON locations TO inAuth;

TRUNCATE TABLE locations;
INSERT INTO locations(name, lat, lng) VALUES ("LA",34.05223, -118.24368);
INSERT INTO locations(name, lat, lng) VALUES ("Djibouti",11.58901, 43.14503);

INSERT INTO inAuth.locations(name, lat, lng) 
SELECT numbers.name, 180*RAND()-90, 360*RAND()-180
FROM numbers WHERE numbers.id < 10001