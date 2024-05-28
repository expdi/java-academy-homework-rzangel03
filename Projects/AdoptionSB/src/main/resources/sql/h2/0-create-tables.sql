drop table pet if exists;
drop table adopter if exists;
create table adopter
(
    idadopter   serial
        primary key,
    name        varchar(50) not null,
    phonenumber varchar(10) not null,
    date        date
);


create memory table pet(
    idpet     integer primary key auto_increment not null,
    name      varchar(50) not null,
    type      varchar(20) not null,
    breedtype varchar(50) not null,
    idadopter integer
        constraint pet_adopter_idadopter_fk
            references adopter
);


