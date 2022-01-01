SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `shutka` DEFAULT CHARACTER SET utf8;
USE `shutka`;


DROP TABLE IF EXISTS `client`;
DROP TABLE IF EXISTS `account`;
DROP TABLE IF EXISTS `city` ;
DROP TABLE IF EXISTS `department_type` ;
DROP TABLE IF EXISTS `department` ;
DROP TABLE IF EXISTS `courier` ;
DROP TABLE IF EXISTS `operator` ;
DROP TABLE IF EXISTS `order` ;


CREATE TABLE `client` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    phone DECIMAL(12 , 0 ) NOT NULL,
    address VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (id)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `account` (
    client_id INT(11) NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    PRIMARY KEY (client_id)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `city` (
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY (name)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `department_type` (
    size VARCHAR(45) NOT NULL,
    max_weight INT(11) NOT NULL,
    PRIMARY KEY (size)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `department` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    department_type_size VARCHAR(45) NOT NULL,
    city_name VARCHAR(45) NOT NULL,
    number INT(11) NOT NULL,
    address VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `courier` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    department_id INT(11) NOT NULL,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    phone DECIMAL(12 , 0 ) NOT NULL,
    birthday DATE NOT NULL,
    PRIMARY KEY (id)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `operator` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    department_id INT(11) NOT NULL,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    phone DECIMAL(12 , 0 ) NOT NULL,
    birthday DATE NOT NULL,
    PRIMARY KEY (id)
)  DEFAULT CHARACTER SET=UTF8;


CREATE TABLE `order` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    from_department_id INT(11) NOT NULL,
    to_department_id INT(11) NOT NULL,
    from_operator_id INT(11) NOT NULL,
    to_operator_id INT(11) NOT NULL,
    from_courier_id INT(11) NULL DEFAULT NULL,
    to_courier_id INT(11) NULL DEFAULT NULL,
    from_client_id INT(11) NOT NULL,
    to_client_id INT(11) NOT NULL,
    delivery_price DECIMAL(10 , 2 ) NOT NULL,
    product_price DECIMAL(10 , 2 ) NULL DEFAULT NULL,
    weight INT(11) NOT NULL,
    sending_date DATE NOT NULL,
    approximate_arrival_date DATE NOT NULL,
    fixed_arrival_date DATE NULL DEFAULT NULL,
    PRIMARY KEY (id)
)  DEFAULT CHARACTER SET=UTF8;


ALTER TABLE `account`
	ADD UNIQUE INDEX username_UNIQUE (username ASC),
    ADD UNIQUE INDEX password_UNIQUE (password ASC),
    ADD UNIQUE INDEX email_UNIQUE (email ASC),
    ADD CONSTRAINT fk_account_client1 
		FOREIGN KEY (client_id)
        REFERENCES client (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION;


ALTER TABLE `department`
	ADD INDEX fk_department_department_type1_idx (department_type_size ASC),
    ADD INDEX fk_department_city1_idx (city_name ASC),
    ADD CONSTRAINT fk_department_city1 
		FOREIGN KEY (city_name)
        REFERENCES city (name)
        ON DELETE NO ACTION 
		ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_department_department_type1 
		FOREIGN KEY (department_type_size)
        REFERENCES department_type (size)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION;


ALTER TABLE `courier`
	ADD INDEX fk_courier_department1_idx (department_id ASC),
    ADD CONSTRAINT fk_courier_department1 
		FOREIGN KEY (department_id)
        REFERENCES department (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION;


ALTER TABLE `operator`
	ADD INDEX fk_operator_department1_idx (department_id ASC),
    ADD CONSTRAINT fk_operator_department1 
		FOREIGN KEY (department_id)
        REFERENCES department (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION;


ALTER TABLE `order`
	ADD INDEX fk_order_department1_idx (from_department_id ASC),
    ADD INDEX fk_order_department2_idx (to_department_id ASC),
    ADD INDEX fk_order_operator1_idx (from_operator_id ASC),
    ADD INDEX fk_order_operator2_idx (to_operator_id ASC),
    ADD INDEX fk_order_courier1_idx (from_courier_id ASC),
    ADD INDEX fk_order_courier2_idx (to_courier_id ASC),
    ADD INDEX fk_order_client1_idx (from_client_id ASC),
    ADD INDEX fk_order_client2_idx (to_client_id ASC),
    ADD CONSTRAINT fk_order_client1 
		FOREIGN KEY (from_client_id)
        REFERENCES client (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_client2 
		FOREIGN KEY (to_client_id)
        REFERENCES client (id)
        ON DELETE NO ACTION 
		ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_courier1 
		FOREIGN KEY (from_courier_id)
        REFERENCES courier (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_courier2 
		FOREIGN KEY (to_courier_id)
        REFERENCES courier (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_department1 
		FOREIGN KEY (from_department_id)
        REFERENCES department (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_department2 
		FOREIGN KEY (to_department_id)
        REFERENCES department (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_operator1 
		FOREIGN KEY (from_operator_id)
        REFERENCES operator (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_order_operator2 
		FOREIGN KEY (to_operator_id)
        REFERENCES operator (id)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- Inserts of all data
START TRANSACTION;
USE `shutka`;


INSERT INTO `department_type` (size, max_weight)
VALUES ('small', 3),('medium', 10),('large', 30);

INSERT INTO `city` (name)
VALUES
	('Kyiv'),('Kharkiv'),('Odessa'),('Dnipro'),('Zaporizhia'),
    ('Lviv'),('Cherkasy'),('Chernihiv'),('Chernivtsi'),('Ivano-Frankivsk'),
    ('Poltava'),('Rivne'),('Ternopil'),('Vinnytsia'),('Uzhhorod');

INSERT INTO `department` (department_type_size, city_name, number, address) 
VALUES 
	('medium', 'Lviv', 13, 'Stavova, 7b'),
	('medium', 'Lviv', 14, 'Slovatskoho, 5'),
	('large', 'Lviv', 7, 'Lychakivska, 8'),
	('small', 'Lviv', 66, 'Horodotska, 131'),
	('medium', 'Kyiv', 48, 'Mykhaila Boichuka, 7/11'),
	('large', 'Kyiv', 251, 'Prospekt Sobornosti, 5'),
	('large', 'Kyiv', 25, 'Marshala Tymoshenka, 9'),
	('medium', 'Kharkiv', 25, 'Traktorobudivnykiv Ave, 57'),
	('medium', 'Kharkiv', 39, 'Haharina Ave, 48'),
	('large', 'Kharkiv', 109, 'Poltavskyi Shliakh, 17');

INSERT INTO `client` (name, surname, phone, address) 
VALUES 
	('Denis', 'Ritchi', 380665542333, DEFAULT),
	('Anne', 'Reim', 380662645341, DEFAULT),
	('John', 'Sivel', 380975541239, 'King Ave, 65/23'),
	('Tom', 'Glen', 380632658941, DEFAULT),
	('Piter', 'Wind', 380984872351, 'Liberty, 88'),
	('John', 'Heshtem', 380686648571, DEFAULT),
	('Elise', 'Pain', 380502630117, 'Khmelnytskoho, 43b'),
	('Mery', 'Kor', 380963210781, DEFAULT),
	('Vincent', 'Stekven', 380931247964, DEFAULT),
	('Anastasia', 'Heshtem', 380675412781, 'Saharova, 23');

INSERT INTO `account` (client_id, username, password, email) 
VALUES 
	(3, 'richyMan', 'asdfs234', 'dRitch@gmail.com'),
    (5, 'wind777', 'windyweatherwith7', 'piter.wind@gmail.com'),
    (7, 'unburnt', 'EFs2d4fS3dfs23', 'elise.p.un@ukr.net'),
    (10, 'userUndefined', '1234somethinghere', 'heshtem2606@gmail.com');

INSERT INTO `courier` (department_id, name, surname, address, phone, birthday) 
VALUES 
	(1, 'Elen', 'Pain', 'Horodotska, 44', 380682498574, '1989-07-23'),
    (2, 'Vasyl', 'Plast', 'Liberty, 77/23', 380979855124, '1976-11-12'),
    (3, 'David', 'Cron', 'Sny, 23', 380932465781, '1996-07-02'),
    (4, 'James', 'Marv', 'Senera, 96', 380964446892, '1992-03-17'),
    (5, 'Milley', 'Rainov', 'Solomana, 56', 380508875412, '1989-08-24'),
    (6, 'John', 'Vircon', 'Shevchenka, 37', 380682653189, '1994-12-12'),
    (7, 'Alan', 'Crock', 'Remeira, 92', 380958437951, '1991-09-13'),
    (8, 'Pavlo', 'Stin', 'Peremohy, 56/12', 380691234875, '1995-04-30'),
    (9, 'Slaine', 'Ron', 'Ceremony, 61a', 380665269718, '1998-05-01'),
    (10, 'Roger', 'Barly', 'Crystal, 39b', 380975248963, '1987-01-22');

INSERT INTO `operator` (department_id, name, surname, address, phone, birthday) 
VALUES 
	(1, 'Mathew', 'Rovry', 'Horodotska, 44', 380567884126, '1993-05-20'),
    (2, 'Vasyl', 'Plast', 'Liberty, 77/23', 380979855124, '1976-11-12'),
    (3, 'Jimm', 'Morr', 'Verasu, 3', 380506676851, '1986-12-12'),
    (4, 'John', 'Cefer', 'Selvena, 11', 380928845124, '1992-03-17'),
    (5, 'Angelina', 'Cipher', 'Solomona, 12', 380501297512, '1989-08-24'),
    (6, 'John', 'Korm', 'Shevchenka, 33', 380682775489, '1994-12-12'),
    (7, 'Bill', 'Cage', 'Marshala, 12a', 380675619854, '1991-09-13'),
    (8, 'Lilly', 'Sunfall', 'Slova, 5/22', 380985487323, '1995-04-30'),
    (9, 'Sara', 'Raven', 'Vody, 3a', 380663552416, '1998-05-01'),
    (10, 'Sam', 'Tarly', 'Split, 14', 380994812564, '1987-01-22');

INSERT INTO `order` 
	(from_department_id, to_department_id, from_operator_id, to_operator_id, 
    from_courier_id, to_courier_id, from_client_id, to_client_id, 
    delivery_price, product_price, weight, 
    sending_date, approximate_arrival_date, fixed_arrival_date) 
VALUES 
	(1, 7, 1, 7, DEFAULT, DEFAULT, 1, 6, 30, DEFAULT, 2, CURDATE(), CURDATE() + INTERVAL 1 DAY, DEFAULT),
	(1, 10, 1, 10, DEFAULT, DEFAULT, 1, 10, 40, DEFAULT, 10, CURDATE(), CURDATE() + INTERVAL 2 DAY, DEFAULT),
	(3, 6, 3, 6, 3, DEFAULT, 3, 6, 60, DEFAULT, 2, CURDATE(), CURDATE() + INTERVAL 3 DAY, DEFAULT),
	(5, 2, 5, 2, DEFAULT, DEFAULT, 5, 2, 30, DEFAULT, 2, CURDATE(), CURDATE() + INTERVAL 1 DAY, DEFAULT),
	(6, 1, 6, 1, DEFAULT, DEFAULT, 6, 1, 30, DEFAULT, 2, CURDATE(), CURDATE() + INTERVAL 2 DAY, DEFAULT),
	(2, 7, 2, 7, DEFAULT, DEFAULT, 2, 6, 40, DEFAULT, 3, CURDATE(), CURDATE() + INTERVAL 1 DAY, DEFAULT),
	(8, 5, 8, 5, DEFAULT, DEFAULT, 8, 5, 40, DEFAULT, 3, CURDATE(), CURDATE() + INTERVAL 2 DAY, DEFAULT),
	(3, 10, 3, 10, 3, 10, 3, 6, 60, 250, 2, CURDATE(), CURDATE() + INTERVAL 3 DAY, DEFAULT),
	(3, 6, 3, 6, 3, DEFAULT, 3, 6, 60, 899.99, 1, CURDATE(), CURDATE() + INTERVAL 3 DAY, DEFAULT),
	(3, 8, 3, 8, 3, DEFAULT, 3, 6, 60, 599.99, 1, CURDATE(), CURDATE() + INTERVAL 3 DAY, DEFAULT);


COMMIT;
