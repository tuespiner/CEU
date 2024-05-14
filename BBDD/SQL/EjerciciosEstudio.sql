/*Aqui voy a ponerme a estudiar, a ver si consigo aprobar bbdd mañana, 
primero voy a escribir como se escriben todas las cosas que hemos visto 
y una pequeña descripcion de como funciona,para que sirve etc.
(cosas como funciones, etc solo voh a poner como se escribe)*/

/*FUNCIONES*/
create or replace function nombreFuncion() return number
is
begin
end;
/

/*PROCEDURE*/

create or replace Procedure nombreProcedure(/*parametros*/)
is
begin
end;
/

/*SCANNER EN SQL*/

declare
    porquenova VARCHAR2(30) := &Dime_una_frase;
begin
    dbms_output.put_line('frase introducida: ' || porquenova);
end;
/

/*IF*/

if /*condicion*/ then
elsif /*condicion*/ then
else
end if;


/*CASE*/
case /*Se pone la variable con el valor que queramos hacer el case*/
    when /*caso 1*/ then
    when /*caso 2*/then
    else
    end case;
    

/*LOOP
hay tres loop, el normal, el for y el while
LOOP*/

loop
    /*instrucciones*/
end Loop;

/*WHILE*/

while /*condicion*/ loop
    /*instrucciones*/
end loop;

/*FOR*/
for /*indice*/ in /*se puede poner reverse para que sea al reves*/ /*valor inicial*/ /*valor final*/ loop
    /*instrucciones*/
end loop;






/*EJERCICIOS*/

/*Ejercicio1 : Se quiere realizar ciertas operaciones sobre las tablas dept y emp:

1. Muestra por pantalla el nombre de cada departamento, seguido por el salario medio de ese departamento con dos decimales.

    Ejemplo: RESEARCH: 2175, SALES: 1566,67, etc.

    **Nota: puedes poner un alias a los campos de tu select de un cursor explícito y luego llamarlo con notación de puntos. Ej.: cursor nombreCursor is select sum(a) 
    nombreAlias from ... y luego dbms_output.put_line(variableCursor.nombreAlias)**

2. Inserta un nuevo empleado en la tabla emp con los siguientes datos que debes pedirlos por teclado:
    empno: 7999
    ename: STEVEN
    job: MANAGER
    mgr: 7839
    hiredate: 01/01/23
    sal: 3000
    comm: 0
    deptno: 10

3. Devuelve el número total de empleados del departamento anterior.

4. Actualiza el salario de los empleados que cobren más del valor del salario medio actual. Debes subirle el sueldo de estos empleados 200 más. Debes mostrar el 
nombre de los trabajadores junto a su salario nuevo pero solo de los trabajadores que hayan visto modificado su salario.*/

--APARTADO 1
SET SERVEROUTPUT ON;
declare
    cursor vdname is 
        select distinct *
        from dept;
    filaCompleta dept%rowtype;
    noDep dept.dname%type;
    salMedio emp.sal%type;
begin
    open vdname;
        loop
        fetch vdname into filaCompleta;
        select sum(sal)/count(sal) into salMedio from emp where deptno = filaCompleta.deptno;
        if salMedio is null then
        salMedio := 0;
        end if;
        dbms_output.put_line(filaCompleta.dname || ': '|| salMedio);
        exit when vdname%notfound;
        end loop;
    close vdname;
end;
/

--APARTADO 2
declare
    empno emp.empno%type;
    ename emp.ename%type;
    introducirJob emp.job%type;
    mgr emp.mgr%type;
    hiredate emp.hiredate%type;
    sal emp.sal%type;
    comm emp.comm%type;
    deptno emp.deptno%type;
begin
    empno := &Dime_el_empno;
    ename := '&Dime_el_ename';
    introducirJob := '&Dime_el_trabajo';
    mgr := &Dime_el_mgr;
    hiredate := to_date('&Dime_la_fecha_en_este_orden_dia_mes_año', 'dd/mm/yy');
    sal := &Dime_el_salario;
    comm := &Dime_la_comision;
    deptno := &Dime_el_deptno;
    
    insert into emp values(empno,ename,introducirJob,mgr,hiredate,sal,comm,deptno);
    select empno into empno from emp where empno = 7999;
    dbms_output.put_line(empno);
end;
/
--APARTADO 3
declare
    totalEmpleados number(2);
begin
    select count(empno) into totalEmpleados from emp where deptno = 10;
    dbms_output.put_line(totalEmpleados);
end;
/
--APARTADO 4
declare
    salarioMedio emp.sal%type;
    cursor cambioSal is
    select sal, empno, ename from emp where sal > salarioMedio;
    salCursor emp.sal%type;
    empnoCursor emp.empno%type;
    enameCursor emp.ename%type;
begin
    select sum(sal)/count(empno) into salarioMedio from emp;
    open cambioSal;
        loop
            fetch cambioSal into salCursor, empnoCursor, enameCursor;
            salCursor := salCursor + 200;
            update emp set sal = salCursor where empno = empnoCursor;
            dbms_output.put_line(enameCursor || ' = ' || salCursor);
            exit when cambioSal%notfound;
        end loop;
    close cambioSal;
end;
/

/*Crea un procedimiento que se llame errorYear1981 que no tenga parámetros y que se encargue de modificar la tabla emp para que 
todos aquellos empleados que fueron contratados en el año 81 (hiredate) pasen a haber sido contratados en el año 82. Una vez actualizados 
los datos, mostrar por pantalla el número total de registros que hayan sido modificados con el siguiente mensaje "Se han actualizado xx filas de la tabla emp".

Crea un bloque de código anónimo que llame a este procedimiento errorYear1981.*/
create or replace procedure errorYear1981
as
    cursor hiredate1981 is
    select empno from emp where extract(year from hiredate) = 1981;
    empleadoA82 emp.empno%type;
begin
    open hiredate1981;
    loop
    fetch hiredate1981 into empleadoA82;
    update emp set hiredate = add_months(hiredate, 12) where empno = empleadoA82;
    exit when hiredate1981%notfound;
    end loop;
    close hiredate1981;
end;
/

delcare
begin
    errorYear1981();
end;
/

/*EJERCICIO 4
1. Crea una función obtenerNumMes que reciba como parámetro de entrada el nombre de un mes (ej.: SEPTIEMBRE, ENERO, JUNIO, etc.) 
y devuelva el número que corresponda a ese mes (09, 01, 06, etc.).

2. Crea una función obtenerSalEmpMes que reciba como parámetro de entrada el número de un mes y devuelva la suma total de los 
salarios de los empleados que fueron contratados en ese mes pasado como parámetro.

3. Crea un paquete llamado libreriaEmp que contenga las funciones obtenerNumMes y obtenerSalEmpMes.

4. Crea un procedimiento mostrarSumSalEmpMes que reciba por parámetro un mes con letras (ej.: SEPTIEMBRE, ENERO, JUNIO, etc.) y 
muestre por la pantalla la suma total de los salarios de los empleados que fueron contratados en ese mes. Para ello debes usar 
el paquete libreriaEmp y las dos funciones que contiene dentro de la librería.

5. Crea un bloque de código anónimo que guarde en una variable 'FEBRERO' y se le pase dicha variable al procedimiento mostrarSumSalEmpMes.

6. Excepciones a tener en cuenta:
    - El mes introducido con letras debe existir. En caso contrario, crear una excepción personalizada que indique "Ese mes no existe" y devolver -1.
    - Hay al menos un empleado en la tabla EMP que fuera contratado (hiredate) en ese mes. En caso contrario, crear una excepción personalizada que 
    indique por pantalla "No hay empleados contratados en ese mes" y devolver -1.*/
    
/*APARTADO 1*/
create or replace function obtenerNumMes(mes varchar2) return number
is
    fecha date;
begin
    fecha := to_date(mes, 'month');
    dbms_output.put_line(fecha);
end;
/

declare
begin
    obtenerNumMes('&dime_un_mes');
end;
/