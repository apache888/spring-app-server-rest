DROP TABLE developers IF EXISTS;


CREATE TABLE developers (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  specialty  VARCHAR(45) NOT NULL,
  experience INTEGER NOT NULL,
  salary     INTEGER NOT NULL
);
