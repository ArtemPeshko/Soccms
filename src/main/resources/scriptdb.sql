DROP DATABASE IF EXISTS soccmsDB;
 
CREATE DATABASE IF NOT EXISTS soccmsDB;
 
USE soccmsDB;

CREATE TABLE user_role (
  id   BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  role VARCHAR(30)        NOT NULL
) ENGINE = InnoDB;

CREATE TABLE profile
(
  id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  firstname   VARCHAR(30),
  lastname    VARCHAR(30),
  birthDate   DATE,
  email       VARCHAR(30) UNIQUE,
  age         INT(30)                     DEFAULT NULL,
  sex         VARCHAR(30),
  city        VARCHAR(30),
  phoneNumber VARCHAR(30)
) ENGINE = InnoDB;

CREATE TABLE user
(
  id        BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email     VARCHAR(30)        NOT NULL UNIQUE,
  username  VARCHAR(30)        NOT NULL UNIQUE,
  password  VARCHAR(60)        NOT NULL,
  enabled   TINYINT            NOT NULL DEFAULT 1,
  profileID BIGINT             NOT NULL,
  roleID    BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id),
  FOREIGN KEY (roleID) REFERENCES user_role (id)
    ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE message (
  id            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  senderID      BIGINT             NOT NULL,
  destinationID BIGINT             NOT NULL,
  messagedate   DATETIME           NOT NULL,
  text          VARCHAR(1024),
  FOREIGN KEY (senderID) REFERENCES profile (id),
  FOREIGN KEY (destinationID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE photo (
  id              BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  photo_file_name VARCHAR(64)        NOT NULL UNIQUE,
  profileID       BIGINT             NOT NULL,
  FOREIGN KEY (profileID) REFERENCES profile (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE post (
  id                    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  text                  VARCHAR(1024),
  date                  DATETIME           NOT NULL,
  photo_file_name       VARCHAR(64) UNIQUE,
  profile_sender_id     BIGINT             NOT NULL,
  wall_owner_profile_id BIGINT             NOT NULL,
  FOREIGN KEY (profile_sender_id) REFERENCES profile (id),
  FOREIGN KEY (wall_owner_profile_id) REFERENCES profile (id)
) ENGINE = InnoDB;

CREATE TABLE friend (
  id                    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  main_profile_id       BIGINT             NOT NULL,
  friends_profile_id    BIGINT             NOT NULL,
  friend_request_status ENUM ('PENDING_REQUEST', 'APPROVED_REQUEST', 'REJECTED_REQUEST'),
  FOREIGN KEY (main_profile_id) REFERENCES profile (id),
  FOREIGN KEY (friends_profile_id) REFERENCES profile (id),
  UNIQUE KEY main_profile_id (main_profile_id, friends_profile_id)
) ENGINE = InnoDB;

CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) PRIMARY KEY,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL
) ENGINE = InnoDB;

INSERT INTO soccmsDB.user_role VALUES (NULL, 'ROLE_ADMIN');
INSERT INTO soccmsDB.user_role VALUES (NULL, 'ROLE_USER');
 
 
INSERT INTO profile VALUES (1, 'Artem', 'Peshko', '1990-11-11', 'artem.peshko@gmail.com', 26, 'male', 'Minsk', 0296895779);
INSERT INTO user VALUES (1, 'artem.peshko@gmail.com', 'Artem',
                         '$2a$10$6.TAKaQPV1ZkaueKbtCEsesVNyzT0wrd93u6yeHpC6oEv90I/W5Ou', 1, 1, 1);
 
INSERT INTO profile VALUES (2, 'Misha', 'Shturo', '1991-06-26', 'shturo@gmail.com', 25, 'male', 'Minsk', 0291796214);
INSERT INTO user VALUES (2, 'shturo@gmail.com', 'Misha',
                         '$2a$10$6.TAKaQPV1ZkaueKbtCEsesVNyzT0wrd93u6yeHpC6oEv90I/W5Ou', 1, 2, 1);
