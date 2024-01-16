4Вывести название предметов, которые преподает учитель по фамилии Иванов

SELECT DISTINCT Subject.name
FROM teacher
JOIN Schedule ON  teacher.id = Schedule.teacher
JOIN  Subject ON Schedule.subject = subject.id
WHERE last_name LIKE 'Ivanov';

 запрос ничего не вернул
 ------------------------------------------------------------------
написал запрос на другого учителя
SELECT DISTINCT Subject.name
FROM teacher
JOIN Schedule ON  teacher.id = Schedule.teacher
JOIN  Subject ON Schedule.subject = subject.id
WHERE last_name LIKE 'Vaulina';

    name
1	Physical Culture
2	Technology
