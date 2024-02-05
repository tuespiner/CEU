create table dept(
  deptno number(2,0),
  dname  varchar2(14),
  loc    varchar2(13),
  constraint pk_dept primary key (deptno)
);
 
create table emp(
  empno    number(4,0),
  ename    varchar2(10),
  job      varchar2(9),
  mgr      number(4,0),
  hiredate date,
  sal      number(7,2),
  comm     number(7,2),
  deptno   number(2,0),
  constraint pk_emp primary key (empno),
  constraint fk_deptno foreign key (deptno) references dept (deptno)
);

insert into dept
values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept
values(20, 'RESEARCH', 'DALLAS');
insert into dept
values(30, 'SALES', 'CHICAGO');
insert into dept
values(40, 'OPERATIONS', 'BOSTON');
 
insert into emp
values(
 7839, 'KING', 'PRESIDENT', null,
 to_date('17-11-1981','dd-mm-yyyy'),
 5000, null, 10
);
insert into emp
values(
 7698, 'BLAKE', 'MANAGER', 7839,
 to_date('1-5-1981','dd-mm-yyyy'),
 2850, null, 30
);
insert into emp
values(
 7782, 'CLARK', 'MANAGER', 7839,
 to_date('9-6-1981','dd-mm-yyyy'),
 2450, null, 10
);
insert into emp
values(
 7566, 'JONES', 'MANAGER', 7839,
 to_date('2-4-1981','dd-mm-yyyy'),
 2975, null, 20
);
insert into emp
values(
 7788, 'SCOTT', 'ANALYST', 7566,
 to_date('13-JUL-87','dd-mm-rr') - 85,
 3000, null, 20
);
insert into emp
values(
 7902, 'FORD', 'ANALYST', 7566,
 to_date('3-12-1981','dd-mm-yyyy'),
 3000, null, 20
);
insert into emp
values(
 7369, 'SMITH', 'CLERK', 7902,
 to_date('17-12-1980','dd-mm-yyyy'),
 800, null, 20
);
insert into emp
values(
 7499, 'ALLEN', 'SALESMAN', 7698,
 to_date('20-2-1981','dd-mm-yyyy'),
 1600, 300, 30
);
insert into emp
values(
 7521, 'WARD', 'SALESMAN', 7698,
 to_date('22-2-1981','dd-mm-yyyy'),
 1250, 500, 30
);
insert into emp
values(
 7654, 'MARTIN', 'SALESMAN', 7698,
 to_date('28-9-1981','dd-mm-yyyy'),
 1250, 1400, 30
);
insert into emp
values(
 7844, 'TURNER', 'SALESMAN', 7698,
 to_date('8-9-1981','dd-mm-yyyy'),
 1500, 0, 30
);
insert into emp
values(
 7876, 'ADAMS', 'CLERK', 7788,
 to_date('13-JUL-87', 'dd-mm-rr') - 51,
 1100, null, 20
);
insert into emp
values(
 7900, 'JAMES', 'CLERK', 7698,
 to_date('3-12-1981','dd-mm-yyyy'),
 950, null, 30
);
insert into emp
values(
 7934, 'MILLER', 'CLERK', 7782,
 to_date('23-1-1982','dd-mm-yyyy'),
 1300, null, 10
);
 
 
commit;
select * from emp join dept on emp.deptno = dept.deptno;
/*Ejercicio 1: Obtener el nombre de todos los departamentos en minúsculas.*/
select lower(dname) from dept;

/*Ejercicio 2: Seleccionar todos los datos de la tabla empleados (todas las columnas).*/
select * from emp;

/*Ejercicio 3: Devuelve ename, job, sal y comm de los empleando usando los siguientes alias de columnas: nombre, puesto, salario y comisión.*/
select ename "nombre", job "puesto", sal "salario", comm "comisión" from emp;

/*Ejercicio 4: Calcula cuántas semanas completas (de lunes a domingo) ha trabajado cada empleado, y devuelve dicho valor y el nombre del empleado. El número de*/
select round((sysdate - hiredate),0) from emp;

/*Ejercicio 5: Calcular el sueldo neto de cada empleado, y la retencion iRPF mensual, sabiendo que la retención es del 19% para el sueldo y de un 10% de la comisión,
(redondear a 2 decimales). Si el empleado no tiene comisión, se debe mostrar el valor 0.*/
select sal*0.81, nvl(comm * 0.90,0) from emp;

/*Ejercicio 6: Hacer un listado de empleados (nombre y salario) con sueldo superior a 1000.*/
select ename, sal from emp where sal > 1000;

/*Ejercicio 7: Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto igual a CLERK.*/
select ename, job, sal, comm from emp where job like 'CLERK';

/*Ejercicio 8: Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto distinto a CLERK.*/
select ename, job, sal, comm from emp where job not like 'CLERK';

/*Ejercicio 9: Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto distinto a CLERK y sueldo superior a 1500.*/
select ename, job, sal, comm from emp where job not like 'CLERK' and sal > 1500;

/*Ejercicio 10: Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan asignada comisión.*/
select ename, job, sal, comm from emp where comm is not null;
select ename, job, sal, comm from emp where comm not like 'null';

/*Ejercicio 11: Hacer un listado de empleados (nombre, puesto, sueldo, comision) que NO tengan asignada comisión.*/
select ename, job, sal, comm from emp where comm is null;

/*Ejercicio 12: Seleccionar los empleados cuyo nombre empieza por 'A'.*/
select ename from emp where ename like 'A%';

/*Ejercicio 13: Seleccionar los empleados cuyo nombre tienen una A en cualquier posición.*/
select ename from emp where instr(ename,'A') > 0;

/*Ejercicio 14: Seleccionar los empleados cuyo nombre no contiene ninguna 'A'.*/
select ename from emp where instr(ename,'A') = 0;

/*Ejercicio 15: Seleccionar los empleados cuyo nombre empieza por una vocal.*/
select ename from emp where ename like 'A%' or ename like 'E%' or ename like 'I%' or ename like 'O%' or ename like 'U%';

/*Ejercicio 16: Seleccionar los empleados con sueldo entre 1000 y 2000 (ambos inclusive).*/
select * from emp where sal > 999 and sal < 2001;

/*ejercicio 17: Seleccionar los empleados con sueldo igual a 1000, 2000, 3000, 4000 o 5000.*/
select * from emp where sal = 1000 or sal = 2000 or sal = 3000 or sal = 4000 or sal = 5000;

/*Ejercicio 18: Seleccionar los empleados cuyo nombre comienza por A,B,C,J,K,M.*/
select ename from emp where ename like 'A%' or ename like 'B%' or ename like 'C%' or ename like 'J%' or ename like 'K%' or ename like 'M%';

/*Ejercicio 19: Seleccionar los empleados cuyo sueldo es la 5000/2 + 500 o 5000-1000.*/
select * from emp where sal = (5000/2+500) or sal = (5000-1000);

/*Ejercicio 20: Seleccionar los empleados cuyo sueldo es la 5000/2 + 500 ,5000-1000 o el salario máximo de todos los empleados.*/
select * from emp where sal = (5000/2+500) or sal = (5000-1000) or sal = (select max(sal) from emp);