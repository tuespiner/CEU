--Ejercicio 1
drop table alumnos;
create table alumnos (
    nombre varchar2(13),
    apellido varchar2(50),
    dni char(9)
);
--Ejercicio 2
alter table alumnos add codigo_postal number(5);

alter table alumnos add fecha_nacimiento date;

alter table alumnos modify nombre varchar2(15);

alter table alumnos drop COLUMN codigo_postal;

alter table alumnos modify apellido varchar2(200);

alter table alumnos add primary key (dni);

alter table alumnos add constraint pkdni primary key(dni);

drop table alumnos_1;
create table alumnos_1 (
    nombre varchar2(13),
    apellido varchar2(50),
    dni char(9)
);
 alter table ALUMNOS_1 add primary key (dni);

drop table alumnos_2;
create table alumnos_2 (
    nombre varchar2(13),
    apellido varchar2(50),
    dni_2 char(9)
);
alter table ALUMNOS_2 add constraint pkdni_2 primary key (dni_2);

drop table alumnos_3;
create table alumnos_3 (
    nombre varchar2(13),
    apellido varchar2(50),
    dni_3 char(9) primary key
);


drop table alumnos_4;
create table alumnos_4 (
    nombre varchar2(13),
    apellido varchar2(50),
    dni_4 char(9),
    primary key(dni_4),
    id_localidad integer
);

alter table ALUMNOS_4 add dni_alumnos_3 char(9);
alter table ALUMNOS_4 add foreign key (dni_alumnos_3) references ALUMNOS_3(dni_3);

drop table localidades;
create table localidades (
 id_localidades integer,
 localidad varchar2(100)
);
alter table localidades add primary key(id_localidades); 
alter table ALUMNOS_4 add foreign key (id_localidad_1) references LOCALIDADES(id_localidades);

drop table MASCOTAS;

