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

