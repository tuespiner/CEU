
public class Ejercicio_20_repaso {

	public static void main(String[] args) {
		String barra = "-";
		String estrella = "*";
		int posiEstrella = 0;
		for(int i = 0; i != 5; i++) {
			for(int x = 0;x != 5; x++) {
				if (posiEstrella != x) {
					System.out.print(barra+" ");
				}else {
					System.out.print(estrella +" ");
				}
			}
			posiEstrella+=1;
			System.out.println("");
		}

	}

}
