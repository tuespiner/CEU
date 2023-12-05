alter session set "_ORACLE_SCRIPT"=true;
drop user examen cascade;
create user Ejercicio1_caladeros identified by a123456
default tablespace system
quota unlimited on system;
grant connect, create session, create table TO Ejercicio1_caladeros;