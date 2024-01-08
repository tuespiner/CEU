--crear tabla barcos
drop table barcos cascade constraints;
create table barcos(
    matricula char(7) primary key,
    nombre varchar2(50),
    clase varchar2(50),
    armador varchar2 (50),
    capacidad varchar2(50),
    nacionalidad varchar2 (50)
);
-- crear tabla lotes
drop table lotes cascade constraints;
create table lotes(
    codigo int primary key,
    matricula char(7),
    num_kg int,
    precio_kg_salida number (4,2),
    precio_kg_vendido number(4,2),
    fecha_venta date not null,
    cod_especie int 
);
--añadir foreign key
alter table lotes add foreign key (matricula) references barcos (matricula);

--crear tabla especie
drop table especies cascade constraints;
create table especies(
    codigo int primary key,
    nombre varchar2(50),
    tipo varchar2(50),
    cupo_barco int,
    caladero_ppal int 
);
--añadir foreign key
alter table lotes add foreign key (cod_especie) references especies (codigo);

--crear tabla caladeros   
drop table caladeros cascade constraints;
create table caladeros(
    codigo int primary key,
    nombre varchar2(50),
    ubicacion varchar2(50),
    especie_ppal int,
    cientifico varchar2(50)
);
--añadir foreign key
alter table especies  add foreign key (caladero_ppal) references caladeros (codigo);

--crear tabla fechas_capturas 
drop table fechas_capturas cascade constraints;
create table fechas_capturas(
    cod_especie int,
    cod_caladero int,
    fecha_inicio date,
    fecha_fin date,
    primary key (cod_especie, cod_caladero)
);

--alter table fechas_capturas
alter table fechas_capturas add foreign key (cod_especie) references especies (codigo);
alter table fechas_capturas add foreign key (cod_caladero) references caladeros (codigo);
alter table fechas_capturas add check(fecha_inicio NOT BETWEEN date '2023-02-02' and date '2023-02-28');

--alter table barcos
alter table barcos add check (regexp_like(matricula,'[A-Z][A-Z]-[1-9][1-9]'));

--alter table lotes
alter table lotes add check (precio_kg_vendido>precio_kg_salida);
alter table lotes add check (num_kg>0);
alter table lotes add check (precio_kg_salida>0);
alter table lotes add check ( precio_kg_vendido>0);

--alter table caladeros
alter table caladeros add check (nombre = upper(nombre));
alter table caladeros add check (ubicacion = upper(ubicacion));

--inserts
insert into barcos (matricula, nombre) values ('AR-0001','juan');
insert into lotes (codigo, fecha_venta) values (1,'10-12-2023');
insert into especies (codigo, nombre) values (1,'especie1');
insert into caladeros (codigo, nombre) values (1,'caladero1');
insert into fechas_capturas (cod_especie, cod_caladero) values (1,1);



    

    
    
    