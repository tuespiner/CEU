alter session set "_ORACLE_SCRIPT"=true;
drop user examen cascade;
create user examen identified by examen
default tablespace system
quota unlimited on system;
grant connect, create session, create table TO examen;