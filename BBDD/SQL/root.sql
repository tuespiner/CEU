alter session set "_ORACLE_SCRIPT"=true;

drop user examen cascade;
create user prueba identified by a123456
default tablespace system 
quota unlimited on system;
grant connect, create session, create table TO prueba;


grant create procedure to prueba;