package Ejercicio_33;

public class App {
	public static void main(String[] args) {
		Semaforo semaforo1 = new Semaforo();
		
		semaforo1.setColor("marron");
		System.out.println(semaforo1);
		
		semaforo1.setColor("verde");
		semaforo1.setParpadeando(true);
		System.out.println(semaforo1);
		
		semaforo1.setColor("ambar");
		semaforo1.setParpadeando(true);
		System.out.println(semaforo1);
		
		for(int i = 0; i<5;i++) {
			semaforo1.cambiarEstado();
		}
		
		Semaforo semaforo2 = new Semaforo();
		semaforo2.setColor(semaforo1.getColor());
		semaforo2.setParpadeando(semaforo1.getParpadeando());
	}

}
