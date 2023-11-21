drop table productos cascade constraints;
drop table clientes cascade constraints;
drop table pedidos cascade constraints;

create table productos(
    id int,
    nombre varchar2(100),
    tipo varchar2(50)
);
create table clientes(
    codigo int,
    nombre varchar2(50),
    fecha_nacimiento date
);
create table pedidos(
    id_producto int,
    id_cliente int,
    fecha_compra date
);
alter table productos add primary key (id);
alter table clientes add primary key (codigo);
alter table pedidos add primary key (id_producto,id_cliente);

alter table pedidos add constraint fk_pedidos_productos foreign key (id_producto) references productos(id);

alter table pedidos add constraint fk_pedidos_clientes foreign key (id_cliente) references clientes(codigo);

alter table pedidos drop constraint fk_pedidos_productos ;
rename  productos to products;

alter table pedidos add constraint fk_pedidos_productos foreign key (id_producto) references products(id);

alter table pedidos rename constraint fk_pedidos_clientes to fk_ped_cli;

alter table clientes add  provincia varchar2(50);

alter table clientes rename column provincia to id_provincia ;
alter table clientes modify id_provincia int;

create table provincias(
    id int,
    nombre varchar2(50)
);

alter table provincias add constraint pk_provincias primary key (id);

alter table products add check(tipo = 'nuevo''segundamano''restaurado''deteriorado');
alter table products add check(tipo in( 'nuevo','segundamano','restaurado','deteriorado'));

alter table products add importe number(6,2);
alter table products add check(importe>=0);

alter table clientes add referencia_socio char(5);
alter table clientes drop column referencia_socio;
alter table clientes add check(regexp_like(referencia_socio,'CO-[0-9][0-9]'));