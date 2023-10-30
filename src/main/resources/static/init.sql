
DROP TABLE BOOK;
DROP TABLE AUTHOR;
DROP TABLE LIBRARY;


CREATE TABLE IF NOT EXISTS BOOK (
    id SERIAL PRIMARY KEY,
    title VARCHAR(256),
    description VARCHAR(256),
    author_id INT,
    library_id INT,
    is_assigned BOOLEAN
);


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
