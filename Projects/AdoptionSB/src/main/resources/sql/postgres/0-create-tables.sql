drop table if exists pet;
drop table if exists adopter;
create table adopter
(
    idadopter   serial
        primary key,
    name        varchar(50) not null,
    phonenumber varchar(10) not null,
    date        date
);

alter table adopter
    owner to larku;

create table pet
(
    idpet     serial
        primary key,
    name      varchar(50) not null,
    type      varchar(20) not null,
    breedtype varchar(50) not null,
    idadopter integer
        constraint pet_adopter_idadopter_fk
            references adopter
);

alter table pet
    owner to larku;

grant all privileges on all tables in schema public to larku;

