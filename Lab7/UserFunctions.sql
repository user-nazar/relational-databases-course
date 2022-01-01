USE DB_Lab7;

DROP FUNCTION IF EXISTS findMinEntranceYearFromGroup;
DROP FUNCTION IF EXISTS findGroupNameAndEntranceYearByGroupID;

DELIMITER //
CREATE FUNCTION findMinEntranceYearFromGroup()
RETURNS INT
BEGIN
	RETURN (SELECT MIN(entrance_year) FROM `group`);
END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION findGroupNameAndEntranceYearByGroupID(groupID INT)
RETURNS VARCHAR(45)
BEGIN
	RETURN (SELECT CONCAT(name, " ", entrance_year) FROM `group` WHERE id = groupID);
END //
DELIMITER ;

-- USAGE

SELECT id, name, number, entrance_year
FROM `group`
WHERE entrance_year = findMinEntranceYearFromGroup();

SELECT id, name, surname, rating, birthday, entrance_date, student_card_number, 
	email, city_name, group_id, graduated_secondary_school_id,
    findGroupNameAndEntranceYearByGroupID(group_id) AS group_name_and_entrance_year
FROM `student`;
