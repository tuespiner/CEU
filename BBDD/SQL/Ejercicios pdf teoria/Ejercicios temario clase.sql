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
Enunciado:  1) Obt�n el nombre de todos los futbolistas de la base de datos.
            2) Ahora queremos saber la posici�n que ocupan estos futbolistas (aunque se repitan los valores).
            3) Se quiere saber las posiciones existentes por lo que se requiere la posici�n de los futbolistas sin que se repitan los valores.*/
            
--1)        
select nombre from futbolistas; 

--2)
select posicion from futbolistas;

--3)
select distinct posicion from futbolistas; --distinct: hace que no salgan valores repetidos


/*Ejercicio 2
Enunciado:  1) Obt�n todas las posiciones posibles (diferentes) de los futbolistas bajo el encabezado �Demarcaciones�.
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
Enunciado:  1) Devuelve los apellidos de los futbolistas que su posici�n sea DEFENSA. Aplica un alias a apellidos para que se muestre 
�Futbolista�y asigna el alias F a la tabla futbolistas.*/

--1)
select f.apellidos "Futbolista" from futbolistas f where posicion='DEFENSA';        --Aqui le ponemos un alias a la tabla futbolistas y ponemos 'f.apellidos',
select f.apellidos "Futbolista" from futbolistas f where posicion like 'DEFENSA';   /*esto se usa cuando nos referimos a varias tablas a la vez, eso significa
                                                                                      que buscamos en la tabla f(futbolistas) una columna que se llama apellidos*/

/*Ejercicio 4
Enunciado:  1) Devuelve los apellidos de los futbolistas que su posici�n sea DEFENSA ordenador de la Z a la A.*/

--1)
select apellidos from futbolistas order by apellidos desc; /*order by: Esta expresion ordena de menor a mayor o de la a a la z con asc y al reves
                                                             con desc, hay que poner entre el order by y el asc/desc la clumna con la que lo queremos ordenar*/


/*Ejercicio 5
Enunciado:  1) Devuelve todos los datos de futbolistas ordenados primero por posici�n y luego por apellidos.*/

select * from futbolistas order by posicion , apellidos ;/*Para poder ordenar con dos tablas lo dividimos con ',', esto lo que hace es
                                                                 que primero lo ordena por la primera columna quepongamos y si hay repetidos
                                                                 por la segunda (por defecto el order by ordena de menor a mayor o de la a-z)*/

/*Ejercicio 6
Enunciado:  1) Obt�n el nombre de los futbolistas que cobran m�s de 150.000 euros (SALARIO).
            2) Muestra el ID de los futbolistas cuyo apellido sea G�MEZ.
            3) Indica los apellidos de los futbolistas que empiezan por G.
            4) Devuelve todos los datos de los futbolistas cuya posici�n sea DEFENSA o DELANTERO.
            5) Obt�n el nombre de los futbolistas que cobran entre 100.000 y 200.000 euros (SALARIO).*/
            
            
--1)
select nombre from futbolistas where salario > 150000;  /*<>: Podemos hacer operaciones como en programaci�n de mayor, menor, sumar, restar, etc.*/

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
select * from futbolistas where posicion like 'DEFENSA' or posicion like 'DELANTERO';  /*and, or: Es para poner una condici�n,por ejemplo un rango de edad*/


        
--5)
select  nombre from futbolistas where salario > 100000 and salario < 200000;  /*Otra forma de poner el or y el and*/
                                                                                
/*Ejercicio 7
Enunciado:  1) Se va a hacer un aumento de sueldo de los PORTEROS. Para ello obt�n el nombre, apellido y el nuevo salario de los PORTEROS si se aumenta un 
            10% el que tienen actualmente. La lista debe estar ordenada alfab�ticamente por los apellidos.*/

--1)
select nombre, apellidos, salario*1.1 from futbolistas order by apellidos;  /*Una forma en la que podemos usar los operadores*/

/*Ejercicio 8
Enunciado:  1) Devuelve en una �nica columna el nombre del futbolista seguido de la palabra �es�y a continuaci�n la posici�n que ocupa. La columna debe 
            llamarse �Posiciones�.*/

--1)
select nombre || ' es ' || posicion "Posiciones"from futbolistas;  /*||: Esto sirve para concatenar, es decir, en vez de poner , que separa las columnas 
                                                                      y crea varias crea una unica columna con todos lo que le quieras poner*/

/*Ejercicio 9
Enunciado:  1) Queremos saber todos los datos de los futbolistas que ganen m�s de 150.000 euros y sean defensas.*/


--1)
select * from futbolistas where salario > 149999 and posicion like 'DEFENSA';

/*Ejercicio 10
Enunciado:  1) ES UN TIPO TEST, LA RESPUESTA ES LA B*/

/*Ejercicio 11
Enunciado:  1) Realiza una consulta que te devuelva los campos Nombre, Salario, Salario bruto terminado en la palabra 
            �euros� y llamando a esa columna �Salario bruto�.*/


--1)
select nombre, salario , salario*1.5 || ' EUROS' "Salario bruto" from futbolistas;


/*Ejercicio 12
Enunciado: Realiza las siguientes operaciones utilizando funciones num�ricas:
            1) Calcula el valor absoluto de -10.
            2) Obt�n el exponente en base e de 4.
            3) Redondea el n�mero 15,3 a 16.
            4) Redondea el n�mero anterior (15,3) a 15.
            5) Calcula el resto de 15 entre 3 (15/3).
            6) Eleva 15 al exponente 2 (15^2).*/
            

--1)
select abs(-10) from dual; /*ABS(n): Esta funci�n sirve para conocer el valor absoluto de un numero, en este caso hemos puesto 
                                    -10 y el valor absoluto es 10*/

--2)
select exp(4) from dual; /*PREGUNTAR A INDA PARA QUE SIRVE*/

--3)
select ceil(15.3) from dual; /*ceil(n): Redondea n al numero absoluto superior, si tenemos 10,1 lo redondearia a 11*/

--4)
select floor(15.3) from dual; /*floor(n): Redondea n al numero absoluto inferior, si tenemos 10,1 lo redondearia a 10*/

--5)
select mod(15,3) from dual; /*mod(m,n): Esto calcula el resto de m entre n, si por ejemplo pusieramos mod(10,3)saldria 1*/

--6)
select power(15,2) from dual; /*power(m,n): Ejeva m a n, es decir si quisieramos sabercuanto es 2^4 tendriamos que poner
                                       power(2,4)*/

/*Ejercicio 13
Enunciado: Realiza las siguientes operaciones utilizando funciones num�ricas:
            1) Redondea 15,789 con un decimal.
            2) Obt�n la ra�z cuadrada de 128.
            3) Trunca 15,789 a 1 decimal.
            4) Trunca 15,789 para dejarlo sin decimales (15).
            5) Trunca 157,89 para dejarlo en 100.
            6) Obt�n el signo de -15 (es decir -1).*/

--1)
select round(15.789,1) from dual;  /*round: Como su nombre dice es para redondear, lo primero que se tiene que poner es el numero 
                                     con decimal con . (5.5), poner una coma y a cuanto lo quieres redondear (round(5.50,1)=5.5)*/
--2)
select sqrt(128) from dual;     /*sqrt(square root): Te dice la raiz cuadrada de un numero, simplemente tienes que poner el 
                                  n�mero dentro del parentesis sqrt(100) = 10*/
--3)
select trunc(15.789,1) from dual;  /*trunc: como su nombre dice, esta funci�n trunca un n�mero, el decimal hay que ponerlo como en 
                                     el round y tambien hay que poner un n�mero como en el round*/

--4)
select trunc(15.789,0)from dual;

--5)
select trunc(157.89,-2) from dual;

--6)
select sign(-15) from dual;  /*sign: Esta funci�n basicambente te dice si un n�mero es positivo o negativo poniendote o +1
                               o -1*/

/*Ejercicio 14
Enunciado: realiza las siguientes peticiones:
            1) �Cu�l es el car�cter 80 en ASCII?
            2) Obt�n el valor ASCII de la letra H.
            3) Devuelve el nombre y los apellidos
               en una �nica columna de los
               futbolistas cuya posici�n sea
               DEFENSA. El nombre de estar
               completamente en may�sculas y los
               apellidos en min�sculas.
            4) Obt�n todas las posiciones posibles
               (no repetidas) con la primera letra
               en may�sculas y el resto en
               min�scula) ordenadas alfabet.
            5) Devuelve los nombres de los
               futbolistas del EQUIPO A con el
               siguiente formato: --AAA, siendo
               AAA las tres primeras letras del
               nombre. Ej.: --PED, --LUI, etc.
            6) Devuelve los nombres de los
               futbolistas del EQUIPO A con el
               siguiente formato: AAA--, siendo
               AAA las tres primeras letras del
               nombre. Ej.: PED--, LUI--, etc.
            7) Devuelve el nombre de los
               futbolistas sustituyendo �LUIS� por
               �L.�.
            8) Queremos los apellidos de los
               futbolistas con tan solo 3 caracteres.
            9) Devuelve el nombre de los
               futbolistas sustituyendo �LUIS� por
               �L.� y en otra columna el tama�o de
               los apellidos (longitud de caract.).*/

--1)
select chr(80) from dual;  /*chr: Nos dice que letra es el codigo ascii que le pongamos*/

--2)
select ascii('H') from dual;  /*ascii: Nos dice el c�digo ascii de la letra que pongamos*/

--3)
select upper(nombre) || ' ' || lower(apellidos) from futbolistas where posicion not like 'DEFENSA'; /*Upper, Lower: Pone las columnas que pongamos en mayusculas
                                                                                                        o minusculas*/

--4)
select distinct initcap(posicion) from futbolistas order by initcap(posicion) asc ;  /*initcap: Pone la primera letra en mayusculas*/

--5)
select lpad(substr(nombre,1,3),5,'--') from futbolistas where id_equipo like 1;  /*lpad, rpad: Sirve para que todas las consultas tengnla misma longitud, es decir
                                                                                    que si tenemos hola y en otro hol que la a se rellene con lo que pongamos
                                                                                    por ejemplo -*/

--6)
select rpad(substr(nombre,1,3),5,'--') from futbolistas where id_equipo like 1;

--7)
select  replace(nombre,'LUIS','L') from futbolistas;  /*replace(t,a,c): Reemplaza ciertas palabras por otras replace(nomb columna,cadena a reemplazar, 
                                                            cadena para reemplazar) ej: replace(nombre,'JUAN','J') reemplaza todo lo que se llame JUAN
                                                            en la columna nombre por J*/

--8)
select substr(apellidos,1,3) from futbolistas;  /*substr(t,ini,fin): Devuelve partes de una cadena, primero ponemos la columna, luego la posici�n en al 
                                                    que empiezas a recoger y la ultima posici�n, si tienes hola y poner substr('hola',1,2) recogeria ho*/

--9)
select  replace(nombre,'LUIS','L'), length(apellidos) from futbolistas;  /*lenght: Te dice la longitud de caracteres que tiene una cadena, por ejemplo:
                                                                                lenght('hola') devolveria 4*/

/*Ejercicio 15
Enunciado: Realiza las siguientes peticiones:
            1) Obt�n en tres columnas independientes, el d�a,
               el mes y la fecha de hoy.
            2) Muestra por pantalla la fecha que ser� dentro de
               6 meses utilizando ADD_MONTHS.
            3) Muestra el n�mero de meses que hay entre hoy y
               la fecha de nacimiento de todos los futbolistas.
            4) �Cu�l es el �ltimo d�a de este mes? Mu�stralo.
            5) �Qu� d�a ser� el pr�ximo lunes? Ponlo por
               pantalla mediante una petici�n.
            6) Muestra el d�a que era hace 4 d�as. �Y el d�a de
               ma�ana?*/
               
--1) 
select extract(day from sysdate), extract(month from sysdate), extract(year from sysdate) from dual;  /*extract: Sirve para conseguir algo especifico de una fecha, puede ser un dia, un mes o un a�o
                                                                                                        , ponte que tenemos esto: '01/01/2024' y queremos sacar el dia, tendriamos que poner
                                                                                                        extract(day from '01/01/2024')y solo tenemos que cambar donde pone day a month o year.*/

--2)
select add_months(sysdate,6 ) from dual;  /*add_months: sirve cuando queremos saber que mes seria si a�adieramos algunos meses, la sintaxis es add_months((fecha),(n� de meses a a�adir))*/

--3)
select floor(months_between(sysdate,fecha_nacimiento)) from futbolistas;  /*months_between: te dice los meses que hay entre una fecha y otra, se pone asi months_between((fecha 1),(fecha 2))*/

--4)
select last_day(sysdate) from dual;  /*last_DAY: te dice el �ltimo dia del mes de la fecha que pongas, se pone asi last_day((fecha))*/

--5)
select next_day(sysdate,'LUNES') from DUAL;  /*next_day: Te dice que dia es el siguiente lunes, martes miercoles, etc. La sintaxis es asi next_day((fecha),'(dia, ej: LUNES, MARTES, etc)')*/

--6)
select sysdate -4, sysdate +1 from dual;  /* si ponemos una fecha y luego un -(n) o +(n) (n = numero) podemos saber que dia es al sumarle o restarle el n que pongamos*/


/*Ejercicio 16
Enunciado: Realiza las siguientes peticiones:
            1) Convierte �1000.45� a un n�mero
            2) Convierte �1000.45�� a un n�mero
            3) Convierte �-$1000.45� a un n�mero
            4) Muestra el d�a de hoy con los siguientes
               formatos:
                � 12/02/2021, 12/02/21, 12-feb-2021, 12 de febrero
                  de 2021
            5) Convierte el ID de la tabla FUTBOLISTAS en un
               n�mero de tres cifras.
            6) Muestra todos los a�os de nacimiento de los
               futbolistas (solo el a�o, ej.: 1990, 1991, etc.).
            Ord�nalos de menor a mayor a�o.*/
            
--1)
select to_number('1000.45', '9999.99') from dual;

--2)













