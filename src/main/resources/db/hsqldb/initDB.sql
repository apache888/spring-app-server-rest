DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS developers;

-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL PRIMARY KEY IDENTITY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);
-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL PRIMARY KEY IDENTITY,
  name VARCHAR(100) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
  --PRIMARY KEY (user_id, role_id)
);
CREATE TABLE developers (
  id         INTEGER PRIMARY KEY IDENTITY,
  first_name VARCHAR(100) NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  specialty  VARCHAR(45)  NOT NULL,
  experience INTEGER      NOT NULL,
  salary     INTEGER      NOT NULL
);
