--tabla socios
drop table socios cascade constraints;
create table socios(
    codigo_de_socio char(8) primary key,
    dni char(9),
    nombre varchar2(100),
    apellidos varchar2(200),
    direccion varchar2(300),
    telefono number(9)
);

--tabla libros
drop table libros cascade constraints;
create table libros(
    isbn char(17) primary key,
    titulo varchar2(200),
    editorial varchar2(50),
    año_publicacion int,
    autores varchar2(300),
    año_edicion int,
    deteriorado char(2)
);

--tabla prestamos
drop table prestamos cascade constraints;
create table prestamos(
    codigo_de_socio char(8),
    isbn char(17),
    fecha_prestamo date,
    fecha_devolucion date,
    fecha_real_devolucion date,
    primary key(codigo_de_socio,isbn)
);

--check socios
alter table socios add check(regexp_like(codigo_de_socio,'s[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'));
alter table socios add check(regexp_like(dni,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'));

--check libros
alter table libros add check(regexp_like(deteriorado,'si')or regexp_like(deteriorado,'no'));
alter table libros add check(regexp_like(isbn,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][a-z][a-z][a-z][a-z]')) ;

--check prestamos
alter table prestamos add check(regexp_like(codigo_de_socio,'s[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'));
alter table prestamos add foreign key(codigo_de_socio) references socios(codigo_de_socio) on delete set NULL;
alter table prestamos add check(regexp_like(isbn,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][a-z][a-z][a-z][a-z]'));
alter table prestamos add foreign key(isbn) references libros(isbn) on delete set NULL;
alter table prestamos add check(fecha_devolucion>(fecha_prestamo+15));
alter table prestamos add check(fecha_real_devolucion>=fecha_prestamo);

--insert socios
insert into socios (codigo_de_socio,dni) values ('s0000001','00000001A');
insert into socios (codigo_de_socio,dni) values ('s0000002','00000002A');

--insert libros
insert into libros (isbn,titulo) values ('000000001aaaa','titulo1');
insert into libros (isbn,titulo) values ('000000002aaaa','titulo2');
insert into libros (isbn,titulo) values ('000000003aaaa','titulo3');

--insert prestamos
insert into prestamos values ('s0000001','000000001aaaa','1-12-2023','17-12-2023','18-12-2023');
insert into prestamos values ('s0000001','000000002aaaa','18-01-2024','03-02-2024','02-02-2024');
insert into prestamos values ('s0000002','000000003aaaa','18-01-2024','03-02-2024','03-02-2024');

--update socios
update socios set nombre='juan', apellidos='lopez' where socios.codigo_de_socio='s0000001';
update socios set nombre='juan', apellidos='lopez' where socios.codigo_de_socio='s0000002';

--update libros
update libros set año_edicion='2018' where libros.isbn='000000001aaaa';
update libros set año_edicion='2018' where libros.isbn='000000002aaaa';
update libros set año_edicion='2018' where libros.isbn='000000003aaaa';
update libros set deteriorado='si' where libros.isbn='000000003aaaa';
