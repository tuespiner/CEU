package Ejercicios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import Ejercicios.modelo.Persona;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("\nEjercicio 1\n");
		ejercicio1();
		System.out.println("\nEjercicio 2\n");
		ejercicio2();
		System.out.println("\nEjercicio 3\n");
		ejercicio3();
		System.out.println("\nEjercicio 4\n");
		ejercicio4();
		System.out.println("\nEjercicio 5\n");
		ejercicio5();
		System.out.println("\nEjercicio 6\n");
		ejercicio6();
		System.out.println("\nEjercicio 7\n");
		ejercicio7();
		System.out.println("\nEjercicio 8\n");
		ejercicio8();
		System.out.println("\nEjercicio 9\n");
		ejercicio9();
		System.out.println("\nEjercicio 10\n");
		ejercicio10();
		System.out.println("\nEjercicio 11\n");
		System.out.println("\nEjercicio 12\n");
		System.out.println("\nEjercicio 13\n");
		System.out.println("\nEjercicio 14\n");
		System.out.println("\nEjercicio 15\n");

	}
	
	public static void ejercicio1() {
		List<String> lista = new ArrayList<>();
		lista.add("Juan");
		lista.add("Lucia");
		lista.add("Ana");
		lista.add("Alvaro");
		lista.add("Pablo");
		lista.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
		
	}
	public static void ejercicio2() {
		List<String> lista = new ArrayList<>();
		lista.add("Juan");
		lista.add("Lucia");
		lista.add("Ana");
		lista.add("Alvaro");
		lista.add("Pablo");
		lista.stream().filter(n -> n.startsWith("A")).map(String::toUpperCase).sorted().forEach(System.out::println);;
	}
	public static void ejercicio3() {
		String[] array = {"hola", "que", "tal","me","llamo"};
		Arrays.stream(array).map(n -> n.substring(0, 1)).forEach(System.out::println);;
	}
	public static void ejercicio4() {
		String[] array = {"hola", "que", "tal","me","llamo"};
		List<Integer> lista =  Arrays.stream(array).map(n -> n.length()).toList();
		for(Integer i : lista) {
			System.out.println(i);
		}
	}
	public static void ejercicio5() {
		String[] array = {"hola", "que", "tal","me","llamo"};
		Arrays.stream(array).filter(n -> n.length() >= 5).forEach(System.out::println);
	}
	public static void ejercicio6() {
		Integer[] enteros = {1, 5, 9, 10, 4, 4, 8, 17, 54, 9};
		Arrays.stream(enteros).filter(n -> (n % 2) == 0).forEach(System.out::println);
	}
	public static void ejercicio7() {
		Integer[] enteros = {1, 5, 9, 10, 4, 4, 8, 17, 54, 9};
		Stream<Integer> stream = Arrays.stream(enteros);
		int i = stream.reduce(1,(n, N) -> n*N);
		System.out.println(i);
	}
	public static void ejercicio8() {
		Double[] precios = {12.5, 22.0, 1.5, 12.0, 50.55};
		List<Double> lista = Arrays.stream(precios).filter(n -> n >= 20).toList();
		for(Double precio : lista) {
			System.out.println(precio);
		}
	}
	public static void ejercicio9() {
		Persona persona1 = new Persona("Juan", 18);
		Persona persona2 = new Persona("Lucia", 23);
		Persona persona3 = new Persona("Ana", 25);
		Persona persona4 = new Persona("Alvaro", 20);
		Persona persona5 = new Persona("Pablo", 30);
		List<Persona> personas = Arrays.asList(persona1, persona2, persona3, persona4, persona5);
		personas.stream().filter(n -> n.getEdad() >= 25).sorted((n, N) -> n.getNombre().compareTo(N.getNombre())).forEach(n -> System.out.println(n.getNombre() + "(" + n.getEdad()+ ")"));
	}
	
	public static void ejercicio10() {
		Integer[] enteros = {1, 5, 9, 10, 4, 4, 8, 17, 54, 9};
		List<Integer> lista = Arrays.stream(enteros).filter(n -> n%2 == 0).map(n -> n*n).toList();
		for(Integer i : lista) {
			System.out.println(i);
		}
	}
	public static void ejercicio11() {
		
	}

}
