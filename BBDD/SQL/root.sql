alter session set "_ORACLE_SCRIPT"=true;

drop user examen cascade;
create user Tema6 identified by a123456
default tablespace system 
quota unlimited on system;
grant connect, create session, create table TO Tema6;


grant create procedure to Tema6;