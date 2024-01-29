/*Ejercicio 1: Devuelve el nombre del futbolista cuyo salario es el más bajo posible de todos los futbolistas nacidos entre 1985 y 1990.*/
select nombre from futbolistas where salario = (select min(salario) from futbolistas) and fecha_nacimiento between to_date('01/01/1985') and to_date('31/12/1990');

/*Ejercicio 2: Indica cuántos futbolistas que no juegan de portero tienen un apellido que termina en ez.*/
select nombre, posicion from futbolistas where apellidos like '%EZ'and posicion not like 'PORTERO' ;

/*Ejercicio 3: Devuelve el id del equipo con alias "id equipo", el número de futbolistas con alias "Número de futbolistas" y el salario medio redondeado a 2 decimales 
con alias "Salario medio" de los futbolistas agrupado por el equipo en el que juegan.*/
select id_equipo "Id equipo", count(nombre) "Número de futbolistas", round(avg(salario),2) "Salario medio" from futbolistas group by id_equipo;