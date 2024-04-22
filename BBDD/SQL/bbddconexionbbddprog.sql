CREATE TABLE personas (
 DNI varchar2(50) NOT NULL,
 NOMBRE varchar2(50) NOT NULL,
 APELLIDOS varchar2(100) NOT NULL,
 FECHA_NACIMIENTO DATE DEFAULT NULL,
 PRIMARY KEY (DNI)
);

insert into personas values('1','Juan','López Carmona','04-09-2005');
select * from personas;
