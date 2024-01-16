6Вывести расписание на заданную дату

SELECT *
FROM Schedule
WHERE date = '2019-09-01';

id	date	class	number_pair	teacher	subject	classroom
1	1	2019-09-01T00:00:00.000Z	9	1	11	1	47
2	2	2019-09-01T00:00:00.000Z	9	2	8	2	13
3	3	2019-09-01T00:00:00.000Z	9	3	4	3	13
4	26	2019-09-01T00:00:00.000Z	8	2	2	4	34
5	27	2019-09-01T00:00:00.000Z	8	3	6	5	35
6	28	2019-09-01T00:00:00.000Z	8	4	12	6	36
7	29	2019-09-01T00:00:00.000Z	8	5	13	7	37

более ссложный запрос но более информативнее
SELECT
    s.date,
    tp.start_pair,
    tp.end_pair,
    subj.name AS subject_name,
    CONCAT(t.first_name, ' ', t.middle_name, ' ', t.last_name) AS teacher_full_name,
    cl.name AS class_name,
    s.classroom
FROM Schedule s
INNER JOIN Timepair tp ON s.number_pair = tp.id
INNER JOIN Subject subj ON s.subject = subj.id
INNER JOIN Teacher t ON s.teacher = t.id
INNER JOIN Class cl ON s.class = cl.id
WHERE s.date = '2019-09-01';

	 date	   start_pair	end_pair	subject_name	  teacher_full_name	           class_name classroom
1	2019-09-01	08:30:00	09:15:00	Math	 <NULL>                     	          11 A	   47
2	2019-09-01	09:20:00	10:05:00	Russian language  Sofya Dmitrievna Krauze	      11 A	   13
3	2019-09-01	10:15:00	11:00:00	Literature	      Taisiya Timurovna ZHedrinskaya  11 A	   13
4	2019-09-01	09:20:00	10:05:00	Physics	Vasilij   Antonovich Kolesnikov	          11 B	   34
5	2019-09-01	10:15:00	11:00:00	Chemistry	      Ekaterina YAkovlevna Myasoedova 11 B	   35
6	2019-09-01	11:05:00	11:50:00	Geography	      Bogdan Romanovich Moiseev	      11 B	   36
7	2019-09-01	12:50:00	13:35:00	History	          Aleksandr Vladimirovich Sobolev 11 B	   37