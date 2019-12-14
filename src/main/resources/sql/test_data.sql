insert into roles values (1, 'ADMIN');
insert into roles values (2, 'STUDENT');
insert into roles values (3, 'MAGE');

insert into groups values (1, 'M1');

insert into statuses values
(1, 'STUDENT');

--qwerty
insert into users values
(1, 1, 'Пулич', 'Алексей',
'$2a$10$faK26S4OIIQ7isLKDg1Mhe4cNp1t6ctafaALsWOvGkS4W6RIH8a2e', 'alexey_pulich', 1, 1);

--12345
insert into users values
(2, 1, 'Попов', 'Даниил',
'$2a$10$.HlQGRg0R2FNps2clXEoiOcIHOS8/ao9/H/inktXbVj2kkTVoVise', 'daniil_popov', 1, 1);

--asdfg
insert into users values
(3, 1, 'Белов', 'Станислав',
'$2a$10$VORmtNmSyQ1pKB8REXtXseUc2CwXj6bQ0rX3mKVfFVitMWvdSHOtC', 'stanislav_belov', 1, 1);

--admin
insert into users values
(4, 1, 'Архивариус', 'Динтра',
'$2a$10$0nXOgQu3HOLdPzUiswrszODewzwrrw7nv5KpK7qFiqDZw84U4tgZi', 'archieve', NULL, NULL);

insert into users_roles values
(1, 2);
insert into users_roles values
(2, 2);
insert into users_roles values
(3, 2);
insert into users_roles values
(4, 1);

insert into disciplines values (1, 'Зельеварение');
insert into disciplines values (2, 'Черная магия');
insert into disciplines values (3, 'Алхимия');
insert into disciplines values (4, 'Анимагия');
insert into disciplines values (5, 'Некромантия');
insert into disciplines values (6, 'Заклинания');
insert into disciplines values (7, 'Защита от темных искусств');
insert into disciplines values (8, 'Колдовство');
insert into disciplines values (9, 'Ритуальная магия');
insert into disciplines values (10, 'Прорицание');

insert into faculties values (1, 'Факультет белой магии');
insert into faculties values (2, 'Факультет темной магии');
insert into faculties values (3, 'Факультет колдовства');
insert into faculties values (4, 'Факультет алхимии');

insert into groups values (1, 'WM1');
insert into groups values (2, 'BM2');
insert into groups values (3, 'K3');
insert into groups values (4, 'A4s');

insert into literatures values (1, 'Книга рун', 'Это такая крутая книга, которая про руны, и вот это вот все. Должен прочитать каждый маг.', false);
insert into literatures values (2, 'Основы волшебства', 'Фундаментальный труд для начинающих магов. Содержит базу и является основой всего и вся. Маги, побывавшие в ИТМО, говорят, что видели подобное на ОВТ', true);
insert into literatures values (3, 'Некромантия для самых маленьких', 'Фундаментальный труд по дисциплине некромантия предназначенный для начинающих магов и их детишек.', false);
insert into literatures values (4, 'Культ черной магии', 'Труд, демонстрирующий черную магию изнутри, все ее изъяны и возможности, а также минусы ее использования.', false);

insert into literature_request(1, 1, 1);
insert into literature_request(2, 2, 1);
insert into literature_request(3, 2, 2);
insert into literature_request(3, 3, 4);

insert into mark values(1, 1, 1, 90);
insert into mark values(2, 2, 1, 85);
insert into mark values(3, 3, 1, 5);
insert into mark values(4, 4, 1, 24);
insert into mark values(5, 5, 1, 67);
insert into mark values(6, 6, 1, 29);

insert into mark values(7, 5, 2, 30);
insert into mark values(8, 6, 2, 55);
insert into mark values(9, 7, 2, 32);
insert into mark values(10, 8, 2, 44);
insert into mark values(11, 9, 2, 37);
insert into mark values(12, 10, 2, 49);

insert into mark values(13, 1, 3, 50);
insert into mark values(14, 3, 3, 65);
insert into mark values(15, 5, 3, 7);
insert into mark values(16, 7, 3, 84);
insert into mark values(17, 9, 3, 97);
insert into mark values(18, 10, 3, 19);

insert into ring(1, 1);
insert into ring(2, 2);
insert into ring(3, 3);

insert into statuses values(1, 'Учащийся');
insert into statuses values(2, 'Трудоустроен');
insert into statuses values(3, 'Отчислен');
insert into statuses values(4, 'Отпуск');
insert into statuses values(5, 'Уволен');