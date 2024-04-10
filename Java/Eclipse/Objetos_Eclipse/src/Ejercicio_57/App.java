package Ejercicio_57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Map<String,List<String>> mapa = new HashMap<>();
		Scanner sc =new Scanner(System.in);
		String cadIntroducida = "";
		String letraInic = "";
		do {
			System.out.println("Dime palabras, cuando quieras parar pon fin");
			cadIntroducida = sc.nextLine();
			letraInic= cadIntroducida.substring(0,1).toUpperCase();
			if(mapa.containsKey(letraInic)) {
				mapa.get(letraInic).add(cadIntroducida);
			}else {
				mapa.put(letraInic, new ArrayList<>());
				mapa.get(letraInic).add(cadIntroducida);
			}
		}while(!cadIntroducida.trim().equalsIgnoreCase("fin"));
		
		cadIntroducida = "";
		Set<String> keys = mapa.keySet();
		do{
			System.out.println("Dime letras, cuando quieras parar pon fin");
			cadIntroducida = sc.nextLine().trim().toUpperCase();
			if(keys.contains(cadIntroducida)) {
				System.out.println("Hay "+mapa.get(cadIntroducida).size()+" palabras que empiezan por "+cadIntroducida);
				for(String cad : mapa.get(cadIntroducida)) {
					System.out.println("> "+cad);
				}
			}else {
				System.out.println("No hay palabras que empiecen por "+ cadIntroducida+"\n");
			}
		}while(!cadIntroducida.trim().equalsIgnoreCase("fin"));
		
		
	}

}
