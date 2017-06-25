CREATE DATABASE IF NOT EXISTS modelslist;

ALTER DATABASE modelslist
 DEFAULT CHARACTER SET utf8
 DEFAULT COLLATE utf8_general_ci;

USE modelslist;

DROP TABLE IF EXISTS developers;

CREATE TABLE IF NOT EXISTS developers (
  id         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  specialty  VARCHAR(45) NOT NULL,
  experience INT(11) NOT NULL,
  salary     INT(11) NOT NULL,
  INDEX (last_name)
)
  ENGINE = InnoDB;
