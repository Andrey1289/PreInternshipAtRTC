7Вывести всех преподавателей преподающих Биологию

SELECT DISTINCT  CONCAT(last_name,' ',first_name,' ',middle_name) as fio
FROM Subject
JOIN Schedule ON subject.id = Schedule.subject
JOIN Teacher ON Schedule.teacher = teacher.id
WHERE name  LIKE 'Biology';

    fio
1	Myasoedova Ekaterina YAkovlevna