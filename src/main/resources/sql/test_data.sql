DELETE ALL
ALTER TABLE users DISABLE TRIGGER ALL;
ALTER TABLE disciplines DISABLE TRIGGER ALL;
ALTER TABLE faculties DISABLE TRIGGER ALL;
ALTER TABLE groups DISABLE TRIGGER ALL;
ALTER TABLE literature DISABLE TRIGGER ALL;
ALTER TABLE literature_request DISABLE TRIGGER ALL;
ALTER TABLE marks DISABLE TRIGGER ALL;
ALTER TABLE rings DISABLE TRIGGER ALL;
ALTER TABLE roles DISABLE TRIGGER ALL;
ALTER TABLE statuses DISABLE TRIGGER ALL;
ALTER TABLE users_roles DISABLE TRIGGER ALL;

DELETE FROM users;
DELETE FROM disciplines;
DELETE FROM faculties;
DELETE FROM groups;
DELETE FROM literature;
DELETE FROM literature_request;
DELETE FROM marks;
DELETE FROM rings;
DELETE FROM roles;
DELETE FROM statuses;
DELETE FROM users_roles;

ALTER TABLE users ENABLE TRIGGER ALL;
ALTER TABLE disciplines ENABLE TRIGGER ALL;
ALTER TABLE faculties ENABLE TRIGGER ALL;
ALTER TABLE groups ENABLE TRIGGER ALL;
ALTER TABLE literature ENABLE TRIGGER ALL;
ALTER TABLE literature_request ENABLE TRIGGER ALL;
ALTER TABLE marks ENABLE TRIGGER ALL;
ALTER TABLE rings ENABLE TRIGGER ALL;
ALTER TABLE roles ENABLE TRIGGER ALL;
ALTER TABLE statuses ENABLE TRIGGER ALL;
ALTER TABLE users_roles ENABLE TRIGGER ALL;

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

insert into literature values (1, true, 'Книга рун', 'Это такая крутая книга, которая про руны, и вот это вот все. Должен прочитать каждый маг.');
insert into literature values (2, false, 'Основы волшебства', 'Фундаментальный труд для начинающих магов. Содержит базу и является основой всего и вся. Маги, побывавшие в ИТМО, говорят, что видели подобное на ОВТ');
insert into literature values (3, false, 'Некромантия для самых маленьких', 'Фундаментальный труд по дисциплине некромантия предназначенный для начинающих магов и их детишек.');
insert into literature values (4, false, 'Культ черной магии', 'Труд, демонстрирующий черную магию изнутри, все ее изъяны и возможности, а также минусы ее использования.');

INSERT INTO literature_request VALUES (1, 1, 1);
INSERT INTO literature_request VALUES (2, 1, 1);
INSERT INTO literature_request VALUES (3, 2, 2);
INSERT INTO literature_request VALUES (4, 4, 3);

insert into marks values(1, 90, 1, 1);
insert into marks values(2, 85, 2, 1);
insert into marks values(3, 5, 3, 1);
insert into marks values(4, 24, 4, 1);
insert into marks values(5, 67, 5, 1);
insert into marks values(6, 29, 6, 1);

insert into marks values(7, 30, 5, 2);
insert into marks values(8, 55, 6, 2);
insert into marks values(9, 32, 7, 2);
insert into marks values(10, 44, 8, 2);
insert into marks values(11, 37, 9, 2);
insert into marks values(12, 49, 10, 2);

insert into marks values(13, 50, 1, 3);
insert into marks values(14, 65, 3, 3);
insert into marks values(15, 7, 5, 3);
insert into marks values(16, 84, 7, 3);
insert into marks values(17, 97, 9, 3);
insert into marks values(18, 19, 10, 3);

insert into rings values (1, 1);
insert into rings values (2, 2);
insert into rings values (3, 3);

insert into statuses values(1, 'Учащийся');
insert into statuses values(2, 'Трудоустроен');
insert into statuses values(3, 'Отчислен');
insert into statuses values(4, 'Отпуск');
insert into statuses values(5, 'Уволен');