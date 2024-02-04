/*Ejercicio1
    ¿Cuántos partitos ha jugado como local EQUIPO A? Debes usar el campo nombre de equipos.*/

select nombre from equipos;
select * from partidos;
select * from equipos;
select count(estadio) from partidos where substr(estadio,length(estadio)-1,length(estadio)) like ' A';
select length(estadio) from partidos;
select substr(estadio,length(estadio)-1,length(estadio)) from partidos;

select count(nombre) from equipos full join partidos on equipos.id = partidos.id_equipo_casa;