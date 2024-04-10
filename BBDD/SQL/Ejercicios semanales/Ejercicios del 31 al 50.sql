/*31. Calcular el último dia del mes (fecha) del mes actual.*/
select last_day(sysdate) from dual;

/*32. Calcular el último dia del mes (fecha) del mes actual, con horas, minutos y segundos.*/
select to_char(last_day(sysdate),'dd/mm/yyyy HH:mi:ss') from dual;

/*33. Calcular en qué MES (cifras) se ha contratado cada empleado.*/
select to_char(hiredate,'mm') from emp;

/*34. Calcular cuanto debería haber cobrado cada empleado en su primer año de trabajo (desde la fecha de contrato hasta el 31 de diciembre de ese año).*/
select ename, hiredate, sal, round(months_between(to_date('31/12/' || to_char(hiredate,'yyyy')), hiredate)),round(months_between(to_date('31/12/' || to_char(hiredate,'yyyy')), hiredate)*sal,2) from emp;

/*35. Cuantos oficios distintos hay en la tabla de empleados.*/
select count(distinct job )from emp;

/*36. Calcular el IRPF de cada empleado, teniendo en cuenta que para los 'CLERK' se les retiene un 15%, y a los 'ANALYST" un 20%. Al resto se les retiene un 19%.*/
select sal*0.19 "IRPF"  from emp where job != 'CLERK' and job != 'ANALYST' union select sal* 0.15 "IRPF" from emp where job = 'CLERK' union select sal*0.2 "IRPF" from emp where job = 'ANALYST';

/*37. Efectuar una propuesta de aumento salarial: Para los empleados del Dept. 10 un 5%, Dept. 20 un 7%, Dept 30 un 8% y al resto un 3% del salario.*/
select decode(deptno,10,sal*1.05,20,sal*1.7,30,sal*1.8,sal*1.3) from emp;

/*38. Listar los nombres de los empleados, identificando como 'Vendedor' si cobra comisión, y 'No vendedor' si no la cobra.*/
select ename "vendedor" from emp where comm is not null union select ename "No vendedor" from emp where comm is null; /*No se hacerlo*/

/*39. Calcular cuánto se paga mensualmente a todos los empleados.*/
select sum(sal)+sum(comm) from emp;

/*40. Calcular cuantos empleados hay.*/
select count(empno) from emp;

/*41. Calcular el sueldo medio de todos los empleados.*/
select round((sum(sal)+sum(comm))/count(empno),2) from emp;

/*42. Calcular la comisión media de todos los empleados (teniendo en cuenta aquellos que no tienen comisión).*/
select round(sum(comm)/count(empno),2) from emp;

/*43. Calcular la comisión media de los empleados que sí tienen comisión.*/
select round(sum(comm)/count(empno),2) from emp where comm is not null; 

/*44. Calcular la suma de los sueldos de los empleados del Departamento 20.*/
select sum(sal) from emp where deptno = 20; 

/*45. Calcular el sueldo medio de los empleados que pertenezcan al Dept 10 o 30.*/
select round((sum(sal)+sum(comm))/count(empno),2) from emp where deptno = 10 or deptno = 30;
/*46. Calcular la suma de sueldos que se pagan en cada uno de los departamentos 10 y 30 (por separado).*/
select sum(sal) from emp where deptno = 10 union select sum(sal) from emp where deptno = 30;

/*47. Calcular cuantos empleados se han contratado cada año.*/
select decode(hiredate,to_date('81','yy'),count(empno),to_date('82','yy'),count(empno),to_date('87','yy'),count(empno),to_date('80','yy'),count(empno)) from emp; /*tampoco se hacerlo*/

/*48. Calcular el sueldo máximo y mínimo de cada departamento.*/
select 'deptno 10: ' || max(sal) || ' ' || min(sal)  from emp where deptno = 10 union select 'deptno 20: ' ||max(sal) || ' ' || min(sal)  from emp where deptno = 20 
union select 'deptno 30: ' ||max(sal) || ' ' || min(sal)  from emp where deptno = 30 union select 'deptno 40: ' ||max(sal) || ' ' || min(sal)  from emp where deptno = 40;

/*49. Calcular cuanto se gana de media por cada oficio. Redondear a 2 decimales.*/
select 'presidente: ' || round((sum(sal)/count(empno)),2) from emp where job = 'PRESIDENT' union select 'manager: ' || round((sum(sal)/count(empno)),2) from emp where job = 'MANAGER'
    union select 'analista: ' || round((sum(sal)/count(empno)),2) from emp where job = 'ANALYST' union select 'empleado: ' || round((sum(sal)/count(empno)),2) from emp where job = 'CLERK'
    union select 'vendedor: ' || round((sum(sal)/count(empno)),2) from emp where job = 'SALESMAN';

/*50. Cuántos dias de vacaciones correspondieron a cada empleado el primer año de trabajo (contando 1 día por semana entera trabajada).*/
select ename , round((((round(months_between(to_date('31/12/' || to_char(hiredate,'yyyy')), hiredate)))*30)/7),0) || ' días' from emp;
