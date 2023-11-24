
public class Ejercicio_2 {

	public static void main(String[] args) {
		String estrella = "*";
		String guion = "-";
		int cuadrado = 5;
		int estrella1 = 1;
		int estrella2 = 5;
		for(int i = 1;i<=cuadrado ;i++) {
			for(int x = 1; x <= cuadrado; x++) {
				
				if((x == estrella1)||(x==estrella2)) {
					System.out.print(estrella+" ");
				}else {
					System.out.print(guion+" ");
				}
			}
			estrella1 ++;
			estrella2--;
			System.out.println("");
		}

	}

}
