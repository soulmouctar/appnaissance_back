drop if exists companies ;
drop if exists cityhall;
drop if exists addresses;
--CREATION DE LA TABLE ADRESSES
create table adresses (
    id int auto_increment primary key,
    street varchar(255) not null,
    city varchar(255) not null,
    country varchar(255) not null,
    zip varchar(20) not null,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now()
);
--CREATION DE LA TABLE COMPANIES
create table companies (
    id int auto_increment primary key,
    name varchar(255) not null,
    address_id int not null,
    --cityhall_id int not null,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now(),
    constraint fk_address foreign key (address_id) references adresses(id)
    --foreign key (cityhall_id) references cityhall(id)
);

-- CREATION DE LA TABLE CITYHALL
create table cityhalls (
    id int auto_increment primary key,
    name varchar(255) not null,
    description text,
    address_id int not null,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now(),
    constraint fk_cityhall _address foreign key (address_id) references adresses(id)
);

--CREATION DE LA TABLE PROFILES
