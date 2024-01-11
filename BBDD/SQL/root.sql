alter session set "_ORACLE_SCRIPT"=true;
drop user examen cascade;
create user Ejercicio_Semanal_1 identified by a123456 
default tablespace system 
quota unlimited on system;
grant connect, create session, create table TO Ejercicio_Semanal_1;