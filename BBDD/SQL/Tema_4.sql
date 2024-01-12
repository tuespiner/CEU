ALTER SESSION SET nls_date_format='DD-MM-YYYY HH24:MI:SS';
DROP TABLE FUTBOLISTAS CASCADE CONSTRAINTS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;
DROP TABLE PARTIDOS CASCADE CONSTRAINTS;

CREATE TABLE FUTBOLISTAS(
ID CHAR(6) PRIMARY KEY CHECK( REGEXP_LIKE( ID, 'F[0-9][0-9][0-9]20' )),
NOMBRE VARCHAR(100),
APELLIDOS VARCHAR(300),
FECHA_NACIMIENTO DATE,
POSICION VARCHAR(50) CHECK( POSICION LIKE 'PORTERO' OR POSICION LIKE 'DEFENSA' OR POSICION LIKE 'MEDIOCENTRO' OR POSICION LIKE 'DELANTERO' ),
SALARIO NUMBER(12,2) CHECK( SALARIO > 50000),
ID_EQUIPO INT
);

CREATE TABLE EQUIPOS(
ID INT PRIMARY KEY,
NOMBRE VARCHAR(100),
ESTADIO VARCHAR(100),
PRESUPUESTO NUMBER(20,2)
);

CREATE TABLE PARTIDOS(
ID INT PRIMARY KEY,
ARBITRO VARCHAR(200),
RESULTADO VARCHAR(5) CHECK( REGEXP_LIKE( RESULTADO, '[0-9][0-9]-[0-9][0-9]' )),
ESTADIO VARCHAR(100),
FECHA DATE,
ID_EQUIPO_CASA INT,
ID_EQUIPO_FUERA INT
);

ALTER TABLE FUTBOLISTAS
ADD CHECK (FECHA_NACIMIENTO > '31/DEC/1974');
ALTER TABLE FUTBOLISTAS
ADD FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS(ID);

ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_CASA) REFERENCES EQUIPOS(ID);
ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_FUERA) REFERENCES EQUIPOS(ID);

DELETE FROM EQUIPOS;
INSERT INTO EQUIPOS VALUES (1,'EQUIPO A', 'ESTADIO A',1000000);
INSERT INTO EQUIPOS VALUES (2,'EQUIPO B', 'ESTADIO B',2000000);
INSERT INTO EQUIPOS VALUES (3,'EQUIPO C', 'ESTADIO C',3000000);

DELETE FROM FUTBOLISTAS;
INSERT INTO FUTBOLISTAS VALUES ('F00120','PEDRO','GOMEZ','22/01/1980','PORTERO',100000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00220','PEDRO LUIS','GOMEZ','20/04/1985','DEFENSA',110000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00320','LUIS','GALVEZ','12/01/1990','DELANTERO',80000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00420','ANTONIO','DOMINGUEZ','25/06/1981','PORTERO',340000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00520','JESUS','FERNANDEZ','02/01/1995','MEDIOCENTRO',140000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00620','DIEGO','DIAZ','05/04/1987','PORTERO',160000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00720','PABLO','CARO','27/01/1988','DEFENSA',200000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00820','ESTEBAN','BENITEZ','29/09/2000','DEFENSA',300000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00920','ENRIQUE','ALVAREZ','30/09/2001','MEDIOCENTRO',120000,3);

DELETE FROM PARTIDOS;
INSERT INTO PARTIDOS VALUES (1,'ARBITRO A','00-00','ESTADIO A','01/01/2020',1,2);
INSERT INTO PARTIDOS VALUES (2,'ARBITRO B','01-00','ESTADIO A','08/01/2020',1,3);
INSERT INTO PARTIDOS VALUES (3,'ARBITRO C','01-01','ESTADIO B','15/01/2020',2,3);
INSERT INTO PARTIDOS VALUES (4,'ARBITRO B','02-00','ESTADIO B','22/01/2020',2,1);
INSERT INTO PARTIDOS VALUES (5,'ARBITRO A','04-01','ESTADIO C','29/01/2020',3,1);
INSERT INTO PARTIDOS VALUES (6,'ARBITRO A','03-03','ESTADIO C','05/02/2020',3,2);

UPDATE FUTBOLISTAS SET ID_EQUIPO = 2 WHERE ID LIKE 'F00120';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 3 WHERE ID LIKE 'F00420';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 1 WHERE ID LIKE 'F00920';

DELETE FROM FUTBOLISTAS WHERE ID LIKE 'F00120' OR ID LIKE 'F00420';

-- Ej 1
-- Obt�n el nombre de todos los futbolistas de la base de datos.
SELECT nombre FROM futbolistas;
-- Ahora queremos saber la posicion que ocupan estos futbolistas (aunque se repitan valores).
SELECT posicion FROM futbolistas;
-- Se quiere saber las posiciones existentes por lo que se requieren la posicion de los futbolistas sin que se repitan.
SELECT DISTINCT posicion FROM futbolistas;

--Ej 2
-- Obt�n todas las posiciones posibles (diferentes) de los futbolistas bajo encabezado "Demarcaciones".
SELECT DISTINCT posicion "Demarcaciones" FROM futbolistas;
--Muestra todos los datos almacenados de todos los futbolistas
SELECT * FROM futbolistas;
/* Se quieren todos los datos de los futbolistas pero con los siguientes alias de columna:
- id
- nombre
- apellidos
- fecha de nacimiento
- posici�n
- salario actual
- identificador equipo actual
*/
select
    ID "id",
    nombre "nombre",
    apellidos "apellidos",
    fecha_nacimiento "fecha de nacimiento",
    posicion  "posici�n",
    salario "salario actual",
    id_equipo "identificador equipo actual"
from futbolistas;
select * from equipos;
select * from futbolistas;
select * from equipos, futbolistas where id_equipo = equipo.id;
--EXPLICACI�N
select id from equipos ;
select equipos.id from equipos;
select id from equipos e;
select e.id from equipos; --IMPORTANTE
select e.id from equipos e;

select f.apellidos from futbolistas F where posicion = 'DEFENSA';

select f.apellidos from futbolistas F order by APELLIDOS;
--Muestra los nombres, apellidos y salarios de lso futbolistas en orden de nombres descendiente (orden alfabetico)
select nombre, apellidos, salario from futbolistas  order by nombre desc;
update futbolistas set apellidos='GALVEZ' where nombre='PABLO';
--Muestra los salarios nombre y apellidos de los de futbolistas por los apellidos de forma descendiente y si es igual el apellido por el salario mas alto.
select nombre, apellidos, salario from futbolistas order by apellidos desc, salario desc;
--lo mismo que arriba pero en vez de poner apellidos y salario ponemos el numero de columna.
select nombre, apellidos, salario from futbolistas order by 2 desc, 3 desc;
select posicion from futbolistas;
select apellidos from futbolistas where posicion='DEFENSA' order by apellidos desc ;
select * from futbolistas order by posicion , apellidos;

select (4+4)*3 || 'a' from dual;

select sysdate from dual;

/*select to_char(sysdate, 'dd/mm/yy hh:mi:ss') from dual;
posicion = 'DEFENSA'or posicion = 'PORTERO'
posicion in ('DEFENSA','PORTERO')
posicion = 'DEFENSA' and salario > 100000*/
select 'antes: ' || salario || ' � -' "salario bonito" from futbolistas;
select nombre from futbolistas where salario2023 != salario2024;
--En este caso busca los nombres que empiezen por E, se salete una letra, despues tenga una R y despues lo que sea 
select nombre from futbolistas where nombre like 'E_R%';
select nombre from futbolistas where salario > 150000;
select ID from futbolistas where apellidos like 'GOMEZ';
select apellidos from futbolistas where apellidos like 'G%';
select * from futbolistas where posicion = 'DEFENSA' or posicion = 'DELANTERO';
select nombre from futbolistas where salario between 100000 and 200000;
se