DROP TABLE IF EXISTS ANIMAL;

CREATE TABLE ANIMAL (

	ANIMAL_ID VARCHAR(32) PRIMARY KEY,
	SPECIES VARCHAR(10),
	ANIMAL_NAME VARCHAR(30),
	AGE INT,
	ISALIVE VARCHAR(3)

);