import java.util.Scanner;
public class Ejercicio_11 {
		public final static String RESPUESTA = "repita su correo";
		public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String correo;
		int posiArroba;
		int posiPunto;
		boolean comprobador = false;
		
		System.out.println("Validación de correo electronico, por favor escribe tu correo electronico.");
		do {
			correo = scanner.nextLine();
			correo = correo.trim();
			posiArroba = correo.indexOf("@");
			posiPunto = correo.lastIndexOf(".");
			
			if ((posiArroba <0)&&(posiPunto <0)) {
				System.out.println("son obligatorios el arroba y el punto despues del dominio");
				System.out.println(RESPUESTA);
			}
			else if (posiArroba < 0) {
				System.out.println("es obligatorio el arroba");
				System.out.println(RESPUESTA);
			}
			else if(posiPunto <0){
				System.out.println("es obligatorio el punto despues del dominio");
				System.out.println(RESPUESTA);
			}
			else if((posiArroba +1)>=posiPunto){
				System.out.println("es obligatorio poner el dominio");
				System.out.println(RESPUESTA);
			}
			else if((correo.length())== (posiPunto+1)) {
				System.out.println("es obligatorio poner .(algo) despues del dominio");
				System.out.println(RESPUESTA);
			}
			else {
				comprobador = true;
			}
			
		}while (comprobador != true);
			System.out.println("Su correo electornico "+correo+" es correcto");
			
	}
}
