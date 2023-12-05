create table Especies(
    codigo char(2),
    nombre varchar2(50),
    clase varchar2(50),
    armador varchar2(50),
    capacidad int,
    nacionalidad varchar2(50)
);

create table Lotes(
    codigo char(2),
    matricula char(7),
    num_kg int,
    precio_kg_salida number(4,2),
    precio_kg_vendido number(4,2),
    fecha_venta date,
    cod_especie char(2)
);
create table Especies(
    
);