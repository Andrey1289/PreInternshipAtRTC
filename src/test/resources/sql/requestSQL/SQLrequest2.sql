2Вывести количество лет самомому молодому студенту
SELECT
  FLOOR(DATEDIFF(CURDATE(), birthday) / 365) AS age
FROM student
ORDER BY birthday DESC
LIMIT 1;

    age
1	16