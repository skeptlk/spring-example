
CREATE TABLE IF NOT EXISTS BOOK (
    id SERIAL PRIMARY KEY,
    title VARCHAR(256),
    description VARCHAR(256),
    author_id INT,
    library_id INT,
    is_assigned BOOLEAN
);

INSERT INTO BOOK (title,description,author_id,library_id,is_assigned) VALUES
	 ('Java for the impatient','A rapid introduction to the good parts of Java for competent programmers',1,1,false),
	 ('Microservices Patterns','A comprehensive overview of the challenges teams face when moving to microservices, with industry-tested solutions to these problems',2,1,false);

CREATE TABLE IF NOT EXISTS AUTHOR (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(256),
    middle_name VARCHAR(256),
    last_name VARCHAR(256),
    birth_year INT
);

CREATE TABLE IF NOT EXISTS LIBRARY (
    id SERIAL PRIMARY KEY,
    name VARCHAR(256),
    description VARCHAR(256)
);
