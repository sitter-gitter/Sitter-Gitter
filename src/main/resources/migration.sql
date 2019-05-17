CREATE DATABASE IF NOT EXISTS sitter_gitter_db;
USE sitter_gitter_db;

DROP TABLE IF EXISTS specifications;
DROP TABLE IF EXISTS available_times;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS children;
DROP TABLE IF EXISTS users;  # need to drop tables in reverse order!!!


CREATE TABLE users
(
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username     VARCHAR(255) NOT NULL,
  email    VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(100),
  city VARCHAR(100),
  state VARCHAR(100),
  zip_code VARCHAR(45),
  is_babysitter TINYINT,
  PRIMARY KEY (id),
  UNIQUE KEY unique_username (username)
);

CREATE TABLE children
(
  id      INT UNSIGNED   NOT NULL AUTO_INCREMENT,
  name    VARCHAR(45)   NOT NULL,
  birthdate  DATE   NOT NULL,
  special_note VARCHAR(255),
  parent_id INT UNSIGNED   NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (parent_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE appointments
(
  id      INT UNSIGNED   NOT NULL AUTO_INCREMENT,
  start    DATETIME   NOT NULL,
  end   DATETIME   NOT NULL,
  sitter_approved TINYINT NOT NULL,
  babysitter_id INT UNSIGNED,
  parent_id INT UNSIGNED,
  PRIMARY KEY (id),
  FOREIGN KEY (babysitter_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (parent_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE reviews
(
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(255),
  body VARCHAR(255),
  is_recommended TINYINT,
  babysitter_id INT UNSIGNED   NULL,
  parent_id INT UNSIGNED NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (babysitter_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (parent_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE available_times
(
  id      INT UNSIGNED   NOT NULL AUTO_INCREMENT,
  start    DATETIME   NOT NULL,
  end   DATETIME   NOT NULL,
  babysitter_id INT UNSIGNED   NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (babysitter_id) REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE specifications
(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  is_smoker TINYINT,
  has_cpr_training TINYINT,
  has_transportation TINYINT,
  years_of_experience INT,
  birthdate DATE,
  babysitter_id INT UNSIGNED   NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (babysitter_id) REFERENCES users (id) ON DELETE CASCADE
);
#   education_level ENUM('Still in high school', 'High School Degree', 'College Degree'),
