package Ejercicio_56;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> mapa = new HashMap<>();
		int numIntroducido;
		do {
			System.out.println("Introduce numeros enteros\nIntroduca 0 cuando quiera dejar de introducir");
			numIntroducido = sc.nextInt();
			if(numIntroducido !=0) {
				if(mapa.containsKey(numIntroducido)) {
					mapa.put(numIntroducido, mapa.get(numIntroducido)+1);
				}else {
					mapa.put(numIntroducido, 1);
				}
			}
		}while(numIntroducido != 0);
		
		for(Integer key : mapa.keySet()) {
			System.out.println("Número " + key + ": "+ mapa.get(key)+ " veces.");
		}

	}

}
