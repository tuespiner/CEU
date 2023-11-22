-- Apartado 1
create table agencias(
    id int,
    direccion varchar2(100),
    telefono char(13),
    nombre varchar2(50),
    num_empleados int
);
-- Apartado 2
create table empleados(
    codigo_emp int,
    nombre varchar2(50),
    fecha_nac date,
    id_agencia 
);

-- Apartado 3
alter table agencias add primary key (id);

-- Apartado 4
alter table empleados add primary key (codigo_emp);

-- Apartado 5
alter table empleados add constraint fk_agencias_e foreign key (id_agencia) references agencias(id);

-- Apartado 6
rename agencias to inmobiliarias;

-- Apartado 7
alter table empleados rename constraint fk_agencias_e to fk_agencias_emp;

-- Apartado 8
alter table empleados add salario number(8,2);
alter table empleados add check(salario>0);

-- Apartado 9
alter table inmobiliarias add check(regexp_like(telefono,'0034[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'));