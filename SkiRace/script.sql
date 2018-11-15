USE htl_skirace;

SHOW TABLES;

DESC participants;
TRUNCATE participants;

INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Peter", "Raser", "1988-08-24", 25, "SOB", 34534.21, 234534.45, 574537.88);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Werner", "Werner", "1944-11-11", 1, "AND", 3534.21, 23534.45, 57457.88);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Manfred", "Huettner", "1988-08-24", 44, "LEH", 34534.21*1.124213, 234534.45*1.23432, 574537.88*1.23695);
INSERT INTO participants (name, surname, dob, startnr, category, zw1, zw2, total) VALUES ("Hans", "Angermann", "1995-01-01", 42, "SUN", 34534.21*1.54513, 234534.45*1.455432, 574537.88*1.88695);

SELECT * FROM participants ORDER BY total ASC;


use htl_skirace_2;
select * from times;
insert into times (time, participant, name) values (45.21, 42, "ZZ3");
delete from times where id = 12;


SELECT * from category;

use htl_factory;

select * from category;
insert into category (name) values ("3D Print");
insert into category (id, name) values (1, "PCB");
insert into category (id, name) values (2, "Lasercut");


show databases;
use htl_raucherumfrage;

show tables;
desc category;

select * from category;


show tables;
select * from participant;
INSERT INTO participant (age, gender, category) VALUES (9, "F", 4);
insert into category (id, name, shortname) values (1, "Ich rauche nicht", "Nichtraucher");
insert into category (id, name, shortname) values (2, "Ich rauche nur gelegentlich", "gelegentlich");
insert into category (id, name, shortname) values (3, "Ich rauche taeglich bis zu 10 Zigaretten", "bis zu 10 Z. / Tag");
insert into category (id, name, shortname) values (4, "Ich rauche taeglich ueber 10 Zigaretten", "ueber 10 Z. / Tag");

select * from participant;
SELECT count(*) FROM participant WHERE category = 4 AND age < 10 AND age > 0 AND gender = 'F';

