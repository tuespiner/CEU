alter session set "_ORACLE_SCRIPT"=true;

drop user examen cascade;
create user practicaFinal identified by a123456
default tablespace system 
quota unlimited on system;
grant connect, create session, create table TO practicaFinal;


grant create procedure to practicaFinal;