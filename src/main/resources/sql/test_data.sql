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

