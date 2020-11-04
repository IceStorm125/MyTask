
create table type_of_complex (
    id bigint auto_increment,
    type_name varchar(40),
    constraint type_of_complex_pk primary key (id)
);

insert into type_of_complex(type_name) values('Gym');
insert into type_of_complex(type_name) values('Football field');
insert into type_of_complex(type_name) values('Table tennis');


create table client(
     id bigint auto_increment,
     first_name varchar(30) not null ,
     last_name varchar(30) not null ,
     tel_no varchar(15) not null unique,
     home_address varchar(200) not null ,
     constraint client_pk primary key (id)
);

insert into client(first_name,last_name,tel_no,home_address) values('Andrey','Kovalev','+375(29)6225418','Minsk,Surganova 23,4');
insert into client(first_name,last_name,tel_no,home_address) values('Ivan','Ivanov','+375(29)4253235','Minsk,Horuzhey 12,53');


create table sport_complex(
    id bigint auto_increment,
    name varchar (40) not null,
    address varchar(200) not null,
    type_of_complex_id bigint not null,
    constraint sport_complex_pk primary key (id),
    constraint type_of_complex_id_fk foreign key (type_of_complex_id) references type_of_complex(id) on delete cascade
);

insert into sport_complex(name,address, type_of_complex_id) values('Power','Minsk,Bogdanovicha 27',2);
insert into sport_complex(name,address, type_of_complex_id) values('Skill','Minsk,Ostroshizkaja 12',1);
insert into sport_complex(name,address, type_of_complex_id) values('Fire ball','Gomel,Ignatova 3',3);


create table visits(
    id bigint auto_increment,
    client_id bigint,
    sport_complex_id bigint,
    visit_date timestamp ,
    constraint visits_pk primary key (id),
    constraint client_id_visits_fk foreign key (client_id) references client (id) on delete cascade ,
    constraint sport_complex_id foreign key (sport_complex_id) references sport_complex(id) on delete cascade
);

insert into visits(client_id, sport_complex_id,visit_date) values (1,1,'2020-10-01 18:00:00');
insert into visits(client_id, sport_complex_id,visit_date) values (2,1,'2020-11-01 19:30:00');
insert into visits(client_id, sport_complex_id,visit_date) values (1,2,'2020-08-01 20:30:00');


create table discount(
    client_id bigint,
    discount_factor double ,
    constraint client_id_discount_pk primary key (client_id),
    constraint client_id_discount_fk foreign key (client_id) references client(id) on delete cascade
);