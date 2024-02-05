/*Ejercicio1
    ¿Cuántos partitos ha jugado como local EQUIPO A? Debes usar el campo nombre de equipos.*/
select * from equipos join partidos on equipos.id = partidos.id_equipo_casa where partidos.id_equipo_casa = 1;

/*Ejercicio 2
     ¿Cuál es el nombre del equipo en el que juega el futbolista de menor peso?*/

select distinct equipos.nombre from  equipos join futbolistas on equipos.id = futbolistas.id_equipo where futbolistas.salario = (select min(futbolistas.salario) from futbolistas);

/*Ejercicio3
    Devuelve en una única columna la fase: El futbolista NOMBRE juega en el equipo NOMBRE, correspondiendo al campo nombre de futbolista y de equipo*/
select 'El futbolista ' || futbolistas.nombre || ' juega en el equipo ' || equipos.nombre from futbolistas join equipos on futbolistas.id_equipo = equipos.id;