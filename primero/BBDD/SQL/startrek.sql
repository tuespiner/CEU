--Realización tablas

drop table actores cascade constraints;
create table actores (
    id_actor char(2) primary key,
    nombre_completo varchar(50),
    fecha_nacimiento date,
    nacionalidad varchar(20)
);
drop table personajes cascade constraints;
create table personajes(
    id_personaje char(2) primary key,
    nombre varchar(50),
    raza varchar(15),
    graduación_militar varchar(15)
);
drop table planetas cascade constraints;
create table planetas(
    cod_planeta char(2) primary key,
    nombre varchar(15),
    galaxia varchar(20)
);
drop table capitulos cascade constraints;
create table capitulos (
    temporada integer,
    orden integer,
    titulo varchar(30),
    fecha_de_la_emisión date,   
    primary key(temporada,orden)
);
drop table películas cascade constraints;
create table películas (
    id_pelicula char(2) primary key,
    titulo varchar (30),
    director varchar(30),
    año_lanzamiento integer
);
drop table nave cascade constraints;
create table nave(
    cod_nave char(2) primary key,
    num_tripulantes integer,
    nombre varchar(50)
);
drop table visitas cascade constraints;
create table visitas (
    problema_resuelto varchar2(200),
    cod_planeta char(2),
    cod_nave char(2),
    temporada integer,
    orden integer
);
drop table productos cascade constraints;
drop table aparecer cascade constraints;
create table aparecer(
    id_personaje char(2),
    id_pelicula char(2)
);

--Creación FK y PK

alter table películas add foreign key (id_personaje) references personajes(id_personaje);
alter table actores add foreign key (id_personaje) references personajes(id_personaje);
alter table visitas add foreign key (cod_planeta) references planetas(cod_planeta);
alter table visitas add foreign key (cod_nave) references naves(cod_nave);
alter table aparecer add foreign key (id_personaje) references personajes(id_personaje);
alter table aparecer add foreign key (id_pelicula) references películas(id_pelicula);
alter table visitas add foreign key (temporada,orden) references capitulos(temporada,orden);

--Creación atributos

alter table actores add id_personaje char(2);
alter table películas add id_personaje char(2);
alter table visitas add orden integer;

--Ejercicio 1
drop table fabricantes cascade constraints;
create table piezas (
    id int,
    nombre varchar2(100),
    id_fabricante int
);
drop table fabricantes cascade constraints;
create table fabricantes (
    id int,
    marca varchar(50)
);

--restricciones

alter table piezas add primary key (id);
alter table fabricantes add primary key (id);
alter table piezas add foreign key (id_fabricante) references fabricantes(id);

--añadir check

drop table piezas cascade constraints;
create table piezas (
    id int check(id>0),
    nombre varchar(200),
    id_fabricante int
);
drop table animales cascade constraints;
alter table piezas add check(id>0);
alter table piezas add precio number(4,2);
alter table piezas add check(precio>0);
create table animales (
    chip char(5),
    nombre varchar2(100),
    tipo_animal varchar2(100)
);
alter table animales add check (regexp_like(chip,'E[A-Z][0-5]'));
alter table animales add primary key (chip);
alter table fabricantes add check(marca = 'FABRIC1' or marca= 'FABRIC2' or marca= 'FABRIC3');
alter table fabricantes add check(marca in('FABRIC1','FABRIC2','FABRIC3'));
alter table fabricantes add check(marca in('FABRIC[1-3]'));

--Ejercicio 1 restricciones
drop table lotes cascade constraints;
create table lotes (
    codigo int primary key,
    num_kg number(8,2) check(num_kg>0),
    precio_kg_salida number(8,2) check(precio_kg_salida>0),
    precio_kg_vendido number(8,2) check(precio_kg_vendido>0),
    check(precio_kg_vendido>precio_kg_salida),
    fecha date not null
    
);

--Ejercicio1 GBBDD
create table categorias(
    codigo char(2) primary key,
    descripcion varchar2(200),
    id char(2)
);
create table productos(
    id char(2) primary key,
    nombre varchar2(50),
    codigo char(2)
);

--Ejercicio2 GBBDD
create table cuentas_bancarias (
    numero char(16) primary key,
    saldo int,
    codigo char(2)
);
create table transacciones(
    codigo char(2) primary key,
    tipo varchar2(10),
    cantidad int,
    numero char(16)
);

alter table transacciones add foreign key (numero) references cuentas_bancarias(numero);

--Ejercicio3 GBBDD
create table aulas (
    numero char(2),
    planta char(2),
    situacion varchar2(200)
);

create table estudiantes (
    numero_matricula char(5) primary key,
    nombre varchar2(50),
    direccion varchar2(50)
);

create table estudios (
    numero char(2),
    planta char(2),
    numero_matricula char(5),
    denominacion varchar2(30),
    ciclo varchar2(30)
);

alter table aulas add primary key (numero, planta);
alter table estudios add primary key (numero, planta, numero_matricula, denominacion, ciclo);

-- Ejercicio 4 GBBDD

create table aulas (
    numero char(2),
    planta char(2),
    situacion varchar2(200)
);

create table estudiantes (
    numero_matricula char(5),
    nombre varchar2(50),
    direccion varchar2(50)
);
create table estudios (
    numero char(2),
    planta char(2),
    numero_matricula char(5),
    denominacion varchar2(30),
    ciclo varchar2(30),
    hora char(2),
    id char(2) primary key
);
create table asignaturas(
    denominacion varchar2(30),
    ciclo varchar2(30)
);
alter table aulas add primary key (numero,planta);
alter table asignaturas add primary key (denominacion, ciclo);
alter table estudios add foreign key (numero_matricula) references estudiantes(numero_matricula);
alter table estudios add foreign key (denominacion,ciclo) references asignaturas(denominacion,ciclo);
alter table estudios add foreign key (numero,planta) references aulas(numero,planta);

--Ejercicio 5 GBBDD

Create table representantes (
    id_licencia char(2) primary key,
    nombre varchar2(30)
);
create table actores (
    id_carne char(2) primary key,
    nombre_a varchar2(30),
    nombre_b varchar2(30),
    id_licencia_representante char(5),
    contrato varchar2(200)
    
);

--Ejercicio 6 GBBDD

Create table empleados(
    DNI char(9) primary key,
    nombre varchar2(30),
    DNISupervisor char(9)
);

--Ejercicio 7 GBBDD

Create table piezas (
    codigo char(2) primary key,
    descripcion varchar2(200)
);
Create table compuestos (
    codigo char(2),
    codigo_c char(2)
);
alter table compuestos add primary key (codigo, codigo_c);

--Ejercicio 8 GBBDD
create table actores(
    identificador char(2)primary key,
    nombre varchar2(30),
    identificadorPersonaje char(2)
);
create table personajes (
    identificador char(2) primary key,
    nombre varchar2(30),
    pelicula varchar2(100),
    identificadorActor char(2)
);

alter table actores add foreign key (identificadorPersonaje) references personajes(identificador);
alter table personajes add foreign key (identificadorActor) references actores(identificador);

--Ejercicio 9

create table directivos(
    DNI char(9),
    nombre varchar2(30),
    puesto varchar2(50),
    departamento varchar2(50)
);
create table comerciales (
    DNI char(9),
    nombre varchar2(30),
    puesto varchar2(50),
    comision int
);
create table tecnicos(
    DNI char(9),
    nombre varchar2(30),
    puesto varchar2(50),
    equipo char(2)
);

--Ejercicio 10 GBBDD

create table alumnos(
    dni char(9) primary key,
    nombre varchar2(30),
    direccion varchar2(30),
    telefono char(9),
    edad int,
    cif char(9)
);
create table empresas (
    cif char(9) primary key,
    nombre varchar2(30),
    descripcion varchar2(200),
    telefono char(9)
);
create table cursos (
    codigo char(2) primary key,
    fecha_inicio date,
    fecha_fin date,
    identificador char(2),
    dni_profesor char(9)
);
create table tipos_de_cursos(
    identificador char(2) primary key,
    programa varchar2(200),
    horas_duracion int,
    titulo varchar2(50)
);
create table profesores (
    dni char(9) primary key,
    nombre varchar2(30),
    apellidos varchar2(30),
    direccion varchar2(30),
    telefono char(9)
);
create table asistencias(
    dni char(9),
    codigo char(2),
    nota number(2)
);

alter table asistencias add primary key (dni,codigo);
alter table alumnos add foreign key (cif) references empresas(cif);
alter table cursos add foreign key (identificador) references tipos_de_cursos(identificador);
alter table cursos add foreign key (dni_profesor) references profesores(dni);

--Ejercicio 11 GBBDD

create table socios(
    codigo_de_socio char(2),
    dni char(9) primary key,
    nombre varchar2(30),
    apellidos varchar2(30),
    direccion varchar2(30),
    telefonos char(9)
);
create table libros(
    isbn char(13) primary key,
    titulo varchar2(30),
    editorial varchar2(30),
    año_publicacion date,
    autores varchar2(200),
    año_edicion date,
    deteriorado varchar2(30)
);
create table prestamos(
    codigo_de_socio char(2) primary key,
    dni char(9),
    isbn char(13),
    fecha_prestamo date,
    fecha_devolucion date,
    fecha_real_devolucion date
);

alter table socios add foreign key (codigo_de_socio) references prestamos(codigo_de_socio);
alter table prestamos add foreign key (dni) references socios(dni);
alter table prestamos add foreign key (isbn) references libros(isbn);

--Ejercicio 12 GBBDD
drop table localidades cascade constraints;
create table localidades(
    nombre varchar2(30) primary key,
    nombreCCAA varchar(30),
    poblacion int,
    esCapitalProvincia varchar2(30),
    esCapiralCCAA varchar2(30),
    dosDigitosCCPP char(2)
);
create table provincias(
  dosDigitosCCPP char(2) primary key,
  nombre varchar2(30),
  poblacion int,
  nombreCCAA varchar(30)
);
create table CCAAS(
    nombre varchar2(30) primary key,
    poblacion int,
    superficie float
);

alter table localidades add foreign key (dosDigitosCCPP) references provincias(dosDigitosCCPP);
alter table localidades add foreign key (nombreCCAA) references CCAAS(nombre);
alter table provincias add foreign key (nombreCCAA) references localidades(nombre);

--Ejercicio 13 GBBDD

create table actores(
    id char(2) primary key,
    nombre_completo varchar2(30),
    fecha_nacimiento date,
    nacionalidad varchar2(30),
    id_personaje char(2)
);
create table personajes(
    id char(2) primary key,
    nombre varchar2(30),
    raza varchar2(30),
    graduacion_militar varchar2(30),
    id_actor char(2),
    id_personaje_superior char(2)
);
create table peliculas(
    id char(2) primary key,
    año_lanzamiento int,
    titulo varchar2(30),
    director varchar2(30),
    id_personaje_protagonista char(2)
);
create table capitulos(
    temporada int,
    orden varchar2(30),
    titulo varchar2(30),
    fecha_1ª_emision date
);

alter table capitulos add primary key (temporada,orden);

create table planetas(
    codigo char(2) primary key,
    nombre varchar2(30),
    n_tripulantes int
);
create table naves(
    codigo char(2) primary key,
    nombre varchar2(30),
    n_tripulantes int
);
create table personajes_peliculas(
    id_personaje char(2),
    id_pelicula char(2)
);
create table personajes_capitulos(
    id_personaje char(2),
    temporada int,
    orden varchar2(30)
);
create table visitas(
    codigo_planeta char(2),
    codigo_nave char(2),
    temporada int,
    orden varchar2(30)
);

alter table actores add foreign key (id_personaje) references personajes(id);
alter table personajes add foreign key (id_actor) references actores(id);
alter table peliculas add foreign key (id_personaje_protagonista) references personajes(id);
alter table personajes_peliculas add foreign key (id_personaje) references personajes(id);
alter table personajes_peliculas add foreign key (id_pelicula) references peliculas(id);
alter table personajes_capitulos add foreign key (id_personaje) references personajes(id);
alter table personajes_capitulos add foreign key (temporada,orden) references capitulos(temporada,orden);
alter table visitas add foreign key (codigo_planeta) references planetas(codigo);
alter table visitas add foreign key (codigo_nave) references naves(codigo);
alter table visitas add foreign key (temporada,orden) references capitulos(temporada,orden);

--Ejercicio 14 GBBDD

create table personajes(
    codigo char(2) primary key,
    nombre varchar2(30),
    graduacion varchar2(30),
    raza varchar2(30),
    fecha_nacimiento date,
    ciudad varchar2(30),
    nombre_mentos varchar2(30),
    fecha_graduacion date,
    planeta_natal varchar2(30),
    fecha_ult_combate date
);

--Ejercicio 15 GBBDD

create table accidentes_geograficos(
    posicion_horizontal int,
    posicion_vertical int,
    nombre varchar2(30),
    tipo varchar2(30),
    longitud int,
    altura int,
    extension int
);
create table paises(
    id char(2) primary key,
    nombre varchar2(30),
    extension int,
    poblacion int
);
create table localidades(
    nombre varchar2(30) primary key,
    id char(2)
);
create table localizaciones(
    posicion_horizontal int,
    posicion_vertical int,
    nombre_localidad varchar2(30),
    id_pais char(2)
);
create table pasos_rios(
    posicion_horizontal int,
    posicion_vertical int,
    nombre_localidad varchar2(30),
    id_pais char(2)
);

alter table accidentes_geograficos add primary key (posicion_horizontal,posicion_vertical);
alter table localidades add primary key (nombre);
alter table localizaciones add foreign key (posicion_horizontal,posicion_vertical) references accidentes_geograficos(posicion_horizontal,posicion_vertical);
alter table localizaciones add foreign key (id_pais) references paises(id);
alter table pasos_rios add foreign key (posicion_horizontal,posicion_vertical) references accidentes_geograficos(posicion_horizontal,posicion_vertical);
alter table pasos_rios add foreign key (nombre_localidad) references localidades(nombre);
alter table pasos_rios add foreign key (id_pais) references paises(id);

--Ejercicio 16 GBBDD

create table empleados(
    dni char(9) primary key,
    nombre varchar2(30),
    experiencia int
);
create table clientes(
    dni char(9) primary key,
    nombre varchar2(30),
    profesion varchar2(30),
    telefono char(9),
    direccion varchar2(30)
);
create table tratamientos(
    id char(2) primary key,
    nombre varchar2(30),
    tipo varchar2(30)
);
create table servicios(
    dni_empleado char(9),
    dni_cliente char(9),
    id_tratamiento char(2),
    fecha date
);

alter table servicios add foreign key (dni_empleado) references empleados(dni);
alter table servicios add foreign key (dni_cliente) references clientes(dni);
alter table servicios add foreign key (id_tratamiento) references tratamientos(id);

--Ejercicio 17 GBBDD

create table trabajadores(
    dni char(9),
    nombre varchar2(30),
    apellido varchar2(30),
    telefono char(9),
    experiencia int,
    fecha_incorporacion date,
    puesto varchar2(30),
    dni_jefe char(9)
);
create table platos(
    id char(2),
    nombre varchar2(30), 
    tipo varchar2(30)
);
create table ingredientes(
    
);