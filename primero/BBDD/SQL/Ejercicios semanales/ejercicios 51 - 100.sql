/*51. Que dia de la semana se contrato a cada empleado.*/
select ename || ' ' || to_char(hiredate,'day') from emp;
/*52. Calcular la paga de beneficios que corresponde a cada empleado (3 salarios mensuales incrementados un: 10% para PRESIDENT, 20% para los MANAGER, 30% para el resto).*/
select ename || ' ' || decode(job,'PRESIDENT',sal*3.10,'MANAGER',sal*3.20,sal*3.30) || '€' from emp;
/*53. Cuantos dias han pasado desde el 25 julio de 1992.*/
select round(sysdate - to_date('15/7/1992','dd/mm/yyyy')) || 'dias' from dual;
/*54. Seleccionar el nombre de cada empleado junto al nombre del departamento en el que estï¿½.*/
select ename, job from emp;
/*55. Seleccionar el nombre y puesto de cada empleado junto al nombre del departamento al que pertenece y la localizaciï¿½n del departamento.*/
select emp.ename, emp.job, dept.dname, dept.loc from emp join dept on emp.deptno = dept.deptno;
select * from emp join dept on emp.deptno = dept.deptno;
/*56. Seleccionar el nombre de cada empleado, el nombre de! departamento al que pertenece, y el codigo de departamento del empleado.*/
select emp.ename, dept.dname, dept.deptno from emp join dept on emp.deptno = dept.deptno;
/*57. Listar el nombre del empleado y el nombre de su jefe.*/
select e1.ename, e2.ename from emp e1, emp e2  where e1.mgr = e2.empno;
/*58. Listar el nombre del empleado y el nombre de su jefe. Incluir empleados que no tengan jefe.*/
select e1.ename, e2.ename from emp e1, emp e2  where e1.mgr = e2.empno(+);
/*59. Seleccionar nombre del empleado, nombre del jefe, fechas contrato del trabajador y del jefe, de forma que la fecha de contrato del empleado sea anterior a la de su jefe.*/
select e1.ename,e1.hiredate, e2.ename,e2.hiredate from emp e1, emp e2  where e1.mgr = e2.empno and e1.hiredate < e2.hiredate;
/*60. Seleccionar nombre del empleado, nombre del jefe, salarios del trabajador y del jefe, de forma que el sueldo del empleado sea inferior a la mitad del salario de su jefe.*/
select e1.ename,e1.sal, e2.ename,e2.sal from emp e1, emp e2  where e1.mgr = e2.empno and e1.sal < e2.sal/2;
/*61. Seleccionar las distintas ubicaciones de los departamentos.*/
select deptno, loc from dept;
/*62. Seleccionar la ubicaciï¿½n y el nombre empleado. Incluir tambiï¿½n las ubicaciones de departamentos sin empleados.*/
select * from emp join dept on emp.deptno = dept.deptno; 
select dept.loc, emp.ename from emp join dept on emp.deptno(+) = dept.deptno; 
/*63. Seleccionar el nombre de los empleados, y el departamento al que pertenecen, para los empleados que ganan menos de 1000$.*/
select dept.loc, emp.ename from emp join dept on emp.deptno(+) = dept.deptno where emp.sal < 1000; 
/*64. Seleccionar el nombre del empleado, y el departamento al que pertenecen, para los empleados que ganan mï¿½s de 1000$.*/
select dept.loc, emp.ename from emp join dept on emp.deptno(+) = dept.deptno where emp.sal > 1000; 
/*65. Consultar todos los valores de la tabla emp.*/
select * from emp;
/*66. Listar el nombre, el oficio y sueldo de los empleados.*/
select ename, job, sal from emp;
/*67. Calcular el sueldo anual que percibe cada empleado.*/
select ename, sal*12 from emp;
/*68. Consultar los datos de la tabla DEPTS.*/
select * from dept;
/*69. Listar los diferentes puestos de los empleados sin repetir.*/
select distinct job from emp;
/*70. Listar en una sola columna el nombre y el puesto de cada empleado.*/
select ename || ', ' || job from emp;
/*71. Listar todas las columnas de la tabla EMP en una ï¿½nica columna, separando cada campo por comas.*/
select empno || ', ' || ename || ', ' || job || ', ' || mgr || ', ' || hiredate || ', ' || sal || ', ' || comm || ', ' || deptno from emp;
/*72. Listar el nombre y sueldo de los empleados que ganan mï¿½s de 2000$.*/
select ename, sal from emp where sal > 2000;
/*73. Listar el nombre y cï¿½digo de de departamento del empleado con id=30.*/
select ename, deptno from emp where deptno = 30;
/*74. Listar el nombre y sueldo de los empleados que NO ganan entre 5000 y 12000 dï¿½lares. Muestra el sueldo con el sï¿½mbolo de $ delante de la cifra.*/
select ename, sal from emp where sal not between 5000 and 12000;
/*75. Listar el nombre, puesto y fecha contrato de los empleados contratados entre el 20 febrero 1981 y el 1 de mayo de 1981. Ordenar por fecha descendente.*/
select ename, job, hiredate from emp where hiredate between '20/2/1981' and '1/5/1981';
/*76. Listar el nombre y el cod departamento de los empleados pertenecientes a los departamentos 20 o 40.*/
select ename, deptno from emp where deptno = 20 or deptno = 40;
/*77. Listar el nombre (alias: Empleado) y sueldo (alias: Salario mensual) de los empleados pertenecientes a los departamentos 20 o 40, que ganen entre 2000 y 4000 dï¿½lares.*/
select ename "Empleado", sal "Salario mensual" from emp where sal between 2000 and 4000 and deptno = 20 or deptno = 40;
/*78. Listar el nombre y fecha contrato de empleados contratados el aï¿½o 1984.*/
select ename, hiredate from emp where hiredate between '1/1/1984' and '31/12/1984';
/*79. Listar el nombre y el puesto de los empleados que no tengan jefe asignado.*/
select ename, job from emp where mgr is null;
/*80. Listar el nombre, sueldo y % comisiï¿½n de los empleados que cobran comisiï¿½n. Ordenar por salario y comisiï¿½n, de forma que los mï¿½s altos salgan primero.*/
select ename, sal, comm from emp where comm is not null and comm > 0 order by comm desc;
/*81. Listar el nombre de los empleados que tengan una 'a' en la 3a letra del nombre.*/
select ename from emp where ename like '__A%';
/*82. Listar el nombre de los empleados que tengan una 'a' y una 'e' en el nombre.*/
select ename from emp where ename like '%A%' and ename like '%E%';
/*83. Listar el nombre, puesto y sueldo de los empleados 'CLERK' o 'SALESMAN', y con salario distinto de: 2500, 3500 y 7000.*/
select ename, job, sal from emp where job = 'CLERK' or job = 'SALESMAN' and sal != 2500 and sal != 3500 and sal != 7000;
/*84. Listar el nombre (alias: Empleado), sueldo (alias: Salario mensual) y nombre del departamento de todos los empleados cuya comisiï¿½n sea mayor de 400.*/
select emp.ename "Empleado", emp.sal "Salario mensual", dept.dname from emp join dept on emp.deptno = dept.deptno where emp.comm > 400; 
/*85. Listar el nombre y salario de los empleados, de forma que estï¿½n separados por una lï¿½nea de puntos, y que de extremo a extremo haya 30 caracteres (por ejemplo: "KING......................5000").*/

/*86. Listar los nombres de los empleados, reemplazando la letra 'a' por un '1'.*/
select replace(ename,'A','L') from emp;
/*87. Obtener la fecha del sistema (hoy) con alias: Fecha en el formato por defecto (sin tocar nada).*/
select sysdate "Fecha en el formato por defecto" from dual;
/*88. Listar el id, nombre, salario de los empleados, y ademï¿½s otra columna con el salario incrementado un 15% su valor y redondeado (alias: Nuevo salario).*/
select empno || ', ' || ename || ', ' || sal, sal*1.15 "Nuevo salario" from emp;
/*89. Listar el id, nombre, salario de los empleados, el salario incrementado un 15% redondeado (alias: Nuevo salario) y ademï¿½s otra columna con la cuantï¿½a del incremento (alias: Incremento).*/
select empno || ', ' || ename || ', ' || sal, sal*1.15 "Nuevo salario", sal*0.15 "Incremento" from emp;
/*90. Listar el nombre y longitud del nombre de los empleados que empiecen por A, o M. (Los nombres tendrï¿½n la inicial en mayï¿½scula y el resto en minï¿½sculas).*/
select initcap(ename), length(ename) from emp where ename like 'A%' or ename like 'M%';
/*91. Listar el nombre y nï¿½mero de meses trabajados, redondeando al entero superior. Ordenar por nï¿½mero de meses trabajados, de menor a mayor.*/
select ename, round(months_between(sysdate, hiredate)) from emp order by round(months_between(sysdate, hiredate));
/*92. Componer una frase con el nombre, salario actual y el triple del salario de los empleados. Por ejemplo: "KING gana 5000 mensuales, pero querrï¿½a ganar 15000" (alias: Sueldos soï¿½ados).*/
select ename || ' gana ' || sal || ', pero le gustaria ganar ' || sal*3 "Sueldo soñado" from emp;
/*93. Listar el nombre y salario de los empleados, rellenando por la izquierda hasta 15 caracteres con el sï¿½mbolo "$".*/
/*94. Listar nombre, fecha contrato y fecha revisiï¿½n contrato de los empleados, sabiendo que la revisiï¿½n serï¿½ el lunes siguiente a la fecha que cumple 6 meses
de trabajo en la empresa. Formatear esta fecha de acuerdo con el ejemplo: 'Lunes, 12th de noviembre de 2005'.*/
select ename, hiredate, to_char(next_day((add_months(hiredate,6)),1), 'DAY ", " ddspth " de " month yyyy') from emp;
/*95. Listar nombre, fecha contrato y dï¿½a de la semana en que fueron contratados los empleados, ordenando por dï¿½a de la semana, de forma que queden ordenados por 
lunes, martes, miï¿½rcoles, jueves, viernes, sï¿½bado y domingo.*/
select ename, hiredate, to_char(hiredate, 'day') from emp order by to_char(hiredate,'day');
/*96. Listar nombre y comisiï¿½n de los empleados. En el caso de que no gane comisiï¿½n, sacar la frase "Sin comisiï¿½n".*/
select ename, nvl(to_char(comm),'Sin comision') from emp;
/*97. Listar nombre de los empleados, y una tira de asteriscos, de forma que haya un asterisco por cada 1000$ (redondeada) que gana el empleado. Titula la columna 'Empleado y su salario'. Ordenar esta
columna de forma que los que mï¿½s ganan aparezcan primero. Los nombres deben quedar ajustados a la longitud del nombre mï¿½s largo. Ej.: "KING..:  *****"*/

/*98. Listar los distintos nombres de puestos de los empleados, de forma que : PRESIDENT se traduzca por A, MANAGER por B, ANALYST por C, CLERK por D y el resto por E.*/
select job, decode(job,'PRESIDENT','A','MANAGER','B','ANALYST','C','CLERK','D','E') from emp;
/*99. Listar todos los campos de la tabla DEPT.*/
select * from dept;
/*100. Seleccionar el nombre de departamento, y el nombre de la ciudad donde estï¿½.*/
select dname, loc from dept;