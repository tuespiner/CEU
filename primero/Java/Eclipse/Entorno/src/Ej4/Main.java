package Ej4;
public class Main {

    public static void main(String[] args) {
        CCuenta miCuenta;

        miCuenta = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        operarCuenta(miCuenta, 200);
    }

	private static void operarCuenta(CCuenta miCuenta, double newParam) {
		double saldoActual;
		saldoActual = miCuenta.estado();
        System.out.println("El saldo actual es"+ saldoActual );

        try {
            miCuenta.retirar(2300);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            miCuenta.ingresar(695);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
	}
}
