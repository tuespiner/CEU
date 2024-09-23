drop table barcos cascade constraints;
create table barcos(
    matricula int primary key,
    nombre varchar2(50),
    clase varchar2(50),
    armador varchar2 (50),
    capacidad varchar2(50),
    nacionalidad varchar2 (50)
);

drop table lotes cascade constraints;
create table lotes(
    codigo int primary key,
    matricula int,
    num_kg int,
    precio_kg_salida number (4,2),
    precio_kg_vendido number(4,2),
    fecha_venta date,
    cod_especie int 
);

alter table lotes
    add foreign key (matricula) references barcos (matricula);

drop table especies cascade constraints;
create table especies(
    codigo int primary key,
    nombre varchar2(50),
    tipo varchar2(50),
    cupo_barco int,
    caladero_ppal int 
);

alter table lotes
    add foreign key (cod_especie) references especies (codigo);

drop table caladeros cascade constraints;
create table caladeros(
    codigo int primary key,
    nombre varchar2(50),
    ubicacion varchar2(50),
    especie_ppal int
);

alter table especies 
    add foreign key (caladero_ppal) references caladeros (codigo);

drop table fechas_capturas cascade constraints;
create table fechas_capturas(
    cod_especie int,
    cod_caladero int,
    fecha_inicio date,
    fecha_fin date,
    primary key (cod_especie, cod_caladero)
);

alter table fechas_capturas
    add foreign key (cod_especie) references especies (codigo);
alter table fechas_capturas
    add foreign key (cod_caladero) references caladeros (codigo);

