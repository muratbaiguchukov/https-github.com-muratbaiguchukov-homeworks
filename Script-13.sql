create table routes(
id serial primary key,
route_number varchar(10) not null,
starting_point varchar(50),
end_point varchar(50)
);

select * from routes r;

insert into routes(route_number, starting_point, end_point) values
 ('138', 'Кок-Жайык', 'Новостройка ВОССТ'),
 ('227', 'Лущихина', 'Молдокулова'),
 ('103', 'Леваневского', 'с.Орто-Сай');

select * from routes r;

create table buses(
id serial primary key,
bus_number varchar(20) not null,
routes_id integer references routes(id)
); 

insert into buses(bus_number, routes_id) values 
('01.064.DGO', 2),
('01.055.ASD', 3),
('02.897.RTY', 1);

select * from buses b;

create table drivers(
id serial primary key,
fullname varchar(100) not null,
buses_id integer references buses(id) 
);

insert into drivers(fullname, buses_id) values 
('Кожомкулов Адылбек Махмудович', 1),
('Асанбеков Мирлан Ашимович', 3),
('Жакыпбеков Нурсултан Аманович', 2);

select * from drivers d; 

create table timeslots(
id serial primary key,
startdate date,
enddate date
);

insert into timeslots(startdate, enddate) values 
('2022-02-04 06:00', '2022-02-04 14:00'),
('2022-02-04 14:00', '2022-02-04 22:00'),
('2022-03-04 14:00', '2022-03-04 22:00');

select * from timeslots t; 

create table logbook(
id serial primary key,
drivers_id integer references drivers(id),
buses_id integer references buses(id),
timeslots_id integer references timeslots(id),
unique (buses_id, timeslots_id)
);

insert into logbook(drivers_id, buses_id, timeslots_id) values 
(2, 1, 1),
(3, 2, 2),
(1, 3, 3);

select * from logbook l; 