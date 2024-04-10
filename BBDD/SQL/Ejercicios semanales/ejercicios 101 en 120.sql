/*101. Listar las diferentes ciudades de la tabla sin repetición explícitamente (aunque no haya datos que se repitan).*/
select loc from dept;
/*102. Listar el nombre de departamento y nombre de ciudad para los departamentos ubicados en  en New York y Dallas.*/
select dname, loc from dept where loc = 'NEW YORK' or loc = 'DALLAS';
/*103. Seleccionar el nombre de los empleados y el nombre de la ciudad donde está el departamento al que pertenecen.*/
select emp.ename, dept.loc from emp join dept on emp.deptno = dept.deptno;
/*104. Listar el nombre de los trabajadores, puesto, nombre del departamento y ciudad del departamento de aquellos que no son MANAGER.*/
select emp.ename, emp.job, dept.dname, dept.loc from emp join dept on emp.deptno = dept.deptno where emp.job = 'MANAGER';
/*105. Listar el nombre de los trabajadores, puesto, nombre del departamento y ciudad del departamento de aquellos que no son ni ANALYST ni CLERK.*/
select emp.ename, emp.job, dept.dname, dept.loc from emp join dept on emp.deptno = dept.deptno where emp.job != 'ANALYST' or emp.job != 'CLERK';
/*106. Seleccionar el nombre del empleado, código y nombre del departamento al que pertenecen los empleados.*/
select emp.ename, emp.deptno, dept.dname from emp join dept on emp.deptno = dept.deptno;
/*107. Seleccionar el nombre de los empleados que trabajan en el departamento cuyo código es el más bajo de todos los existentes (utiliza subconsultas).*/
select ename from emp where deptno = (select min(deptno) from dept);
/*108. Seleccionar nombre de empleado, nombre de departamento y ubicación del departamento para los empleados que tienen comisión.*/
select emp.ename, dept.dname, dept.loc from emp join dept on emp.deptno = dept.deptno where emp.comm is not null;
/*109. Seleccionar nombre de empleado, nombre de departamento y localización, para los empleados que no tienen comisión (o esta vale cero).*/
select emp.ename, dept.dname, dept.loc from emp join dept on emp.deptno = dept.deptno where emp.comm is not null and emp.comm > 0;
/*110. Seleccionar nombre de empleado y nombre de departamento para los empleados que tengan una 'a' en su nombre.*/
select emp.ename, dept.dname from emp join dept on emp.deptno = dept.deptno where emp.ename like '%A%';
/*111. Seleccionar nombre de empleado y nombre departamento para los empleados que tengan una vocal al menos (a, e, i, o, u) en su nombre.*/
select emp.ename, dept.dname from emp join dept on emp.deptno = dept.deptno where emp.ename like '%A%' or emp.ename like '%E%' or emp.ename like '%I%' or emp.ename like '%O%' or emp.ename like '%U%';
/*112. Seleccionar nombre y puesto de empleado, código de departamento y nombre de departamento de los empleados cuyo departamento está ubicado en 'Chicago'. Todos los valores deben devolverse en minúsculas.*/
select * from emp join dept on emp.deptno = dept.deptno;
select lower(emp.ename), lower(emp.job), emp.deptno, lower(dept.dname) from emp join dept on emp.deptno = dept.deptno where dept.loc = 'CHICAGO';
/*113. Seleccionar nombre, código de empleado, nombre de su jefe y código de empleado de su jefe para todos los empleados (no se deben mostrar los que no tienen jefe).*/
select a.ename, a.empno, b.ename, b.empno from emp a, emp b where a.mgr = b.empno;
/*114. Seleccionar nombre, código de empleado, nombre de su jefe y código de empleado de su jefe para todos los empleados (se deben mostrar TODOS, incluso los que no tienen jefe).*/
select a.ename, a.empno, b.ename, b.empno from emp a, emp b  where a.mgr = b.empno(+);
/*115. Seleccionar código departamento, nombre de empleado y nombre de jefe de cada empleado del departamento que está en Boston.*/
select a1.deptno, a1.ename, a2.ename from emp a1 join emp a2 on a1.mgr = a2.empno join dept on a1.deptno = dept.deptno where a1.mgr = a2.empno and dept.loc = 'BOSTON'; 
/*116. Seleccionar nombre y fecha contrato de los empleados contratados posteriormente al empleado 'WARD'.*/
select ename, hiredate from emp where hiredate > (select hiredate from emp where ename = 'WARD');
/*118. Seleccionar nombre y fecha de contrato de los empleados, además del nombre y fecha de contrato de su jefe, siempre y cuando la fecha del
contrato del empleado fuera anterior a la fecha de contrato de su jefe.*/
select a.ename, a.hiredate from emp a, emp b where a.mgr = b.empno and a.hiredate < b.hiredate;
/*119. Listar todos los nombres cuya longitud sea menor que la media de todas las longitudes de nombres de empleados redondeado al entero superior.*/
select count(ename) from emp where length(ename) < (select sum(length(ename))/count(empno) from emp);
/*120. Seleccionar el nombre de los empleados y el nombre del departamento al que pertenecen, siempre y cuando el nombre del departamento comience por la letra 'S'.*/
select emp.ename, dept.dname from emp join dept on emp.deptno = dept.deptno where dept.dname like 'S%';