--crear tabla plantas
drop table plantas cascade constraints;
create table plantas(
    referencia char(9) primary key check (regexp_like(referencia, 'R[0-9][0-9][0-9]-2023')),
    nombre varchar2(30) not null,
    familia varchar2(30),
    flor varchar2(30) check(regexp_like(flor,'Si')or regexp_like(flor,'No')),
    proveedor varchar2(30) not null,
    precio int,
    stock int
);
--check plantas
alter table plantas add check(precio>0);
alter table plantas add check(stock>0);

--crear tabla socios
drop table socios cascade constraints;
create table socios(
    numero char(8) primary key check(regexp_like(numero, 'SOC[0-9][0-9][0-9][0-9][0-9]')),
    nombre varchar2(30),
    apellidos varchar2(30),
    direccion varchar2(30),
    codigo_postal int,
    localidad varchar2(30),
    provincia varchar2(30),
    telefono number(9),
    email varchar2(70)
);

--crear tabla compras
drop table compras cascade constraints;
create table compras(
    referencia int primary key,
    identificador_cliente char(8),
    identificador_planta char(9),
    fecha_compra date,
    forma_pago varchar2(30),
    socio varchar2(30) 
);

--alter de compras
alter table compras add foreign key(identificador_cliente) references socios(numero);
alter table compras add foreign key(identificador_planta) references plantas(referencia);

--insert de plantas
insert into plantas values ('R001-2023', 'planta1', 'familia1', 'Si', 'proveedor1', 10, 100); 
insert into plantas values ('R002-2023', 'planta2', 'familia1', 'Si', 'proveedor2', 10, 100);
insert into plantas values ('R003-2023', 'planta3', 'familia2', 'No', 'proveedor3', 10, 100); 

--insert de socios
insert into socios (numero) values ('SOC00001');
insert into socios (numero) values ('SOC00002');

--insert de compras
insert into compras values (1, 'SOC00001', 'R001-2023', '17-8-2023', 'efectivo', 'socio');
insert into compras values (2, 'SOC00002', 'R003-2023', '05-10-2023', 'efectivo', 'socio');
insert into compras values (3, 'SOC00002', 'R003-2023', '11-12-2023', 'efectivo', 'socio');
insert into compras values (4, null,'R002-2023', '14-08-2023', 'efectivo', 'nosocio');

--updates
update plantas set flor='Si' where plantas.referencia='R003-2023';
update socios set email='micorreo@gmail.com' where socios.numero='SOC00001';

delete from compras where socio='nosocio';













