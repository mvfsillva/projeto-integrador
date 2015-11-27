create table state ( 
	id_state serial not null primary key,
	description varchar(20) not null
);

create table city (
	id_city serial not null primary key,
	description varchar(40) not null,
	id_state int not null,
	constraint city_state_fk foreign key (id_state) references state (id_state)
);
