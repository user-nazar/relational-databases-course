USE DB_Lab7;

DROP TRIGGER IF EXISTS BeforeInsertCityCheckFK;
DROP TRIGGER IF EXISTS BeforeInsertGraduatedSecondarySchoolCheckFK;
DROP TRIGGER IF EXISTS BeforeInsertStudentCheckFK;
DROP TRIGGER IF EXISTS BeforeInsertStudentHasDebtCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteStudentCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteDebtCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteGroupCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteGraduatedSecondarySchoolCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteCityCheckFK;
DROP TRIGGER IF EXISTS BeforeDeleteRegionCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateStudentCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateDebtCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateGroupCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateGraduatedSecondarySchoolCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateCityCheckFK;
DROP TRIGGER IF EXISTS BeforeUpdateRegionCheckFK;
DROP TRIGGER IF EXISTS BeforeInsertRegionCheckCode;
DROP TRIGGER IF EXISTS BeforeUpdateRegionCheckCode;
DROP TRIGGER IF EXISTS BeforeInsertStudentCheckStudentCardNumber;
DROP TRIGGER IF EXISTS BeforeUpdateStudentCheckStudentCardNumber;
DROP TRIGGER IF EXISTS AfterInsertCityCheckCardinality;
DROP TRIGGER IF EXISTS AfterDeleteCityCheckCardinality;

DELIMITER //
CREATE TRIGGER BeforeInsertCityCheckFK
BEFORE INSERT
ON `city` FOR EACH ROW
BEGIN
	IF (new.region_name NOT IN (SELECT name FROM `region`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Insert: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertGraduatedSecondarySchoolCheckFK
BEFORE INSERT
ON `graduated_secondary_school` FOR EACH ROW
BEGIN
	IF (new.city_name NOT IN (SELECT name FROM `city`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Insert: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertStudentCheckFK
BEFORE INSERT
ON `student` FOR EACH ROW
BEGIN
	IF (
		new.city_name NOT IN (SELECT name FROM `city`) 
		OR new.group_id NOT IN (SELECT id FROM `group`)
		OR new.graduated_secondary_school_id NOT IN (SELECT id FROM `graduated_secondary_school`)
    )
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Insert: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertStudentHasDebtCheckFK
BEFORE INSERT
ON `student_has_debt` FOR EACH ROW
BEGIN
	IF (
		new.student_id NOT IN (SELECT id FROM `student`) 
		OR new.debt_id NOT IN (SELECT id FROM `debt`)
    )
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Insert: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteStudentCheckFK
BEFORE DELETE
ON `student` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_id FROM `student_has_debt`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteDebtCheckFK
BEFORE DELETE
ON `debt` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT debt_id FROM `student_has_debt`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteGroupCheckFK
BEFORE DELETE
ON `group` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT group_id FROM `student`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteGraduatedSecondarySchoolCheckFK
BEFORE DELETE
ON `graduated_secondary_school` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT graduated_secondary_school_id FROM `student`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteCityCheckFK
BEFORE DELETE
ON `city` FOR EACH ROW
BEGIN
	IF (
		old.name IN (SELECT city_name FROM `student`) 
		OR old.name IN (SELECT city_name FROM `graduated_secondary_school`)
    )
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteRegionCheckFK
BEFORE DELETE
ON `region` FOR EACH ROW
BEGIN
	IF (old.name IN (SELECT region_name FROM `city`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Delete: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateStudentCheckFK
BEFORE UPDATE
ON `student` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT student_id FROM `student_has_debt`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateDebtCheckFK
BEFORE UPDATE
ON `debt` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT debt_id FROM `student_has_debt`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateGroupCheckFK
BEFORE UPDATE
ON `group` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT group_id FROM `student`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateGraduatedSecondarySchoolCheckFK
BEFORE UPDATE
ON `graduated_secondary_school` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT graduated_secondary_school_id FROM `student`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateCityCheckFK
BEFORE UPDATE
ON `city` FOR EACH ROW
BEGIN
	IF (old.name != new.name 
        AND (
			old.name IN (SELECT city_name FROM `student`) 
			OR old.name IN (SELECT city_name FROM `graduated_secondary_school`)
		)
    )
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateRegionCheckFK
BEFORE UPDATE
ON `region` FOR EACH ROW
BEGIN
	IF (old.name != new.name AND old.name IN (SELECT region_name FROM `city`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Update: foreign key failure";
	END IF;
END //
DELIMITER ;

-- Check for region code pattern

DELIMITER //
CREATE TRIGGER BeforeInsertRegionCheckCode
BEFORE INSERT
ON `region` FOR EACH ROW
BEGIN
	IF (new.code NOT RLIKE CONCAT("^", SUBSTRING(new.name, 1, 2), "[0-9][0-9][0-9]$"))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Region: code does not match the pattern";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateRegionCheckCode
BEFORE UPDATE
ON `region` FOR EACH ROW
FOLLOWS BeforeUpdateRegionCheckFK
BEGIN
	IF (new.code NOT RLIKE CONCAT("^", SUBSTRING(new.name, 1, 2), "[0-9][0-9][0-9]$"))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Region: code does not match the pattern";
	END IF;
END //
DELIMITER ;

-- Check pattern for number of student card

DELIMITER //
CREATE TRIGGER BeforeInsertStudentCheckStudentCardNumber
BEFORE INSERT
ON `student` FOR EACH ROW
FOLLOWS BeforeInsertStudentCheckFK
BEGIN
	IF (new.student_card_number RLIKE "00$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Student: student card number does not match the pattern";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateStudentCheckStudentCardNumber
BEFORE UPDATE
ON `student` FOR EACH ROW
FOLLOWS BeforeUpdateStudentCheckFK
BEGIN
	IF (new.student_card_number RLIKE "00$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for Student: student card number does not match the pattern";
	END IF;
END //
DELIMITER ;

-- Check for table `city` cardinality

DELIMITER //
CREATE TRIGGER AfterInsertCityCheckCardinality
AFTER INSERT
ON `city` FOR EACH ROW
BEGIN
	IF ((SELECT COUNT(*) FROM `city`) NOT BETWEEN 3 AND 7)
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for City: cardinality is allowed between 3 and 7";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterDeleteCityCheckCardinality
AFTER DELETE
ON `city` FOR EACH ROW
BEGIN
	IF ((SELECT COUNT(*) FROM `city`) NOT BETWEEN 3 AND 7)
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "CHECK error for City: cardinality is allowed between 3 and 7";
	END IF;
END //
DELIMITER ;
