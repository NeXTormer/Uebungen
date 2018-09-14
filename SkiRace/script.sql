USE htl_skirace;

SHOW TABLES;

DESC participants;
TRUNCATE participants;

INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Peter", "Raser", "1988-08-24", 25, "SOB", 34534.21, 234534.45, 574537.88);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Werner", "Werner", "1944-11-11", 1, "AND", 3534.21, 23534.45, 57457.88);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Manfred", "Huettner", "1988-08-24", 44, "LEH", 34534.21*1.124213, 234534.45*1.23432, 574537.88*1.23695);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Hans", "Angermann", "1995-01-01", 42, "SUN", 34534.21*1.54513, 234534.45*1.455432, 574537.88*1.88695);

SELECT * FROM participants ORDER BY total ASC;