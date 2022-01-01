USE Labor_SQL;

-- Task 1: All sunk ships
SELECT ship, battle, result
FROM Outcomes
WHERE result = 'sunk'
ORDER BY ship DESC;

-- Task 2: Names of ships ending in 'o' (not 'go')
SELECT name, class
FROM Ships
WHERE class RLIKE '[^g]o$';

-- Task 3: Pairs of PC (speed = ram)
SELECT pc1.model model1, pc2.model model2, pc1.speed, pc1.ram
FROM PC pc1, PC pc2
WHERE pc1.speed = pc2.speed AND pc1.ram = pc2.ram AND pc1.model > pc2.model;

-- Task 4: Ship's classes of Urkaine or classes of all countries
SELECT country, class
FROM Classes
WHERE ('Ukraine' IN (SELECT DISTINCT country FROM Classes) AND country = 'Ukraine')
	OR ('Ukraine' NOT IN (SELECT DISTINCT country FROM Classes));

-- Task 5: Makers of both laptops and printers
SELECT DISTINCT p1.maker
FROM
	(SELECT maker, type FROM Product WHERE type = 'Laptop') p1 
	JOIN 
	(SELECT maker, type FROM Product WHERE type = 'Printer') p2
	ON p1.maker = p2.maker;

-- Task 6: Unite town_from and town_to in Trip table
SELECT trip_no, ID_comp, plane, CONCAT('from ', town_from, ' to ', town_to) destination, time_out, time_in
FROM Trip;

-- Task 7: country, ships_number and launched_year
SELECT table1.country country, table1.ships_number ships_number, MIN(table1.launched) launched
FROM
	(SELECT country, COUNT(name) as ships_number, launched
	FROM
		(SELECT country, name, launched
		FROM (SELECT country, class FROM Classes) table1 
		JOIN Ships table2 ON table1.class = table2.class) 
        AS Ships
	GROUP BY country, launched) 
AS table1
JOIN
	(SELECT country, MAX(ships_number) AS ships_number
    FROM
		(SELECT country, COUNT(name) as ships_number, launched
			FROM
				(SELECT country, name, launched
				FROM (SELECT country, class FROM Classes) table1 
				JOIN Ships table2 ON table1.class = table2.class) 
                AS Ships
			GROUP BY country, launched) 
		AS Ships
	GROUP BY country)
AS table2
ON table1.country = table2.country 
	AND table1.ships_number = table2.ships_number
GROUP BY table1.country, table1.ships_number;

-- Task 8: maker, avg_screen of laptop
SELECT Product.maker maker, AVG(Laptop.screen) avg_screen
FROM 
	(SELECT maker, model FROM Product WHERE type = 'Laptop') Product
	JOIN
	Laptop
	ON Product.model = Laptop.model
GROUP BY maker;

-- Task 9: point, date, payment
SELECT 
	(CASE WHEN pointMore IS NOT NULL THEN pointMore ELSE pointOnce END) AS point,
	(CASE WHEN dateMore IS NOT NULL THEN dateMore ELSE dateOnce END) AS date,
    (CASE 
		WHEN paymentMore IS NULL THEN 'once a day'
        WHEN paymentOnce IS NULL THEN 'more than once a day'
        WHEN paymentMore > paymentOnce THEN 'more than once a day'
		WHEN paymentOnce > paymentMore THEN 'once a day'
        ELSE 'both'
	END) AS payment
FROM
	(SELECT more.point pointMore, more.date dateMore, more.payment paymentMore, 
		once.point pointOnce, once.date dateOnce, once.payment paymentOnce
	FROM
		(SELECT point, date, SUM(Outcome.out) payment
		FROM Outcome
		GROUP BY point, date) 
		more
		LEFT JOIN
		(SELECT point, date, Outcome_o.out payment
		FROM Outcome_o)
		once
		ON more.point = once.point AND more.date = once.date
	UNION
	SELECT more.point, more.date, more.payment, once.point, once.date, once.payment
	FROM
		(SELECT point, date, SUM(Outcome.out) payment
		FROM Outcome
		GROUP BY point, date) 
		more
		RIGHT JOIN
		(SELECT point, date, Outcome_o.out payment
		FROM Outcome_o)
		once
		ON more.point = once.point AND more.date = once.date) 
	AS FullJoin;

-- Task 10: Names of ships with 2 or more words
SELECT name
FROM
	(SELECT DISTINCT name
	FROM Ships
	UNION
	SELECT DISTINCT ship
	FROM Outcomes
	WHERE ship NOT IN (SELECT name FROM Ships))
    AS AllShips
WHERE name RLIKE '^.+[[:space:]].+';
