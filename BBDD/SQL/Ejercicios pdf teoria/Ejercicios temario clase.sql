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

/*Ejercicio 1
Enunciado:  1) Obtén el nombre de todos los futbolistas de la base de datos.
            2) Ahora queremos saber la posición que ocupan estos futbolistas (aunque se repitan los valores).
            3) Se quiere saber las posiciones existentes por lo que se requiere la posición de los futbolistas sin que se repitan los valores.*/
            
--1)        
select nombre from futbolistas; 

--2)
select posicion from futbolistas;

--3)
select distinct posicion from futbolistas; --distinct: hace que no salgan valores repetidos


/*Ejercicio 2
Enunciado:  1) Obtén todas las posiciones posibles (diferentes) de los futbolistas bajo el encabezado “Demarcaciones”.
            2) Muestra todos los datos almacenados de todos los futbolistas.*/
            
--1)
select distinct posicion "Demarcaciones"from futbolistas;  --"", as: Las dos opciones sirver para lo mismo, poner un alias
select distinct posicion as Demarcaciones from futbolistas; 

--2)
select * from futbolistas; --*: Sirve para seleccionar todos los datos de la tabla
                           /*(si queremos solo unas cuantas columnas, podemos separarlas con ",", por ejemplo:
                           select nombre, posicion from futbolistas;, esto devuelve los nombres y las posiciones
                           de los futbolistas)*/
                           
/*Ejercicio 3
Enunciado:  1) Devuelve los apellidos de los futbolistas que su posición sea DEFENSA. Aplica un alias a apellidos para que se muestre 
“Futbolista”y asigna el alias F a la tabla futbolistas.*/

--1)
select f.apellidos "Futbolista" from futbolistas f where posicion='DEFENSA';        --Aqui le ponemos un alias a la tabla futbolistas y ponemos 'f.apellidos',
select f.apellidos "Futbolista" from futbolistas f where posicion like 'DEFENSA';   /*esto se usa cuando nos referimos a varias tablas a la vez, eso significa
                                                                                      que buscamos en la tabla f(futbolistas) una columna que se llama apellidos*/

/*Ejercicio 4
Enunciado:  1) Devuelve los apellidos de los futbolistas que su posición sea DEFENSA ordenador de la Z a la A.*/

--1)
select apellidos from futbolistas order by apellidos desc; /*order by: Esta expresion ordena de menor a mayor o de la a a la z con asc y al reves
                                                             con desc, hay que poner entre el order by y el asc/desc la clumna con la que lo queremos ordenar*/


/*Ejercicio 5
Enunciado:  1) Devuelve todos los datos de futbolistas ordenados primero por posición y luego por apellidos.*/

select * from futbolistas order by posicion , apellidos ;/*Para poder ordenar con dos tablas lo dividimos con ',', esto lo que hace es
                                                                 que primero lo ordena por la primera columna quepongamos y si hay repetidos
                                                                 por la segunda (por defecto el order by ordena de menor a mayor o de la a-z)*/

/*Ejercicio 6
Enunciado:  1) Obtén el nombre de los futbolistas que cobran más de 150.000 euros (SALARIO).
            2) Muestra el ID de los futbolistas cuyo apellido sea GÓMEZ.
            3) Indica los apellidos de los futbolistas que empiezan por G.
            4) Devuelve todos los datos de los futbolistas cuya posición sea DEFENSA o DELANTERO.
            5) Obtén el nombre de los futbolistas que cobran entre 100.000 y 200.000 euros (SALARIO).*/
            
            
--1)
select nombre from futbolistas where salario > 150000;  /*<>: Podemos hacer operaciones como en programación de mayor, menor, sumar, restar, etc.*/

--2) 
select id from futbolistas where apellidos like 'GOMEZ';
select id from futbolistas where apellidos = 'GOMEZ';

--3)
select apellidos from futbolistas where apellidos like 'G%';  /*%: Cuando ponemos like es como si fuera el restro de la cadena, por ejemplo 
                                                                tenemos un apellido que sea Sanchez y eponemos 'S%' si nos saldria, ahora si
                                                                ponemos Sanl%, no, ahi nos saldria sanlucar por ejemplo
                                                                _: Cuando ponemos like es como si fuera cualquier cosa, por ejemplo queremos
                                                                saber el apellido por la segunda letra, pondriamos '_a%'*/

--4)
select * from futbolistas where posicion like 'DEFENSA' or posicion like 'DELANTERO';  /*and, or: Es para poner una condición,por ejemplo un rango de edad*/


        
--5)
select  nombre from futbolistas where salario > 100000 and salario < 200000;  /*Otra forma de poner el or y el and*/
                                                                                
/*Ejercicio 7
Enunciado:  1) Se va a hacer un aumento de sueldo de los PORTEROS. Para ello obtén el nombre, apellido y el nuevo salario de los PORTEROS si se aumenta un 
            10% el que tienen actualmente. La lista debe estar ordenada alfabéticamente por los apellidos.*/

--1)
select nombre, apellidos, salario*1.1 from futbolistas order by apellidos;  /*Una forma en la que podemos usar los operadores*/

/*Ejercicio 8
Enunciado:  1) Devuelve en una única columna el nombre del futbolista seguido de la palabra “es”y a continuación la posición que ocupa. La columna debe 
            llamarse “Posiciones”.*/

--1)
select nombre || ' es ' || posicion "Posiciones"from futbolistas;  /*||: Esto sirve para concatenar, es decir, en vez de poner , que separa las columnas 
                                                                      y crea varias crea una unica columna con todos lo que le quieras poner*/














