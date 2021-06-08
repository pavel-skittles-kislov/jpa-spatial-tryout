CREATE TABLE shop
(
    id            BIGINT                NOT NULL PRIMARY KEY,
    name          VARCHAR,
    address       VARCHAR,
    lat           FLOAT                 NOT NULL,
    lon           FLOAT                 NOT NULL,
    working_hours VARCHAR,
    position      geometry(POINT, 4326) NOT NULL
);

INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (1, 'Липовый мед Илъича', 'г. Москва, Красная площадь', 55.7538337, 37.6211812,
        'Пн - Пт: 9:00 - 21:00 Сб, Вс - выхоные дни', st_setsrid(st_makepoint(37.6211812, 55.7538337), 4326));
INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (2, 'Холодный холод', 'г. Санкт - Петербург, Дворцовая площадь', 59.938879, 30.315212,
        'Пн - Пт: 9:00 - 21:00 Сб, Вс - выхоные дни', st_setsrid(st_makepoint(30.315212, 59.938879), 4326));
INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (3, 'Байкальский лед', 'Иркутская обл., оз. Байкал', 51.90503, 126.62002,
        'Пн - Пт: 9:00 - 21:00 Сб, Вс - выхоные дни', st_setsrid(st_makepoint(126.62002, 51.90503), 4326));
INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (4, 'Сахалинские дали', 'о. Сахвлин', 46.96411, 142.73476,
        'Пн - Пт: 9:00 - 21:00 Сб, Вс - выхоные дни', st_setsrid(st_makepoint(142.73476, 46.96411), 4326));
INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (5, 'Вкус Гулага', 'р. Колыма', 64.748, 153.80,
        'Без выходных и перерывов', st_setsrid(st_makepoint(153.80, 64.748), 4326));
INSERT INTO shop(id, name, address, lat, lon, working_hours, position)
values (6, 'Мороженное Хинкали', 'г. Тбилиси', 41.6941100, 44.8336800,
        'Заходи когда нада, друк. Пажалуйста, брат.', st_setsrid(st_makepoint(44.8336800, 41.6941100), 4326));