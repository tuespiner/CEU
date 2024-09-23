create table profesores (
    dni char(9),
    nombre varchar2(15),
    apellidos varchar2(30),
    categoria varchar2(50),
    fecha_alta date,
    fecha_baja date,
    direccion varchar2(50)
);
drop table asignatura cascade constraints;
create table asignatura (
    codigo char(2),
    denominacion varchar2(50),
    centro varchar2(20)
);
create table imparten (
    codigo char(2),
    dni char(9),
    horas int
);
alter table imparten drop column dedicacion;
alter table profesores add fecha_alta date not null;
alter table imparten add constraint horas_minimas check(horas>0);
alter table profesores add check(dedicacion in('completa','parcial'));
alter table profesores add check(categoria in('doctor','contratado','superior','medio'));
alter table profesores add check(fecha_baja>fecha_alta);
alter table profesores modify column fecha_alta not NULL;
alter table profesores add check(fecha_baja>fecha_alta);
alter table profesores drop column fecha_alta;


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
    numero_matricula char(5),
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

alter table estudios add foreign key 
alter table asignaturas add primary key (denominacion, ciclo);
alter table estudios add primary key (id);

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
    identificador char(2),
    nombre varchar2(30),
    pelicula varchar2(100),
    identificadorActor char(2)
);

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
create table asistencia(
    dni char(9),
    codigo char(2),
    nota number(2)
);

