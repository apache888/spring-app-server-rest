CREATE DATABASE IF NOT EXISTS modelslist;

ALTER DATABASE modelslist
 DEFAULT CHARACTER SET utf8
 DEFAULT COLLATE utf8_general_ci;

USE modelslist;


DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS developers;

-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Table: developers
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
