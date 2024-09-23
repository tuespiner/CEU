create table empleados(
    dni char(9) primary key,
    nombre_c varchar2(100),
    fecha_n date,
    presidente varchar2(100),
    preparador varchar2(100),
    mantto varchar2(100),
    entrenador varchar2(100),
    admin varchar2(100),
    directivo varchar2(100),
    base varchar2(100),
    ala_pivot varchar2(100),
    escolta varchar2(100),
    alero varchar2(100),
    pivot varchar2(100),
    dni_jugador char(9),
    dni_otro char(9)
);
create table equipos(
    nombre varchar2(100) primary key,
    direccion varchar2(100),
    telefono int,
    id_pabellon int
);
create table tienen(
    f_incorp date,
    nombre_equipo varchar2(100),
    dni_empleado char(9)
);
create table juegan(
    min_jug int,
    faltas_c int,
    reb_d int,
    reb_a int,
    tiros_lib_a int,
    tiros_lib_b int,
    id_partido int,
    dni_jugador char(9),
    nombre_equipo varchar2(100)
);
create table partidos(
    id int primary key,
    resultado varchar2(100)
);
create table pabellones(
    id int primary key,
    direccion varchar2(100),
    telefono int,
    capacidad int
);


alter table empleados add foreign key (dni_jugador) references empleados(dni);
alter table empleados add foreign key (dni_otro) references empleados(dni);
alter table empleados add check(regexp_like(dni,'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'));

alter table tienen add foreign key (nombre_equipo) references equipos(nombre);
alter table tienen add foreign key (dni_empleado) references empleados(dni);

alter table juegan add foreign key (dni_jugador) references empleados(dni);
alter table juegan add foreign key (nombre_equipo) references equipos(nombre);
alter table juegan add foreign key (id_partido) references partidos(id);
alter table juegan add check((tiros_lib_a >0) and (tiros_lib_b > 0) and (reb_a > 0) and (reb_d > 0) and (faltas_c<=5) and (min_jug <= 40));

alter table equipos add foreign key (id_pabellon) references pabellones(id);

