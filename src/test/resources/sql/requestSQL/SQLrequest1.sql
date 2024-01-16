1Выведите полные имена (ФИО) всех студентов и преподавателей
SELECT
     'Teacher' AS role,
    CONCAT(first_name, ' ', middle_name, ' ', last_name) AS full_name
FROM
    Teacher

UNION
SELECT
    'Student' AS role,
    CONCAT(first_name, ' ', middle_name, ' ', last_name) AS full_name
FROM
    Student;
    role	full_name
    1	Teacher	Pavel Petrovich Romashkin
    2	Teacher	Vasilij Antonovich Kolesnikov
    3	Teacher	Mariya Stepanovna Vaulina
    4	Teacher	Taisiya Timurovna ZHedrinskaya
    5	Teacher	Marina Gennadevna Sosnovskaya
    6	Teacher	Ekaterina YAkovlevna Myasoedova
    7	Teacher	Liliya Timurovna Arakcheeva
    8	Teacher	Sofya Dmitrievna Krauze
    9	Teacher	Viktoriya Nikolaevna Ostrozhskaya
    10	Teacher	<NULL>
    11	Teacher	Bogdan Romanovich Moiseev
    12	Teacher	Aleksandr Vladimirovich Sobolev
    13	Teacher	Vasil'ev Vasilij Vasil'evich
    14	Teacher	Petr Alekseevich Romashkin
    15	Student	Nikolaj Fedorovich Sokolov
    16	Student	Vyacheslav Evgenevich Eliseev
    17	Student	Ivan Antonovich Efremov
    18	Student	Anatolij Valentinovich ZHdanov
    19	Student	Georgij Dmitrievich Noskov
    20	Student	Artyom Borisovich Sergeev
    21	Student	Arina Fyodorovna Evseeva
    22	Student	Angelina Aleksandrovna Voroncova
    23	Student	Ekaterina Alekseevna Ustinova
    24	Student	Raisa Semyonovna Lapina
    25	Student	Leonid Nikitich Ignatov
    26	Student	Snezhana YAkovlevna Seliverstova
    27	Student	Semyon Vladislavovich Biryukov
    28	Student	Georgij Vyacheslavovich Baranov
    29	Student	YUliya Rostislavovna Vishnyakova
    30	Student	Valentina Andreevna Bolshakova
    31	Student	Leonid Romanovich Kryukov
    32	Student	Vladislav Sergeevich Cvetkov
    33	Student	Snezhana Ivanovna Morozova
    34	Student	Lyubov Maksimovna Borisova
    35	Student	Anfisa Antonovna Kalashnikova
    36	Student	Anna Olegovna Osipova
    37	Student	Kristina Fyodorovna Myasnikova
    38	Student	Kristina Glebovna Smirnova
    39	Student	Boris Innokentevich Simonov
    40	Student	Dmitrij Leonidovich Trofimov
    41	Student	YAkov Leonidovich Rozhkov
    42	Student	Fyodor Rostislavovich Drozdov
    43	Student	Gleb Antonovich Strelkov
    44	Student	Angelina Aleksandrovna Lukina
    45	Student	Nina Ilinichna Odincova
    46	Student	Valeriya Olegovna Novikova
    47	Student	Grigorij Gennadevich Kapustin
    48	Student	Vitalij Eduardovich Panfilov
    49	Student	Svyatoslav Vyacheslavovich Tarasov
    50	Student	Matvej Vyacheslavovich YAkushev
    51	Student	Ilya Stepanovich Alekseev
    52	Student	Lyubov Vyacheslavovna Zaharova
    53	Student	Polina Kirillovna Sidorova
    54	Student	Elizaveta Fyodorovna Samojlova
    55	Student	YUliya Daniilovna Avdeeva
    56	Student	Matvej Gennadevich Bogdanov
    57	Student	Ilya Egorovich Filippov
    58	Student	Denis Nikitich Mel
    59	Student	Svyatoslav Valentinovich Muravyov
    60	Student	Anna Denisovna Kulagina
    61	Student	ZHanna Ilinichna Fokina
    62	Student	Valeriya YUrevna Lapina
    63	Student	Valentina Andreevna Sazonova
    64	Student	Nataliya Igorevna Myasnikova
    65	Student	Viktoriya YAroslavovna Makarova
    66	Student	<NULL>
    67	Student	Gennadij Denisovich Ovchinnikov
    68	Student	Roman Nikolaevich SHilov
    69	Student	Timur Ilich Subbotin
    70	Student	Danila Ivanovich Osipov
    71	Student	Arina Timofeevna Silina
    72	Student	Nadezhda Ilinichna Zaharova
    73	Student	Larisa Stanislavovna SHCHerbakova
    74	Student	Aleksandra Andreevna Belozyorova
    75	Student	Natalya Nikolaevna Davydova
    76	Student	Mariya Valerievna Fadeeva
    77	Student	YUrij Denisovich Markov
    78	Student	Grigorij Kirillovich Kolobov
    79	Student	Semyon Semyonovich Trofimov
    80	Student	Vasilij Gennadevich Ustinov
    81	Student	Valentina YAkovlevna SHarova
    82	Student	Larisa Timurovna Savina
    83	Student	Galina YAroslavovna Orekhova
    84	Student	Arina Ivanovna SHarapova
    85	Student	Viktoriya YUrevna Sergeeva
    86	Student	Vasilij Glebovich Krasilnikov
    87	Student	Timur Filippovich Rusakov
    88	Student	Gleb Timofeevich Nesterov
    89	Student	Denis Matveevich Makarov
    90	Student	Elizaveta Borisovna SHilova
    91	Student	Vera Lvovna Evseeva
    92	Student	Margarita Vladislavovna Kabanova
    93	Student	Angelina Danilovna Lazareva
    94	Student	Semyon Anatolevich Voronov
    95	Student	Innokentij Vyacheslavovich Nekrasov
    96	Student	Artyom Viktorovich Nikitin
    97	Student	Egor Petrovich Belyakov
--------------------------------------------------------------------------------------------------
1Выведите полные имена (ФИО) всех студентов и преподавателей (Без NULL значений)
SELECT
     'Teacher' AS role,
    CONCAT(first_name, ' ', middle_name, ' ', last_name) AS full_name
FROM
    Teacher
WHERE
    first_name IS NOT NULL AND
    middle_name IS NOT NULL AND
    last_name IS NOT NULL
UNION
SELECT
    'Student' AS role,
    CONCAT(first_name, ' ', middle_name, ' ', last_name) AS full_name
FROM
    Student
WHERE
    first_name IS NOT NULL AND
    middle_name IS NOT NULL AND
    last_name IS NOT NULL;
	role	full_name
1	Teacher	Pavel Petrovich Romashkin
2	Teacher	Vasilij Antonovich Kolesnikov
3	Teacher	Mariya Stepanovna Vaulina
4	Teacher	Taisiya Timurovna ZHedrinskaya
5	Teacher	Marina Gennadevna Sosnovskaya
6	Teacher	Ekaterina YAkovlevna Myasoedova
7	Teacher	Liliya Timurovna Arakcheeva
8	Teacher	Sofya Dmitrievna Krauze
9	Teacher	Viktoriya Nikolaevna Ostrozhskaya
10	Teacher	Bogdan Romanovich Moiseev
11	Teacher	Aleksandr Vladimirovich Sobolev
12	Teacher	Vasil'ev Vasilij Vasil'evich
13	Teacher	Petr Alekseevich Romashkin
14	Student	Nikolaj Fedorovich Sokolov
15	Student	Vyacheslav Evgenevich Eliseev
16	Student	Ivan Antonovich Efremov
17	Student	Anatolij Valentinovich ZHdanov
18	Student	Georgij Dmitrievich Noskov
19	Student	Artyom Borisovich Sergeev
20	Student	Arina Fyodorovna Evseeva
21	Student	Angelina Aleksandrovna Voroncova
22	Student	Ekaterina Alekseevna Ustinova
23	Student	Raisa Semyonovna Lapina
24	Student	Leonid Nikitich Ignatov
25	Student	Snezhana YAkovlevna Seliverstova
26	Student	Semyon Vladislavovich Biryukov
27	Student	Georgij Vyacheslavovich Baranov
28	Student	YUliya Rostislavovna Vishnyakova
29	Student	Valentina Andreevna Bolshakova
30	Student	Leonid Romanovich Kryukov
31	Student	Vladislav Sergeevich Cvetkov
32	Student	Snezhana Ivanovna Morozova
33	Student	Lyubov Maksimovna Borisova
34	Student	Anfisa Antonovna Kalashnikova
35	Student	Anna Olegovna Osipova
36	Student	Kristina Fyodorovna Myasnikova
37	Student	Kristina Glebovna Smirnova
38	Student	Boris Innokentevich Simonov
39	Student	Dmitrij Leonidovich Trofimov
40	Student	YAkov Leonidovich Rozhkov
41	Student	Fyodor Rostislavovich Drozdov
42	Student	Gleb Antonovich Strelkov
43	Student	Angelina Aleksandrovna Lukina
44	Student	Nina Ilinichna Odincova
45	Student	Valeriya Olegovna Novikova
46	Student	Grigorij Gennadevich Kapustin
47	Student	Vitalij Eduardovich Panfilov
48	Student	Svyatoslav Vyacheslavovich Tarasov
49	Student	Matvej Vyacheslavovich YAkushev
50	Student	Ilya Stepanovich Alekseev
51	Student	Lyubov Vyacheslavovna Zaharova
52	Student	Polina Kirillovna Sidorova
53	Student	Elizaveta Fyodorovna Samojlova
54	Student	YUliya Daniilovna Avdeeva
55	Student	Matvej Gennadevich Bogdanov
56	Student	Ilya Egorovich Filippov
57	Student	Denis Nikitich Mel
58	Student	Svyatoslav Valentinovich Muravyov
59	Student	Anna Denisovna Kulagina
60	Student	ZHanna Ilinichna Fokina
61	Student	Valeriya YUrevna Lapina
62	Student	Valentina Andreevna Sazonova
63	Student	Nataliya Igorevna Myasnikova
64	Student	Viktoriya YAroslavovna Makarova
65	Student	Gennadij Denisovich Ovchinnikov
66	Student	Roman Nikolaevich SHilov
67	Student	Timur Ilich Subbotin
68	Student	Danila Ivanovich Osipov
69	Student	Arina Timofeevna Silina
70	Student	Nadezhda Ilinichna Zaharova
71	Student	Larisa Stanislavovna SHCHerbakova
72	Student	Aleksandra Andreevna Belozyorova
73	Student	Natalya Nikolaevna Davydova
74	Student	Mariya Valerievna Fadeeva
75	Student	YUrij Denisovich Markov
76	Student	Grigorij Kirillovich Kolobov
77	Student	Semyon Semyonovich Trofimov
78	Student	Vasilij Gennadevich Ustinov
79	Student	Valentina YAkovlevna SHarova
80	Student	Larisa Timurovna Savina
81	Student	Galina YAroslavovna Orekhova
82	Student	Arina Ivanovna SHarapova
83	Student	Viktoriya YUrevna Sergeeva
84	Student	Vasilij Glebovich Krasilnikov
85	Student	Timur Filippovich Rusakov
86	Student	Gleb Timofeevich Nesterov
87	Student	Denis Matveevich Makarov
88	Student	Elizaveta Borisovna SHilova
89	Student	Vera Lvovna Evseeva
90	Student	Margarita Vladislavovna Kabanova
91	Student	Angelina Danilovna Lazareva
92	Student	Semyon Anatolevich Voronov
93	Student	Innokentij Vyacheslavovich Nekrasov
94	Student	Artyom Viktorovich Nikitin
95	Student	Egor Petrovich Belyakov