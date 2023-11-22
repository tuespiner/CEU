-- Ejercicio 1 examen
create table estaciones(
    nombre varchar2(30) primary key,
    direccion varchar2(30),
    telefono char(9),
    andenes int,
    volumen_entradas int,
    volumen_salidas int,
    localidad varchar2(30)
);
create table responsables(
    dni char(9) primary key,
    edad int,
    apellidos varchar2(30),
    nombre varchar2(30),
    direccion varchar2(30),
    nombre_estacion varchar2(30)
);
create table telefonos(
    dni_responsable char(2) primary key,
    tipo varchar2(30),
    numero char(9)
);
create table empresas(
    codigo char(2) primary key,
    cif char(9),
    nombre_comercial varchar2(30),
    direccion varchar2(30),
    cod_empresa_gestora char(2),
    cod_empresa_filial char(2)
);
create table tienen(
    codigo_empresa char(2),
    nombre_estacion varchar2(30)
);
create table trayectos(
    codigo char(2)primary key,
    numero_de_plazas_vendidas int,
    cod_empresa char(2)
);
create table son_realizados(
    fecha_salida date,
    hora_salida int,
    fecha_llegada date,
    hora_llegada int,
    estacion_origen varchar2(30),
    estacion_destino varchar2(30)
);
create table autobuses(
    matricula char(7) primary key,
    numero_bastidor int,
    años_del_vehiculo int,
    fecha_ultima_revision date,
    km_recorridos int,
    codigo_empresa char(2),
    nombre_estacion varchar2(30)
);
create table personal(
    dni char(9) primary key,
    nombre varchar2(30),
    apellidos varchar2(30),
    direccion varchar2(30),
    dni_conductor char(9),
    dni_venta char(9),
    dni_revisor char(9),
    codigo_empresa char(2)
);

alter table empresas add foreign key (cod_empresa_gestora) references empresas(codigo);
alter table empresas add foreign key (cod_empresa_filial) references empresas(codigo);

alter table autobuses add foreign key (nombre_estacion) references estaciones(nombre);
alter table autobuses add foreign key (codigo_empresa) references empresas(codigo);

alter table personal add foreign key (codigo_empresa) references empresas(codigo);
alter table personal add foreign key (dni_conductor) references personal(dni);
alter table personal add foreign key (dni_venta) references personal(dni);
alter table personal add foreign key (dni_revisor) references personal(dni);

alter table responsables add foreign key (nombre_estacion) references estaciones(nombre);

alter table son_realizados add foreign key (estacion_destino) references estaciones(nombre);
alter table son_realizados add foreign key (estacion_origen) references estaciones(nombre);

alter table telefonos add foreign key (dni_responsable) references responsables(dni);

alter table tienen add foreign key (codigo_empresa) references empresas(codigo);
alter table tienen add foreign key (nombre_estacion) references estaciones(nombre);

alter table trayectos add foreign key (cod_empresa) references empresas(codigo);