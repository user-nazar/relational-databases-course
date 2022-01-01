USE DB_Lab7;

DROP PROCEDURE IF EXISTS insertIntoRegion;
DROP PROCEDURE IF EXISTS selectFromStudentHasDebt;
DROP PROCEDURE IF EXISTS copyRegion;

DELIMITER //
CREATE PROCEDURE insertIntoRegion(IN name varchar(45), IN code varchar(45))
BEGIN
    INSERT INTO `region`(`name`, `code`) 
    VALUES (name, code);
END
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE selectFromStudentHasDebt(IN student_full_name varchar(90))
BEGIN
	IF (student_full_name IS NULL) 
    THEN
		SELECT 
			(SELECT CONCAT(name, " ", surname) FROM `student` WHERE id = student_id) AS full_name, 
			(SELECT subject FROM `debt` WHERE id = debt_id) AS subject
		FROM `student_has_debt`;
	ELSE
		SELECT full_name, subject
        FROM (
			SELECT 
				(SELECT CONCAT(name, " ", surname) FROM `student` WHERE id = student_id) AS full_name, 
				(SELECT subject FROM `debt` WHERE id = debt_id) AS subject
			FROM `student_has_debt`
		) AS new_student_has_debt
		WHERE full_name = student_full_name;
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE copyRegion()
BEGIN

DECLARE done int DEFAULT false;
DECLARE region_name, region_code VARCHAR(45);
DECLARE new_region_table1 VARCHAR(45) DEFAULT CONCAT("region", CURRENT_TIMESTAMP());
DECLARE new_region_table2 VARCHAR(45) DEFAULT CONCAT("region", DATE_ADD(CURRENT_TIMESTAMP(), INTERVAL 1 SECOND));

DECLARE region_cursor CURSOR
FOR SELECT name, code FROM `region`;
DECLARE CONTINUE HANDLER
FOR NOT FOUND SET done = true;

OPEN region_cursor;

SET @temp_query=CONCAT("CREATE TABLE IF NOT EXISTS `", new_region_table1, 
	"` (`name` VARCHAR(45) NOT NULL, `code` VARCHAR(45) NOT NULL, PRIMARY KEY (`name`))");
PREPARE myquery FROM @temp_query;
EXECUTE myquery;
DEALLOCATE PREPARE myquery;

SET @temp_query=CONCAT("CREATE TABLE IF NOT EXISTS `", new_region_table2, 
	"` (`name` VARCHAR(45) NOT NULL, `code` VARCHAR(45) NOT NULL, PRIMARY KEY (`name`))");
PREPARE myquery FROM @temp_query;
EXECUTE myquery;
DEALLOCATE PREPARE myquery;

myLoop: LOOP

	FETCH region_cursor INTO region_name, region_code;

	IF done=true THEN LEAVE myLoop;
	END IF;

	SET @temp_query=CONCAT("INSERT INTO `", 
		IF(FLOOR(RAND() * 10) % 2 <> 0, new_region_table1, new_region_table2), 
        "` (`name`, `code`) VALUES ('", region_name, "', '", region_code, "')");

	PREPARE myquery FROM @temp_query;
	EXECUTE myquery;
	DEALLOCATE PREPARE myquery;

END LOOP;
CLOSE region_cursor;

END //
DELIMITER ;
